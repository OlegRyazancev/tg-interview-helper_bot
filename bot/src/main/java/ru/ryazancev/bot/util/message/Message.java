package ru.ryazancev.bot.util.message;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * @author Oleg Ryazancev
 */

public abstract class Message {

    private final MessageSource messageSource;

    protected Message(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String key, Object... args) {
        return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
    }
}
