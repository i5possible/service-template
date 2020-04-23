
    create table example (
       id uuid not null,
        create_timestamp timestamp DEFAULT CURRENT_TIMESTAMP not null,
        update_timestamp timestamp DEFAULT CURRENT_TIMESTAMP not null,
        age int4,
        height numeric,
        name text,
        primary key (id)
    );

    create table example2 (
       id uuid not null,
        create_timestamp timestamp DEFAULT CURRENT_TIMESTAMP not null,
        update_timestamp timestamp DEFAULT CURRENT_TIMESTAMP not null,
        date_column date,
        decimal_column decimal(20,2),
        float_column float4,
        integer_column int,
        string_column varchar,
        text_column text,
        primary key (id)
    );

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
