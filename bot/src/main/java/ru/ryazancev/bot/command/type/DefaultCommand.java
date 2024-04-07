package ru.ryazancev.bot.command.type;

import lombok.Setter;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * @author Oleg Ryazancev
 */

public enum DefaultCommand implements CommandDetails {
    START("command.default.start"),
    USER_DATA("command.default.user_data"),
    DELETE_DATA("command.default.delete_data"),
    HELP("command.default.help"),
    LANGUAGE("command.default.language");


    @Setter
    private static MessageSource messageSource;

    private final String commandName;

    DefaultCommand(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return "/" + name().toLowerCase();
    }

    @Override
    public String getDescription() {
        return messageSource.getMessage(commandName, null, LocaleContextHolder.getLocale());
    }
}
