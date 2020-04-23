
    create table platform_user (
       id uuid not null,
        account_expired_date date,
        active bool default false,
        credentials_expired_date date,
        email text,
        last_password_reset_date date,
        locked bool default false,
        password text,
        roles text,
        user_name text,
        primary key (id)
    );
create index user_index on platform_user (user_name);
