package ru.ryazancev.bot.service;

/**
 * @author Oleg Ryazancev
 */

public interface DataFetcher {

    String fetchUserLocaleTag(Long chatId);
}
