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
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.ryazancev.bot.command.creator.impl.DefaultCommandCreator;
import ru.ryazancev.bot.command.handler.callback.CallbackQueryHandler;
import ru.ryazancev.bot.command.handler.command.CommandHandler;
import ru.ryazancev.bot.command.processor.CommandProcessor;

import java.util.List;

/**
 * @author Oleg Ryazancev
 */

@Component
@Slf4j
public class InterviewBot extends TelegramLongPollingBot {

    @Value("${interview-bot.name}")
    private String name;

    private final CommandHandler commandHandler;
    private final CallbackQueryHandler callbackQueryHandler;

    public InterviewBot(@Value("${interview-bot.token}") String botToken,
                        CommandHandler commandHandler,
                        CallbackQueryHandler callbackQueryHandler) {
        super(botToken);
        setupCommands();
        this.commandHandler = commandHandler;
        this.callbackQueryHandler = callbackQueryHandler;
    }

    @Override
    public void onUpdateReceived(Update update) {

        SendMessage sendMessage;

        if (update.hasMessage() && update.getMessage().hasText()) {
            sendMessage = commandHandler.handleTextUpdate(update);
        } else if (update.hasCallbackQuery()) {
            sendMessage = callbackQueryHandler.handleCallback(update);
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

        List<BotCommand> commands = CommandProcessor.createCommandList(DefaultCommandCreator::new);
        try {
            this.execute(new SetMyCommands(commands, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            log.error("Error setting bot's command list: " + e.getMessage());
        }
    }

    private void sendMessage(SendMessage sendMessage) {
        try {
            execute(sendMessage);
            log.info("message executed " + sendMessage.getChatId());
        } catch (TelegramApiException e) {
            log.error("Exception " + e.getMessage());
        }
    }
}

