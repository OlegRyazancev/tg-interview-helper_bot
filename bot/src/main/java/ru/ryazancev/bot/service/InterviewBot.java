package ru.ryazancev.bot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.ryazancev.bot.command.processor.CommandProcessor;
import ru.ryazancev.bot.command.creator.impl.DefaultCommandCreator;

import java.util.List;

/**
 * @author Oleg Ryazancev
 */

@Component
@Slf4j
public class InterviewBot extends TelegramLongPollingBot {

    @Value("${interview-bot.name}")
    private String name;

    public InterviewBot(@Value("${interview-bot.token}") String botToken) {
        super(botToken);
        setupCommands();
    }

    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return name;
    }

    private void setupCommands() {

        List<BotCommand> commands =
                CommandProcessor.createCommandList(DefaultCommandCreator::new);
        try {
            this.execute(new SetMyCommands(commands, new BotCommandScopeDefault(), null));
        } catch (TelegramApiException e) {
            log.error("Error setting bot's command list: " + e.getMessage());
        }
    }
}

