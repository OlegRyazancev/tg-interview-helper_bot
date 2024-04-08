package ru.ryazancev.user.repository;

import org.apache.kafka.common.quota.ClientQuotaAlteration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.ryazancev.user.model.User;

import java.util.Optional;

/**
 * @author Oleg Ryazancev
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query(value = """
            insert into users_locales (chat_id, locale)
            values (:chatId, :locale)
            """, nativeQuery = true)
    void resolveLocaleTag(@Param("chatId") Long chatId,
                          @Param("locale") String locale);

    @Query(value = """
            select locale from users_locales l
            where l.chat_id = :chatId
            """, nativeQuery = true)
    Optional<String> findLocaleByChatId(@Param("chatId") Long chatId);

    Optional<User> findByChatId(Long chatId);
}
