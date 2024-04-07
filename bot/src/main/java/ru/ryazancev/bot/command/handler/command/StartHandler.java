package ru.ryazancev.bot.command.handler.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

/**
 * @author Oleg Ryazancev
 */

public interface StartHandler {

    void handleStartCommand(SendMessage sendMessage);
}
