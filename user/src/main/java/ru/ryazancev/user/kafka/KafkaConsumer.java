package ru.ryazancev.user.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import ru.ryazancev.common.UserRegistrationRequest;
import ru.ryazancev.user.model.User;
import ru.ryazancev.user.service.UserService;

/**
 * @author Oleg Ryazancev
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final UserService userService;

    @KafkaListener(
            topics = "${spring.kafka.topic.user}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "userRegistrationMessageFactory"
    )
    public void registerUser(UserRegistrationRequest request) {

        log.info("Received message to register user with chatId: {}",
                request.getChatId());

        try {

            log.info("Registering user...");

            User user = User.builder()
                    .chatId(request.getChatId())
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .username(request.getUsername())
                    .build();

            userService.register(user);

            log.info("User registered successfully");

        } catch (Exception e) {

            log.error("Failed to register user: {}", e.getMessage());
        }
    }
}
