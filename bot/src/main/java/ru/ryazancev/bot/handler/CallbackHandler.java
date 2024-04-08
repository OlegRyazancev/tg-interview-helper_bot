package ru.ryazancev.bot.handler;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * @author Oleg Ryazancev
 */

public interface CallbackHandler<T> {
    T handleCallback(Update update);
}
