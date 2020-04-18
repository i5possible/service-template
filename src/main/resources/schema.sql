
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
