package ru.ryazancev.bot.handler.impl.command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.ryazancev.bot.command.Button;
import ru.ryazancev.bot.command.type.DefaultCommand;
import ru.ryazancev.bot.handler.CommandHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleg Ryazancev
 */

@Component
public class LanguageCommandHandler implements CommandHandler {

    @Override
    public DefaultCommand getCommand() {
        return DefaultCommand.LANGUAGE;
    }

    @Override
    public void prepareMessage(SendMessage sendMessage) {

        sendMessage.setText("Choose your prefer language");
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine = new ArrayList<>();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("English");
        button1.setCallbackData(Button.ENGLISH_BUTTON.name());

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Russian");
        button2.setCallbackData(Button.RUSSIAN_BUTTON.name());
        rowInLine.add(button1);
        rowInLine.add(button2);

        rowsInLine.add(rowInLine);

        markup.setKeyboard(rowsInLine);
        sendMessage.setReplyMarkup(markup);

    }
}
