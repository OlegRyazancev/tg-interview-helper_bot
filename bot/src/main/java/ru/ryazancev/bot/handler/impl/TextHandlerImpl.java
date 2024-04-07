package ru.ryazancev.bot.handler.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.ryazancev.bot.command.type.DefaultCommand;
import ru.ryazancev.bot.handler.CommandHandler;
import ru.ryazancev.bot.handler.TextHandler;
import ru.ryazancev.bot.util.CommandUtils;
import ru.ryazancev.bot.util.exception.UnknownCommandException;

import java.util.Map;

/**
 * @author Oleg Ryazancev
 */

@Component
@Slf4j
@RequiredArgsConstructor
public class TextHandlerImpl implements TextHandler {


    private final Map<DefaultCommand, CommandHandler> commandHandlers;


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

        commandHandlers.get(command).prepareMessage(message);
        return message;
    }
}
