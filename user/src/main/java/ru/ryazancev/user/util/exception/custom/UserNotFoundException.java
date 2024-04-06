package ru.ryazancev.user.util.exception.custom;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Oleg Ryazancev
 */

@Getter
@NoArgsConstructor
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException byChatId(String chatId) {

        return new UserNotFoundException(String.format("User not found by this id: %s", chatId));
    }
}
