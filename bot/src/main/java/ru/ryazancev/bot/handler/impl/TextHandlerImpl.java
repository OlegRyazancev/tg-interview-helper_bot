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
        DefaultCommand command;
        try {
            command = CommandUtils.fromTextToCommand(text, DefaultCommand.class);
        } catch (UnknownCommandException e) {
            log.error("Exception occurred: " + e.getMessage());

            return SendMessage.builder()
                    .text("Unknown command " + text)
                    .chatId(update.getMessage().getChatId())
                    .build();
        }
        return commandHandlers.get(command)
                .prepareMessage(update.getMessage());
    }
}
