package com.example.demospringwebflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableMongoRepositories
@EnableReactiveMongoRepositories
public class DemoSpringWebFluxApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringWebFluxApplication.class, args);
    }

}
