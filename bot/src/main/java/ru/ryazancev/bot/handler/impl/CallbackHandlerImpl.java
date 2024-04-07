package ru.ryazancev.bot.handler.impl;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.ryazancev.bot.handler.CallbackHandler;

/**
 * @author Oleg Ryazancev
 */

@Component
public class CallbackHandlerImpl implements CallbackHandler {

    @Override
    public SendMessage handleCallback(Update update) {
        return null;
    }
}
