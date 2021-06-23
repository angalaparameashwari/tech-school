package com.tech_school.core.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.core.env.ConfigurableEnvironment;

public class FlywayMigrator {


//    static final String URL = "spring.datasource.url";
//    static final String USER_NAME = "spring.datasource.username";
//    static final String PASS_WORD = "spring.datasource.password";
    static final String URL = "jdbc:h2:mem:testdb";
    static final String USER_NAME = "sa";
    static final String PASS_WORD = "";


    public void migrate(ConfigurableEnvironment env){
        Flyway flyway = Flyway.configure().dataSource(URL, USER_NAME,PASS_WORD).load();
        flyway.migrate();
    }
}
