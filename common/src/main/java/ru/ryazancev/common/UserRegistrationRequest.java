package ru.ryazancev.common;

import lombok.*;

import java.io.Serializable;

/**
 * @author Oleg Ryazancev
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegistrationRequest implements Serializable {

    private String firstName;
    private String lastName;
    private String username;
    private Long chatId;
}
