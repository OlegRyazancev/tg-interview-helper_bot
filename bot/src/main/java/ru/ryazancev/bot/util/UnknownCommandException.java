package ru.ryazancev.bot.util;

/**
 * @author Oleg Ryazancev
 */

public class UnknownCommandException extends RuntimeException{
    public UnknownCommandException(String message) {
        super(message);
    }
}
