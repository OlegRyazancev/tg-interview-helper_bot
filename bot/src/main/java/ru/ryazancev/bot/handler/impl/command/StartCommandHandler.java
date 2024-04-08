package ru.ryazancev.bot.handler.impl.command;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.ryazancev.bot.command.type.DefaultCommand;
import ru.ryazancev.bot.handler.CommandHandler;
import ru.ryazancev.bot.kafka.KafkaProducer;
import ru.ryazancev.bot.service.DataFetcher;
import ru.ryazancev.bot.util.message.impl.SendMessageProcessor;
import ru.ryazancev.common.UserRegistrationRequest;

import java.util.Locale;

/**
 * @author Oleg Ryazancev
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class StartCommandHandler implements CommandHandler {

    private final SendMessageProcessor sendMessageProcessor;
    private final DataFetcher dataFetcher;
    private final KafkaProducer kafkaProducer;

    @Override
    public DefaultCommand getCommand() {
        return DefaultCommand.START;
    }

    @Override
    public SendMessage prepareMessage(Message message) {
        log.info("Handle command: {}", message.getText());

        String locale = dataFetcher.fetchUserLocaleTag(message.getChatId());

        SendMessage sendMessage = new SendMessage();

        if (locale != null) {
            sendMessage.setText(sendMessageProcessor.getMessage("message.start.hello", new Locale(locale), new Object[]{message.getFrom().getFirstName()}));
        } else {
            sendMessage.setText(sendMessageProcessor.getMessage("message.start.hello", new Object[]{message.getFrom().getFirstName()}));
        }

        sendMessage.setChatId(message.getChatId());


        UserRegistrationRequest request = UserRegistrationRequest.builder()
                .chatId(message.getChatId())
                .firstName(message.getFrom().getFirstName())
                .lastName(message.getFrom().getLastName())
                .username(message.getFrom().getUserName())
                .build();

        kafkaProducer.sendMessageToUserRegistrationTopic(request);


        return sendMessage;
    }
}
