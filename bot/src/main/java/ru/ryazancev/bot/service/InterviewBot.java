package ru.ryazancev.bot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import ru.ryazancev.bot.command.Button;
import ru.ryazancev.bot.command.creator.CommandCreator;
import ru.ryazancev.bot.handler.TextHandler;
import ru.ryazancev.bot.handler.impl.callback.EditMessageCallbackHandler;
import ru.ryazancev.bot.handler.impl.callback.SendMessageCallbackHandler;

import java.util.List;

/**
 * @author Oleg Ryazancev
 */

@Component
@Slf4j
public class InterviewBot extends TelegramLongPollingBot {

    @Value("${interview-bot.name}")
    private String name;

    private final TextHandler textHandler;
    private final SendMessageCallbackHandler sendMessageCallbackHandler;
    private final EditMessageCallbackHandler editMessageCallbackHandler;
    private final CommandCreator commandCreator;

    public InterviewBot(@Value("${interview-bot.token}") String botToken,
                        TextHandler textHandler,
                        SendMessageCallbackHandler sendMessageCallbackHandler,
                        EditMessageCallbackHandler editMessageCallbackHandler,
                        CommandCreator commandCreator) {
        super(botToken);
        this.textHandler = textHandler;
        this.sendMessageCallbackHandler = sendMessageCallbackHandler;
        this.editMessageCallbackHandler = editMessageCallbackHandler;
        this.commandCreator = commandCreator;
        setupCommands();
        log.info("23423");
    }

    @Override
    public void onUpdateReceived(Update update) {

        Object sendMessage;

        if (update.hasMessage() && update.getMessage().hasText()) {
            sendMessage = textHandler.handleTextUpdate(update);
        } else if (update.hasCallbackQuery()) {

            if (update.getCallbackQuery().getData().equals(Button.RUSSIAN_BUTTON.name()) || update.getCallbackQuery().getData().equals(Button.ENGLISH_BUTTON.name())) {
                sendMessage = editMessageCallbackHandler.handleCallback(update);
            } else {
                sendMessage = sendMessageCallbackHandler.handleCallback(update);
            }
        } else {
            sendMessage = SendMessage.builder()
                    .chatId(update.getMessage().getChatId())
                    .text("Unknown update")
                    .build();
        }

        sendMessage(sendMessage);
    }

    @Override
    public String getBotUsername() {
        return name;
    }

    private void setupCommands() {

        List<BotCommand> commands = commandCreator.createCommandList();
        try {
            this.execute(new SetMyCommands(commands, new BotCommandScopeDefault(), null));
        } catch (Exception e) {
            log.error("Exception " + e.getMessage());
        }
    }

    private void sendMessage(Object sendMessage) {
        try {

            if (sendMessage instanceof SendMessage) {
                execute((SendMessage) sendMessage);
                log.info("message executed " + ((SendMessage) sendMessage).getChatId());
            } else {
                execute((EditMessageText) sendMessage);
                log.info("message executed " + ((EditMessageText) sendMessage).getChatId());
            }


        } catch (Exception e) {
            log.error("Exception " + e.getMessage());
        }
    }
}

