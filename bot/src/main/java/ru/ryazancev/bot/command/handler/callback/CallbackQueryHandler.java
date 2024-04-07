package ru.ryazancev.bot.command.handler.callback;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * @author Oleg Ryazancev
 */

public interface CallbackQueryHandler {

    SendMessage handleCallback(Update update);
}
