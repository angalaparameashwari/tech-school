package com.tech_school.app;

import com.tech_school.core.flyway.FlywayMigrator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
@EnableScheduling
public class TechSchoolApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(TechSchoolApplication.class)
                .listeners((ApplicationListener<ApplicationReadyEvent>) event -> {
                    new FlywayMigrator().migrate(event.getApplicationContext().getEnvironment());
                })
                .build()
                .run(args);
    }
}
