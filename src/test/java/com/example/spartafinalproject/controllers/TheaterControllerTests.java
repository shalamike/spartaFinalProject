package com.example.spartafinalproject.controllers;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class TheaterControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("check that searching all theaters returns a 200 resposne")
    void checkThatallThatersreturns200Response(){
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/theaters/all")) //this line creates the post request
                    .andDo(MockMvcResultHandlers.print()) //this line just prints the results of the post request
                    .andExpect(MockMvcResultMatchers.status().is2xxSuccessful()); //this line is the assertion checking that thte satus code is = to any 200 success code
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
