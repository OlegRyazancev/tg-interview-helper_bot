package ru.ryazancev.bot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import ru.ryazancev.bot.command.creator.CommandCreator;
import ru.ryazancev.bot.handler.CallbackHandler;
import ru.ryazancev.bot.handler.TextHandler;

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
    private final CallbackHandler callbackHandler;
    private final CommandCreator commandCreator;

    public InterviewBot(@Value("${interview-bot.token}") String botToken,
                        TextHandler textHandler,
                        CallbackHandler callbackHandler,
                        CommandCreator commandCreator) {
        super(botToken);
        this.textHandler = textHandler;
        this.callbackHandler = callbackHandler;
        this.commandCreator = commandCreator;
        setupCommands();
        log.info("23423");
    }

    @Override
    public void onUpdateReceived(Update update) {

        SendMessage sendMessage;

        if (update.hasMessage() && update.getMessage().hasText()) {
            sendMessage = textHandler.handleTextUpdate(update);
        } else if (update.hasCallbackQuery()) {
            sendMessage = callbackHandler.handleCallback(update);
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

    private void sendMessage(SendMessage sendMessage) {
        try {
            execute(sendMessage);
            log.info("message executed " + sendMessage.getChatId());
        } catch (Exception e) {
            log.error("Exception " + e.getMessage());
        }
    }
}

