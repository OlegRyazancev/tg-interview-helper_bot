package ru.ryazancev.user.service;

import ru.ryazancev.user.model.User;

import java.util.List;

/**
 * @author Oleg Ryazancev
 */

public interface UserService {

    List<User> findAll();

    User findById(Long chatId);

    void register(User user);

    String delete(Long chatId);

}
