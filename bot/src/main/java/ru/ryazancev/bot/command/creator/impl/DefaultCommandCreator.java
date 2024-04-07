package ru.ryazancev.bot.command.creator.impl;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import ru.ryazancev.bot.util.CommandUtils;
import ru.ryazancev.bot.command.type.DefaultCommand;
import ru.ryazancev.bot.command.creator.CommandCreator;

import java.util.List;

/**
 * @author Oleg Ryazancev
 */

public class DefaultCommandCreator implements CommandCreator {
    @Override
    public List<BotCommand> createCommandList() {
        return CommandUtils.createCommands(DefaultCommand.class);
    }
}
