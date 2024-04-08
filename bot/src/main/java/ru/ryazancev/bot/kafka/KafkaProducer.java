package ru.ryazancev.bot.kafka;

import ru.ryazancev.common.UserRegistrationRequest;

/**
 * @author Oleg Ryazancev
 */

public interface KafkaProducer {

    void sendMessageToUserRegistrationTopic(UserRegistrationRequest request);
}
