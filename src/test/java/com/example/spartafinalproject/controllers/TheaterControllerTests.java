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
    Theaters theater2 = new Theaters(888, null, "bbbbbbbbbbbbbbbbbbbbbbb");

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
                .equals("[{\"theaterId\":1003,\"location\":{\"geo\":{\"coordinates\":[-76.512016,38.29697],\"type\":\"Point\"},\"address\":{\"zipcode\":\"20619\",\"city\":\"California\",\"street1\":\"45235 Worth Ave.\",\"state\":\"MD\"}},\"_id\":\"59a47286cfa9a3a73e51e72d\"}]");
    }

    @Test
    @DisplayName("testing getTheaterById response")
    @Order(4)
    void testGetTheaterById2(){
        webTestClient.get()
                .uri("/api/theaters/id/{id}","59a47286cfa9a3a73e51e72d")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .jsonPath("$.theaterId").isEqualTo(1003)
                .jsonPath("$.location").isNotEmpty()
                .jsonPath("$.location.address.zipcode").isEqualTo("20619")
                .jsonPath("$.location.geo.coordinates").toString()
                .equals(" [-76.512016,38.29697]");
    }

    @Test
    @DisplayName("testing createTheater method")
    @Order(5)
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
                .expectBody().toString().equals("[{\"theaterId\":999,\"location\":null,\"_id\":\"aaaaaaaaaaaaaaaaaaaaaaa\"}]");

    }

    @Test
    @DisplayName("testing createTheater method 2")
    @Order(6)
    void testCreateTheater2(){

        webTestClient.post().uri("/api/theaters/")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(theater2), Theaters.class)
                .exchange()
                .expectStatus()
                .isCreated()
                .expectHeader()
                .contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.theaterId").isEqualTo(888)
                .jsonPath("$._id").isEqualTo("bbbbbbbbbbbbbbbbbbbbbbb");

    }

    @Test
    @DisplayName("testing update Theater Method by theaeterId")
    @Order(7)
    void testUpdateTheaterByTheaterId(){
        Theaters updatedTheater = theater;
        Location location = new Location();
        Address address = new Address();
        address.setCity("some City");
        address.setZipcode("123ASD");
        address.setState("aState");
        location.setAddress(address);
        updatedTheater.setLocation(location);

        webTestClient.put().uri("/api/theaters/theaterid/{id}", 999)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(updatedTheater), Theaters.class)
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody()
                .jsonPath("$.location.address.city").isEqualTo("some City")
                .jsonPath("$.location.address.zipcode").isEqualTo("123ASD")
                .jsonPath("$.location.address.state").isEqualTo("aState");
    }

    @Test
    @DisplayName("testing update Theater Method by id")
    @Order(8)
    void testUpdateTheaterById(){
        Theaters updatedTheater = theater2;
        Location location = new Location();
        Address address = new Address();
        address.setCity("some other City");
        address.setZipcode("456ZXC");
        address.setState("NoState");
        location.setAddress(address);
        updatedTheater.setLocation(location);

        webTestClient.put().uri("/api/theaters/id/{id}", "bbbbbbbbbbbbbbbbbbbbbbb")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(updatedTheater), Theaters.class)
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody()
                .jsonPath("$.location.address.city").isEqualTo("some other City")
                .jsonPath("$.location.address.zipcode").isEqualTo("456ZXC")
                .jsonPath("$.location.address.state").isEqualTo("NoState");
    }


    @Test
    @DisplayName("Testing delete theater Id method")
    @Order(9)
    void testDeleteTheaterById(){

        webTestClient.delete().uri("/api/theaters/id/{id}", theater.getId())
                .exchange()
                .expectStatus()
                .isOk();

    }

    @Test
    @DisplayName("Testing delete theater by theaterId method")
    @Order(10)
    void testDeleteTheaterByTheaterId(){

        webTestClient.delete().uri("/api/theaters/theaterid/{id}", theater2.getTheaterId())
                .exchange()
                .expectStatus()
                .isOk();

    }

}
