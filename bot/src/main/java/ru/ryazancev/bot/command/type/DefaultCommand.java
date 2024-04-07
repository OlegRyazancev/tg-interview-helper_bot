package ru.ryazancev.bot.command.type;

import lombok.Getter;

/**
 * @author Oleg Ryazancev
 */

@Getter
public enum DefaultCommand implements CommandDetails {

    START("command.default.start"),
    USER_DATA("command.default.user_data"),
    DELETE_DATA("command.default.delete_data"),
    HELP("command.default.help"),
    LANGUAGE("command.default.language");

    private final String description;

    DefaultCommand(String description) {
        this.description = description;
    }

    public String getCommandName() {
        return "/" + name().toLowerCase();
    }
}
