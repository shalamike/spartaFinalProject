package com.example.spartafinalproject.controllers;

import com.example.spartafinalproject.model.dtos.Comment;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CommentsControllerTests {

    @Autowired
    WebTestClient webTestClient;

    @Test
    @Order(1)
    @DisplayName("Check that a comment can be successfully created")
    public void createCommentSuccessfully() {
        Comment comment = new Comment(new Date(2016,10,23), "Tim Duncan", "successfulID12345",
                "Decent. 6/10", "573a1390f29313caabcd4135", "timduncs@yahoo.co.uk");

        webTestClient.post().uri("/api/comment")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(comment), Comment.class)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$._id").isEqualTo("successfulID12345");
    }

    @Test
    @Order(2)
    @DisplayName("Check that a comment can be successfully updated")
    public void updateComment() {
        Map<String, String> bodyValues = new HashMap<>();
        bodyValues.put("text", "On second thoughts, I disliked it. 2/10");

        webTestClient.put().uri("/api/comment/{id}", "testID123")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(bodyValues))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.text").isEqualTo("On second thoughts, I disliked it. 2/10");
    }

    @Test
    @Order(3)
    @DisplayName("Check that a comment can be successfully deleted")
    public void deleteComment() {
        webTestClient.delete().uri("/api/comment/{id}", "successfulID12345")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    @DisplayName("Check that all comments can be returned with get method")
    public void getAllComments() {
        webTestClient.get().uri("/api/comments")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Comment.class);
    }

    @Test
    @DisplayName("Check that comments for an existing movie can be returned")
    public void getCommentsForMovie() {
        webTestClient.get().uri("/api/comments/movie/{id}", "573a1390f29313caabcd4135")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Comment.class);
    }

    @Test
    @DisplayName("Check that no comments are returned for a movie with an invalid ID")
    public void getCommentsForInvalidMovie() {
        webTestClient.get().uri("/api/comments/movie/{id}", "573a1390f29313caabcd56df")
                .exchange()
                .expectStatus().isNoContent();
    }

    @Test
    @DisplayName("Check that a comment isn't returned when requesting with an invalid ID")
    public void getCommentWithInvalidId() {
        webTestClient.get().uri("/api/comments/movie/{id}", "randomID12345")
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    @DisplayName("Check that a comment is returned when requesting with a valid ID")
    public void getCommentWithValidId() {
        webTestClient.get().uri("/api/comment/{id}","5a9427648b0beebeb69579e7")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$._id").isEqualTo("5a9427648b0beebeb69579e7");
    }

    @Test
    @DisplayName("Check that a comment can't be successfully created if ID already exists")
    public void createCommentWithDuplicateID() {
        Map<String, String> bodyValues = new HashMap<>();
        bodyValues.put("_id", "5a9427648b0beebeb6957b1a");
        bodyValues.put("name", "Jessica Andrews");
        bodyValues.put("text", "Loved it. 10/10!");

        webTestClient.post().uri("/api/comment")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(bodyValues))
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    @DisplayName("Check that deleting a comment fails when using an invalid ID")
    public void deleteCommentWithInvalidID() {
        webTestClient.delete().uri("/api/comment/{id}", "nonExistentID123")
                .exchange()
                .expectStatus().isBadRequest();
    }

}