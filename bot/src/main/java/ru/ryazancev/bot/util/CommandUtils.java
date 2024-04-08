package ru.ryazancev.bot.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import ru.ryazancev.bot.command.type.CommandDetails;
import ru.ryazancev.bot.util.exception.UnknownCommandException;
import ru.ryazancev.bot.util.message.impl.CommandDescriptionProcessor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Oleg Ryazancev
 */

@Component
@RequiredArgsConstructor
public class CommandUtils {

    private final CommandDescriptionProcessor commandDescriptionProcessor;

    public <T extends Enum<T> & CommandDetails> List<BotCommand> createCommands(Class<T> enumClass) {

        return Arrays.stream(enumClass.getEnumConstants())
                .map(val -> new BotCommand(
                        val.getCommandName(),
                        commandDescriptionProcessor.getMessage(val.getDescription(), null)
                ))
                .collect(Collectors.toList());
    }

    public static <T extends Enum<T> & CommandDetails> T fromTextToCommand(String text, Class<T> enumClass) throws UnknownCommandException {

        for (T command : enumClass.getEnumConstants()) {
            if (command.name().equalsIgnoreCase(text.substring(1))) {
                return command;
            }
        }
        throw new UnknownCommandException("No command found for text: " + text);
    }
}
