package ru.ryazancev.bot.handler.impl.callback;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.ryazancev.bot.handler.CallbackHandler;

/**
 * @author Oleg Ryazancev
 */

public interface SendMessageCallbackHandler extends CallbackHandler<SendMessage> {
    @Override
    SendMessage handleCallback(Update update);
}
