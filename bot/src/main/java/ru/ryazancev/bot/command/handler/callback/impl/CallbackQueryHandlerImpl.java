package ru.ryazancev.bot.command.handler.callback.impl;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.ryazancev.bot.command.handler.callback.CallbackQueryHandler;

/**
 * @author Oleg Ryazancev
 */

@Component
public class CallbackQueryHandlerImpl implements CallbackQueryHandler {

    @Override
    public SendMessage handleCallback(Update update) {
        return null;
    }
}
