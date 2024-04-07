package ru.ryazancev.bot.command.handler.command.impl;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.ryazancev.bot.command.handler.command.HelpHandler;

/**
 * @author Oleg Ryazancev
 */

@Component
public class HelpHandlerImpl implements HelpHandler {
    @Override
    public void handleHelpCommand(SendMessage sendMessage) {

    }
}
