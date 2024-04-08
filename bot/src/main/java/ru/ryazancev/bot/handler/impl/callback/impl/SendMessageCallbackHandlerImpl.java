package ru.ryazancev.bot.handler.impl.callback.impl;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.ryazancev.bot.handler.impl.callback.SendMessageCallbackHandler;

/**
 * @author Oleg Ryazancev
 */

@Component
public class SendMessageCallbackHandlerImpl implements SendMessageCallbackHandler {
    @Override
    public SendMessage handleCallback(Update update) {
        return null;
    }
}
