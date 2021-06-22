package com.digishop.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication(scanBasePackages = "com.digishop")
@EnableMongoRepositories(basePackages = "com.digishop.*")
@EnableWebSecurity
public class Launcher {

    public static void main(String[] args) {

        SpringApplication.run(Launcher.class, args);
        System.out.println("\n\n-------------------------------------------------------------------------- " + "DIGISHOP STARTED" +
                " ----------------------------------------------------------------------------------------\n\n");
    }
}
