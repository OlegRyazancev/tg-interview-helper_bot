package ru.ryazancev.bot.command.processor;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import ru.ryazancev.bot.command.creator.CommandCreator;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author Oleg Ryazancev
 */

public class CommandProcessor {

    public static List<BotCommand> createCommandList(Supplier<CommandCreator> commandCreator) {

        CommandCreator creator = commandCreator.get();
        return creator.createCommandList();
    }
}
