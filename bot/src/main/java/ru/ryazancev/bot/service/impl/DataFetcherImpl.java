package ru.ryazancev.bot.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.ryazancev.bot.service.DataFetcher;

/**
 * @author Oleg Ryazancev
 */

@Service
@RequiredArgsConstructor
public class DataFetcherImpl implements DataFetcher {

    private final RestTemplate restTemplate;

    private final static String GET_LOCALE_API = "http://localhost:8081/api/v1/users/%s/locale";


    public String fetchUserLocaleTag(Long chatId) {

        return restTemplate.getForObject(String.format(GET_LOCALE_API, chatId), String.class);
    }
}
