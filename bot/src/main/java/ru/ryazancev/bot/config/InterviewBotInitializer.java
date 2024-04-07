package ru.ryazancev.bot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import ru.ryazancev.bot.service.InterviewBot;

/**
 * @author Oleg Ryazancev
 */

@Configuration
@Slf4j
public class InterviewBotInitializer {

    @Bean
    public TelegramBotsApi telegramBotsApi(InterviewBot interviewBot) throws TelegramApiException {

        var api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(interviewBot);

        return api;
    }
}
