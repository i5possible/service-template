
    create table example2 (
       unid_id varchar(32) not null,
        create_timestamp timestamp DEFAULT CURRENT_TIMESTAMP not null,
        update_timestamp timestamp DEFAULT CURRENT_TIMESTAMP not null,
        d_date date,
        d_datetime time,
        f_float float4,
        height decimal(20,2),
        i_int int,
        s_string varchar,
        t_text text,
        primary key (unid_id)
    );
