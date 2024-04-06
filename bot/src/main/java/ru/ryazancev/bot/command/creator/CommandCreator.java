package ru.ryazancev.bot.command.creator;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.List;

/**
 * @author Oleg Ryazancev
 */

public interface CommandCreator {

    List<BotCommand> createCommandList();
}
