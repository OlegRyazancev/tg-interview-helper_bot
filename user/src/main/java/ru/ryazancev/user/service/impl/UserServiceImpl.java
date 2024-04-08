package ru.ryazancev.user.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ryazancev.user.model.User;
import ru.ryazancev.user.repository.UserRepository;
import ru.ryazancev.user.service.UserService;
import ru.ryazancev.user.util.exception.ExceptionFactory;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Oleg Ryazancev
 */

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
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

    @Transactional
    @Override
    public String resolveLocaleTag(Long chatId, String localeTag) {

        userRepository.resolveLocaleTag(chatId, localeTag);
        //todo: add messages
        return "Locale resolved successfully!";
    }

    @Transactional
    @Override
    public void register(User user) {

        if (userRepository.findByChatId(user.getChatId()).isEmpty()) {
            user.setRegisteredAt(LocalDateTime.now());
            userRepository.save(user);
        } else {
            log.warn("User with same chat id: {} already exists",
                    user.getChatId());
        }
    }

    @Transactional
    @Override
    public String delete(Long id) {

        userRepository.deleteById(id);

        return String.format("User with id %s was successfully deleted", id);
    }

    @Override
    public String getLocaleTagByChatId(Long chatId) {

        return userRepository.findLocaleByChatId(chatId)
                .orElse("No locale");
    }
}
