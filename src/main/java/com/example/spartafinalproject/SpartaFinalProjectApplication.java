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
    TheatersRepository theaterRepository;
    private Logger logger = LoggerFactory.getLogger(SpartaFinalProjectApplication.class);
    public SpartaFinalProjectApplication(TheatersRepository theatreRepository) {
        this.theaterRepository = theatreRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpartaFinalProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner (SessionsRepository tr){
//        return args -> logger.info(String.valueOf(tr.findById("5a9427648b0beebeb69579e7"))); //Comments
//        return args -> logger.info(String.valueOf(tr.findById("573a1390f29313caabcd4135"))); //Movies
//        return args -> logger.info(String.valueOf(tr.findById("59a47286cfa9a3a73e51e72c"))); //Theater
//        return args -> logger.info(String.valueOf(tr.findById("59b99db4cfa9a34dcd7885b6"))); //Users
        return args -> logger.info(String.valueOf(tr.findById("5a97f9c91c807bb9c6eb5fb4"))); //Sessions

    }
}
