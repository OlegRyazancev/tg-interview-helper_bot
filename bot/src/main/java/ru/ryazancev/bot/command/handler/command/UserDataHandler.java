package ru.ryazancev.bot.command.handler.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

/**
 * @author Oleg Ryazancev
 */

public interface UserDataHandler {

    void handleUserDataCommand(SendMessage sendMessage);

    void handleDeleteCommand(SendMessage sendMessage);
}
