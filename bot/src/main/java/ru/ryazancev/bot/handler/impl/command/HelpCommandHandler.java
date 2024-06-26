package ru.ryazancev.bot.handler.impl.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.ryazancev.bot.command.type.DefaultCommand;
import ru.ryazancev.bot.handler.CommandHandler;

/**
 * @author Oleg Ryazancev
 */

@Component
public class HelpCommandHandler implements CommandHandler {

    @Override
    public DefaultCommand getCommand() {
        return DefaultCommand.HELP;
    }

    @Override
    public SendMessage prepareMessage(Message message) {
        return null;
    }
}
