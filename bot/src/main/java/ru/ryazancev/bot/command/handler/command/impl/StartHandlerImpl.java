package ru.ryazancev.bot.command.handler.command.impl;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.ryazancev.bot.command.handler.command.StartHandler;

/**
 * @author Oleg Ryazancev
 */

@Component
public class StartHandlerImpl implements StartHandler {

    @Override
    public void handleStartCommand(SendMessage sendMessage) {

    }
}
