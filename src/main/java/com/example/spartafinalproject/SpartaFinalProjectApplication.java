package com.example.spartafinalproject;

import com.example.spartafinalproject.logging.LogSetup;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;


@SpringBootApplication
public class SpartaFinalProjectApplication {
    static Logger logger = Logger.getLogger(SpartaFinalProjectApplication.class.getName());
    //here is a comment
    public static void main(String[] args) {
        SpringApplication.run(SpartaFinalProjectApplication.class, args);
        LogSetup.setup();
    }
    //here is another comment to avoid conflict



}
