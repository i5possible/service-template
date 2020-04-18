
    create table example (
       id uuid not null,
        create_timestamp timestamp DEFAULT CURRENT_TIMESTAMP not null,
        update_timestamp timestamp DEFAULT CURRENT_TIMESTAMP not null,
        age int4,
        height numeric,
        name text,
        primary key (id)
    );
