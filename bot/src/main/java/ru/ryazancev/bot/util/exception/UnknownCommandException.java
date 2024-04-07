package ru.ryazancev.bot.util.exception;

/**
 * @author Oleg Ryazancev
 */

public class UnknownCommandException extends RuntimeException{
    public UnknownCommandException(String message) {
        super(message);
    }
}
