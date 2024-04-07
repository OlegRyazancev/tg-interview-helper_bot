package ru.ryazancev.bot.util;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import ru.ryazancev.bot.command.type.CommandDetails;
import ru.ryazancev.bot.util.UnknownCommandException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Oleg Ryazancev
 */

public class CommandUtils {

    public static <T extends Enum<T> & CommandDetails> List<BotCommand> createCommands(Class<T> enumClass) {
        return Arrays.stream(enumClass.getEnumConstants())
                .map(val -> new BotCommand(
                        val.getCommandName(),
                        val.getDescription()
                ))
                .collect(Collectors.toList());
    }

    public static <T extends Enum<T> & CommandDetails> T fromText(String text, Class<T> enumClass) throws UnknownCommandException {

        for (T command : enumClass.getEnumConstants()) {
            if (command.name().equalsIgnoreCase(text.substring(1))) {
                return command;
            }
        }
        throw new UnknownCommandException("No command found for text: " + text);
    }
}
