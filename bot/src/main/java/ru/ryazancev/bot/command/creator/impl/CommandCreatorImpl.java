package ru.ryazancev.bot.command.creator.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import ru.ryazancev.bot.command.creator.CommandCreator;
import ru.ryazancev.bot.command.type.DefaultCommand;
import ru.ryazancev.bot.util.CommandUtils;

import java.util.List;

/**
 * @author Oleg Ryazancev
 */

@Component
@RequiredArgsConstructor
public class CommandCreatorImpl implements CommandCreator {

    private final CommandUtils commandUtils;
    @Override
    public List<BotCommand> createCommandList() {
        return commandUtils.createCommands(DefaultCommand.class);
    }
}
