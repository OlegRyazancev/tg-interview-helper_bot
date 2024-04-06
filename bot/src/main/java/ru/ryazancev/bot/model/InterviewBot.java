package ru.ryazancev.bot.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * @author Oleg Ryazancev
 */

@Component
@Slf4j
public class InterviewBot extends TelegramLongPollingBot {

    @Value("${interview-bot.name}")
    private String name;

    public InterviewBot(@Value("${interview-bot.token}") String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {

    }

    @Override
    public String getBotUsername() {
        return name;
    }
}

