package ru.ryazancev.bot.command.handler.command.impl;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.ryazancev.bot.command.handler.command.LanguageHandler;

/**
 * @author Oleg Ryazancev
 */

@Component
public class LanguageHandlerImpl implements LanguageHandler {

    @Override
    public void handleLanguageCommand(SendMessage message) {

    }
}
