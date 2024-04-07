package ru.ryazancev.bot.config;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ru.ryazancev.bot.command.type.DefaultCommand;

/**
 * @author Oleg Ryazancev
 */

@Component
@Slf4j
public class CommandInitializer {

    private final MessageSource messageSource;

    @Autowired
    public CommandInitializer(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @PostConstruct
    public void init() {
        DefaultCommand.setMessageSource(messageSource);
        log.info("DefaultCommandInitializer initialized successfully.");
    }
}
