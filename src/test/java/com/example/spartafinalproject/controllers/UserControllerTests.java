package com.example.spartafinalproject.controllers;

import com.example.spartafinalproject.model.dtos.User;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerTests {

    @Autowired
    WebTestClient webTestClient;

    @Test
    @DisplayName("Check that a user can be successfully returned using a valid ID")
    public void testGetUser() {
        webTestClient.get().uri("/users/{id}", "59b99db5cfa9a34dcd7885b8")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$._id").isEqualTo("59b99db5cfa9a34dcd7885b8");
    }

    @Test
    @DisplayName("Check that no user is found when using an invalid ID")
    public void testGetUserWithInvalidID() {
        webTestClient.get().uri("/users/{id}", "fakeNonExistentID123")
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    @Order(1)
    @DisplayName("Check that a user can be successfully created")
    public void testCreateUser() {
        User user = new User("testUserID123", "Martin Scorsese", "password123", "martinscorsese@gmail.com");

        webTestClient.post().uri("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(user), User.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$._id").isEqualTo("testUserID123")
                .jsonPath("$.name").isEqualTo("Martin Scorsese")
                .jsonPath("$.email").isEqualTo("martinscorsese@gmail.com")
                .jsonPath("$.password").isNotEmpty();
    }



    @Test
    @Order(2)
    @DisplayName("Check that a user can be successfully updated when using a valid ID")
    public void testUpdateUser() {
        Map<String, String> bodyValues = new HashMap<>();
        bodyValues.put("name", "Christopher Nolan");
        bodyValues.put("email", "christophernolan@gmail.com");

        webTestClient.put().uri("/users/{id}", "testUserID123")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(bodyValues))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$._id").isEqualTo("testUserID123")
                .jsonPath("$.name").isEqualTo("Christopher Nolan")
                .jsonPath("$.email").isEqualTo("christophernolan@gmail.com")
                .jsonPath("$.password").isNotEmpty();
    }

    @Test
    @DisplayName("Check that updating a user fails when using an invalid ID")
    public void testUpdateUserWithInvalidID() {
        Map<String, String> bodyValues = new HashMap<>();
        bodyValues.put("name", "Fake Person");
        bodyValues.put("email", "fakeperson@gmail.com");

        webTestClient.put().uri("/users/{id}", "fakeInvalidID123456")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(bodyValues))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    @Order(3)
    @DisplayName("Check that a user can be successfully deleted when using a valid ID")
    public void testDeleteUser() {
        webTestClient.delete().uri("/users/{id}", "testUserID123")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    @DisplayName("Check that deleting a user fails when using an invalid ID")
    public void testDeleteUserWithInvalidID() {
        webTestClient.delete().uri("/users/{id}", "fakeNonExistentID123")
                .exchange()
                .expectStatus().isNotFound();
    }

}
