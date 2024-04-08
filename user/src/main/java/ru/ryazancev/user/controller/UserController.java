package ru.ryazancev.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ryazancev.user.model.User;
import ru.ryazancev.user.service.UserService;

import java.util.List;

/**
 * @author Oleg Ryazancev
 */

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping("/locale")
    public String addLocale(@RequestParam("chat_id") Long chatId,
                            @RequestParam("locale") String locale) {

        return userService.resolveLocaleTag(chatId, locale);
    }

    @GetMapping("/{chatId}/locale")
    public String getLocaleByChatId(
            @PathVariable("chatId") Long chatId) {

        return userService.getLocaleTagByChatId(chatId);
    }
}
