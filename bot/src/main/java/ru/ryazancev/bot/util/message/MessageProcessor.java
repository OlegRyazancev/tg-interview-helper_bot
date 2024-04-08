package ru.ryazancev.bot.util.message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.lang.Nullable;

import java.util.Locale;

/**
 * @author Oleg Ryazancev
 */

public abstract class MessageProcessor {

    private final MessageSource messageSource;

    @Value("${spring.web.locale}")
    private String defLocale;

    protected MessageProcessor(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String key, @Nullable Object[] args) {
        return messageSource.getMessage(key, args, new Locale(defLocale));
    }

    public String getMessage(String key, Locale loc, @Nullable Object[] args) {
        return messageSource.getMessage(key, args, loc);
    }
}
