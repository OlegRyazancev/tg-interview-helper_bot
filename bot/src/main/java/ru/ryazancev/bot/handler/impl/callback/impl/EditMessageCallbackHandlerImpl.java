package ru.ryazancev.bot.handler.impl.callback.impl;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.ryazancev.bot.command.Button;
import ru.ryazancev.bot.handler.impl.callback.EditMessageCallbackHandler;

import java.util.Locale;

/**
 * @author Oleg Ryazancev
 */

@Component
public class EditMessageCallbackHandlerImpl implements EditMessageCallbackHandler {



    @Override
    public EditMessageText handleCallback(Update update) {
        String callbackData = update.getCallbackQuery().getData();
        long chatId = update.getCallbackQuery().getMessage().getChatId();
        long messageId = update.getCallbackQuery().getMessage().getMessageId();

        EditMessageText editMessageText = new EditMessageText();
        if (callbackData.equals(Button.ENGLISH_BUTTON.name())) {
            String text = "You pressed ENGLISH_BUTTON";
            editMessageText.setText(text);
            editMessageText.setChatId(chatId);
            editMessageText.setMessageId((int) messageId);
            LocaleContextHolder.setLocale(Locale.ENGLISH);

        } else if (callbackData.equals(Button.RUSSIAN_BUTTON.name())) {
            String text = "You pressed RUSSIAN_BUTTON";

            editMessageText.setText(text);
            editMessageText.setChatId(chatId);
            editMessageText.setMessageId((int) messageId);
            LocaleContextHolder.setLocale(Locale.forLanguageTag("ru"));
        }
        return editMessageText;
    }
}
