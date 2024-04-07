package ru.ryazancev.bot.command.handler.command.impl;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.ryazancev.bot.command.Button;
import ru.ryazancev.bot.command.handler.command.LanguageHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleg Ryazancev
 */

@Component
public class LanguageHandlerImpl implements LanguageHandler {

    @Override
    public void handleLanguageCommand(SendMessage message) {
        message.setText("Choose your prefer language");
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
        message.setReplyMarkup(markup);


    }
}
