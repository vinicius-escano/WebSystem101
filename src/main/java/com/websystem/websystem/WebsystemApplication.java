package com.websystem.websystem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class WebsystemApplication {

    private static final Logger log = LoggerFactory.getLogger(WebsystemApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WebsystemApplication.class, args);
    }

    /*@Bean
    public CommandLineRunner demo(ClienteRepository repository) {
        return (args) -> {
            repository.save(new Cliente("Jack", "Bauer"));
            repository.save(new Cliente("Chloe", "O'Brian"));
            repository.save(new Cliente("Kim", "Bauer"));
            repository.save(new Cliente("David", "Palmer"));
            repository.save(new Cliente("Michelle", "Dessler"));

        };
    }*/

}
