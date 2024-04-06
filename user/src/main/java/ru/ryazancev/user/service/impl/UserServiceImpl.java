package ru.ryazancev.user.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ryazancev.user.model.User;
import ru.ryazancev.user.repository.UserRepository;
import ru.ryazancev.user.service.UserService;
import ru.ryazancev.user.util.exception.ExceptionFactory;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Oleg Ryazancev
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {

        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() ->
                        ExceptionFactory
                                .getUserNotFound()
                                .byChatId(String.valueOf(id)));
    }

    @Override
    public void register(User user) {

        if (userRepository.findById(user.getChatId()).isEmpty()) {
            user.setRegisteredAt(LocalDateTime.now());
            userRepository.save(user);
        }
    }

    @Override
    public String delete(Long id) {

        userRepository.deleteById(id);

        return String.format("User with id %s was successfully deleted", id);
    }
}
