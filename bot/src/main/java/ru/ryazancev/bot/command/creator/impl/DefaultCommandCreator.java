package ru.ryazancev.bot.command.creator.impl;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import ru.ryazancev.bot.command.creator.CommandCreator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleg Ryazancev
 */

public class DefaultCommandCreator implements CommandCreator {
    @Override
    public List<BotCommand> createCommandList() {
        List<BotCommand> commands = new ArrayList<>();
        commands.add(new BotCommand("/start", "get a welcome message"));
        commands.add(new BotCommand("/user_data", "get your data stored"));
        commands.add(new BotCommand("/delete_data", "delete my data"));
        commands.add(new BotCommand("/help", "info how to use this bot"));
        commands.add(new BotCommand("/settings", "set your preferences"));
        return commands;
    }
}
