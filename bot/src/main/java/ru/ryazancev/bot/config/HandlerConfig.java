package ru.ryazancev.bot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.ryazancev.bot.command.type.DefaultCommand;
import ru.ryazancev.bot.handler.CommandHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Oleg Ryazancev
 */

@Configuration
@ComponentScan(basePackages = "ru.ryazancev.bot.handler.impl.command")
public class HandlerConfig {

    @Bean
    public Map<DefaultCommand, CommandHandler> commandHandlers(List<CommandHandler> handlers) {
        Map<DefaultCommand, CommandHandler> handlersMap = new HashMap<>();

        for (CommandHandler handler : handlers) {
            handlersMap.put(handler.getCommand(), handler);
        }

        return handlersMap;
    }
}
