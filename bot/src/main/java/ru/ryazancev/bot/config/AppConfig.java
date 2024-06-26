package ru.ryazancev.bot.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.ryazancev.bot.service.InterviewBot;

/**
 * @author Oleg Ryazancev
 */

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public TelegramBotsApi telegramBotsApi(InterviewBot interviewBot) throws TelegramApiException {

        var api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(interviewBot);

        return api;
    }


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
