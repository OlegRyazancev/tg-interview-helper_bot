package ru.ryazancev.user.util.exception;

import ru.ryazancev.user.util.exception.custom.UserNotFoundException;

/**
 * @author Oleg Ryazancev
 */

public class ExceptionFactory {

    public static UserNotFoundException getUserNotFound() {
        return new UserNotFoundException();
    }
}
