package ru.ryazancev.bot.handler.impl.command;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.ryazancev.bot.command.Button;
import ru.ryazancev.bot.command.type.DefaultCommand;
import ru.ryazancev.bot.handler.CommandHandler;
import ru.ryazancev.bot.service.DataFetcher;
import ru.ryazancev.bot.util.message.impl.SendMessageProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author Oleg Ryazancev
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class LanguageCommandHandler implements CommandHandler {

    private final SendMessageProcessor sendMessageProcessor;
    private final DataFetcher dataFetcher;

    @Override
    public DefaultCommand getCommand() {
        return DefaultCommand.LANGUAGE;
    }

    @Override
    public SendMessage prepareMessage(Message message) {

        log.info("Handle command: {}", message.getText());

        long chatId = message.getChatId();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        String localeTag = dataFetcher.fetchUserLocaleTag(chatId);
        sendMessage.setText(sendMessageProcessor.getMessage("message.language.choose_language", Locale.forLanguageTag(localeTag), null));

        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("English");
        button1.setCallbackData(Button.ENGLISH_BUTTON.name());

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Russian");
        button2.setCallbackData(Button.RUSSIAN_BUTTON.name());
        rowInLine.add(button1);
        rowInLine.add(button2);

        rowsInLine.add(rowInLine);

        markup.setKeyboard(rowsInLine);
        sendMessage.setReplyMarkup(markup);
        return sendMessage;
    }
}
