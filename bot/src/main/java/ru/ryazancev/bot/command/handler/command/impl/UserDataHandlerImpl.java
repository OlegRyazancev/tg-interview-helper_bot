package ru.ryazancev.bot.command.handler.command.impl;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.ryazancev.bot.command.handler.command.UserDataHandler;

/**
 * @author Oleg Ryazancev
 */

@Component
public class UserDataHandlerImpl implements UserDataHandler {

    @Override
    public void handleUserDataCommand(SendMessage sendMessage) {

    }

    @Override
    public void handleDeleteCommand(SendMessage sendMessage) {

    }
}
