package ru.ryazancev.user.service;

import ru.ryazancev.user.model.User;

import java.util.List;

/**
 * @author Oleg Ryazancev
 */

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    String resolveLocaleTag(Long chatId, String localeTag);

    void register(User user);

    String delete(Long chatId);

    String getLocaleTagByChatId(Long chatId);
}
