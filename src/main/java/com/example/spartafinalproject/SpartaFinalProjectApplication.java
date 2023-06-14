package com.example.spartafinalproject;

import com.example.spartafinalproject.model.repositories.CommentRepository;
import com.example.spartafinalproject.model.repositories.MoviesRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
public class SpartaFinalProjectApplication {


    //here is a comment
    public static void main(String[] args) {
        SpringApplication.run(SpartaFinalProjectApplication.class, args);
    }

    //here is another comment to avoid conflict
}
