package ru.ryazancev.bot.kafka.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ru.ryazancev.bot.kafka.KafkaProducer;
import ru.ryazancev.common.UserRegistrationRequest;

/**
 * @author Oleg Ryazancev
 */

@Slf4j
@Component
public class KafkaProducerImpl implements KafkaProducer {

    private final KafkaTemplate<
            String, UserRegistrationRequest> userRegistrationKafkaTemplate;


    @Value("${spring.kafka.topic.user.register}")
    private String userRegistrationTopic;

    public KafkaProducerImpl(
            @Qualifier("userRegistrationKafkaTemplate") KafkaTemplate<
                    String, UserRegistrationRequest> userRegistrationKafkaTemplate) {

        this.userRegistrationKafkaTemplate = userRegistrationKafkaTemplate;
    }

    @Override
    public void sendMessageToUserRegistrationTopic(UserRegistrationRequest request) {

        log.info("Received request to register user with " +
                        "chat_id {} in the {} topic",
                request.getChatId(),
                userRegistrationKafkaTemplate);

        try {
            log.info("Sending registration user request...");

            userRegistrationKafkaTemplate.send(userRegistrationTopic, request);

            log.info("User registration request was successfully sent to {}",
                    userRegistrationTopic);
        } catch (Exception e) {
            log.error("Failed to send user registration request to {}: {}",
                    userRegistrationTopic, e.getMessage());
            e.printStackTrace();
        }
    }
}
