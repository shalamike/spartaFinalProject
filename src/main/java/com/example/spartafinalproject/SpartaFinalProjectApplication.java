package com.example.spartafinalproject;

import com.example.spartafinalproject.repositories.SessionsRepository;
import com.example.spartafinalproject.repositories.TheatersRepository;
import com.example.spartafinalproject.repositories.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpartaFinalProjectApplication {

    //here is a comment
    public static void main(String[] args) {
        SpringApplication.run(SpartaFinalProjectApplication.class, args);
    }
    //here is another comment to avoid conflict

}
