package ru.ryazancev.bot.handler.impl.callback;

import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.ryazancev.bot.handler.CallbackHandler;

/**
 * @author Oleg Ryazancev
 */

public interface EditMessageCallbackHandler extends CallbackHandler<EditMessageText> {
    @Override
    EditMessageText handleCallback(Update update);
}
