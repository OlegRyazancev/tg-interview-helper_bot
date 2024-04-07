package ru.ryazancev.bot.command.handler.command.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.ryazancev.bot.command.handler.command.*;
import ru.ryazancev.bot.command.type.DefaultCommand;
import ru.ryazancev.bot.util.CommandUtils;
import ru.ryazancev.bot.util.UnknownCommandException;

/**
 * @author Oleg Ryazancev
 */

@Component
@Slf4j
@RequiredArgsConstructor
public class DefaultCommandHandler implements CommandHandler {

    private final LanguageHandler languageHandler;
    private final StartHandler startHandler;
    private final UserDataHandler userDataHandler;
    private final HelpHandler helpHandler;

    @Override
    public SendMessage handleTextUpdate(Update update) {

        String text = update.getMessage().getText();

        SendMessage message = new SendMessage();
        message.setChatId(update.getMessage().getChatId());


        DefaultCommand command;
        try {
            command = CommandUtils.fromText(text, DefaultCommand.class);
        } catch (UnknownCommandException e) {
            log.error("Exception occurred: " + e.getMessage());
            message.setText("Unknown command " + text);
            return message;
        }


        switch (command) {
            case START -> {
                startHandler.handleStartCommand(message);
            }
            case USER_DATA -> {
                userDataHandler.handleUserDataCommand(message);
            }
            case DELETE_DATA -> {
                userDataHandler.handleDeleteCommand(message);
            }
            case HELP -> {
                helpHandler.handleHelpCommand(message);
            }
            case LANGUAGE -> {
                languageHandler.handleLanguageCommand(message);
            }
        }
        return message;
    }
}
