package ru.ryazancev.bot.util.message.impl;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ru.ryazancev.bot.util.message.Message;

/**
 * @author Oleg Ryazancev
 */

@Component
public class ExceptionMessage extends Message {
    protected ExceptionMessage(@Qualifier("exceptionMessages") MessageSource messageSource) {
        super(messageSource);
    }
}
