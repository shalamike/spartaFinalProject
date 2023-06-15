package com.example.spartafinalproject.controllers;


import com.example.spartafinalproject.model.dtos.Theaters;
import com.example.spartafinalproject.model.dtos.theatersupport.Address;
import com.example.spartafinalproject.model.dtos.theatersupport.Location;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import reactor.core.publisher.Mono;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TheaterControllerTests {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    MockMvc mockMvc;


    Theaters theater = new Theaters(999, null, "aaaaaaaaaaaaaaaaaaaaaaa");

    @Test
    @DisplayName("check that searching all theaters returns a 200 resposne")
    @Order(1)
    void checkThatallThatersreturns200Response(){
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/api/theaters/all")) //this line creates the post request
                    .andDo(MockMvcResultHandlers.print()) //this line just prints the results of the post request
                    .andExpect(MockMvcResultMatchers.status().is2xxSuccessful()); //this line is the assertion checking that thte satus code is = to any 200 success code
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("testing getTheaterByTheaterId response")
    @Order(2)
    void testGetTheaterByTeaterId(){
        webTestClient.get()
                .uri("/api/theaters/theaterId/{theaterid}",1003)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody().toString()
                .contains("{\"theaterId\":1003,\"location\":{\"geo\":{\"coordinates\":[-76.512016,38.29697],\"type\":\"Point\"},\"address\":{\"zipcode\":\"20619\",\"city\":\"California\",\"street1\":\"45235 Worth Ave.\",\"state\":\"MD\"}},\"_id\":\"59a47286cfa9a3a73e51e72d\"}");
    }

    @Test
    @DisplayName("testing getTheaterById response")
    @Order(3)
    void testGetTheaterById(){
        webTestClient.get()
                .uri("/api/theaters/id/{id}","59a47286cfa9a3a73e51e72d")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody().toString()
                .contains("[{\"theaterId\":1003,\"location\":{\"geo\":{\"coordinates\":[-76.512016,38.29697],\"type\":\"Point\"},\"address\":{\"zipcode\":\"20619\",\"city\":\"California\",\"street1\":\"45235 Worth Ave.\",\"state\":\"MD\"}},\"_id\":\"59a47286cfa9a3a73e51e72d\"}]");
    }

    @Test
    @DisplayName("testing createTheater method")
    @Order(4)
    void testCreateTheater(){

        webTestClient.post().uri("/api/theaters/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(theater), Theaters.class)
                .exchange()
                .expectStatus()
                .isCreated()
                .expectHeader()
                .contentType(MediaType.APPLICATION_JSON)
                .expectBody().toString().contains("[{\"theaterId\":999,\"location\":null,\"_id\":\"aaaaaaaaaaaaaaaa\"}]");

    }

    @Test
    @DisplayName("testing update Theater Method")
    @Order(5)
    void testUpdateTheater(){
        Theaters updatedTheater = theater;
        Location location = new Location();
        Address address = new Address();
        address.setCity("some City");
        address.setZipcode("123ASD");
        address.setState("aState");
        updatedTheater.setLocation(location);

        webTestClient.put().uri("/api/theaters/theaterid/{id}", 999)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(updatedTheater), Theaters.class)
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody();
    }


    @Test
    @DisplayName("Testing delete theater method")
    @Order(6)
    void testDeleteTheaterById(){

        webTestClient.delete().uri("/api/theaters/id/{id}", theater.getId())
                .exchange()
                .expectStatus()
                .isOk();

    }

}
