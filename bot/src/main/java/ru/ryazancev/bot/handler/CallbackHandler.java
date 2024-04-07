package ru.ryazancev.bot.handler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * @author Oleg Ryazancev
 */

public interface CallbackHandler {

    SendMessage handleCallback(Update update);
}
