package ru.ryazancev.bot.handler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.ryazancev.bot.command.type.DefaultCommand;

/**
 * @author Oleg Ryazancev
 */

public interface CommandHandler {

    DefaultCommand getCommand();

    SendMessage prepareMessage(Message message);
}
