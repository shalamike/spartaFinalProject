package com.example.spartafinalproject;

import com.example.spartafinalproject.model.repositories.CommentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpartaFinalProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpartaFinalProjectApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(CommentRepository repository) {
        return args -> {
            System.out.println(repository.findCommentById("5a9427648b0beebeb69579e7"));
        };
    }

}
