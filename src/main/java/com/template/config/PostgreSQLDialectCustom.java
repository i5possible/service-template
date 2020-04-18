package com.template.config;

import org.hibernate.dialect.PostgreSQL95Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;

public class PostgreSQLDialectCustom extends PostgreSQL95Dialect {

    public PostgreSQLDialectCustom() {
        super();
        // only 2-argument version of to_tsvector can use GIN expression index
        registerFunction("fts", new SQLFunctionTemplate(
                StandardBasicTypes.BOOLEAN,
                "to_tsvector('simple', ?1) @@ plainto_tsquery('simple', ?2)"));
    }
}
