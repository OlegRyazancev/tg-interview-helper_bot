create table if not exists users
(
    id            bigserial primary key,
    first_name    varchar(255),
    last_name     varchar(255),
    username      varchar(255),
    chat_id       bigint unique,
    registered_at timestamp
);

create table if not exists users_locales
(
    chat_id bigint      not null,
    locale  varchar(20) not null,
    primary key (chat_id),
    constraint fk_users_chat_id foreign key (chat_id)
        references users (chat_id) on delete cascade on update no action
)

