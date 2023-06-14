package com.example.spartafinalproject;

import com.example.spartafinalproject.model.respositories.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpartaFinalProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpartaFinalProjectApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UsersRepository repository){
        return args -> {
            System.out.println(repository.findById("59b99db4cfa9a34dcd7885b7").get());
        };
    }
}
