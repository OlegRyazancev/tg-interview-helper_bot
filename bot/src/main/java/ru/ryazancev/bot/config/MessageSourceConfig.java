package ru.ryazancev.bot.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author Oleg Ryazancev
 */

@Configuration
public class MessageSourceConfig {

    @Bean
    public MessageSource commandDescriptions() {
        var messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages/command-descriptions");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public MessageSource exceptionMessages() {
        var messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages/exception-messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public MessageSource sendingMessages() {
        var messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages/send-messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}
