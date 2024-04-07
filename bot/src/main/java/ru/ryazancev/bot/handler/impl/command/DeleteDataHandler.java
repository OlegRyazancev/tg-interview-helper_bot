package ru.ryazancev.bot.handler.impl.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import ru.ryazancev.bot.command.type.DefaultCommand;
import ru.ryazancev.bot.handler.CommandHandler;

/**
 * @author Oleg Ryazancev
 */

@Component
public class DeleteDataHandler implements CommandHandler {
    @Override
    public DefaultCommand getCommand() {
        return DefaultCommand.DELETE_DATA;
    }

    @Override
    public void prepareMessage(SendMessage sendMessage) {

    }
}
