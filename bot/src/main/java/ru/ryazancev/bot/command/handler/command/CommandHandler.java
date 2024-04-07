package ru.ryazancev.bot.command.handler.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * @author Oleg Ryazancev
 */

public interface CommandHandler {

    SendMessage handleTextUpdate(Update update);
}
