package com.example.spartafinalproject.controllers;

import com.example.spartafinalproject.model.dtos.Movie;
import com.example.spartafinalproject.repositories.MoviesRepositoryTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieControllerTests {
    @Autowired
    WebTestClient webTestClient;

    @Test
    @DisplayName("Testing createMovie response")
    void testCreateMovie(){
        Movie movie = MoviesRepositoryTests.getMovie();

        webTestClient.post().uri("/movie")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(movie),Movie.class)
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.title").isNotEmpty()
                .jsonPath("$.title").isEqualTo("Test Movie")
                .jsonPath("$.year").isEqualTo(2023)
                .jsonPath("$.type").isEqualTo("movie")
                .jsonPath("$.numMflixComments").isEqualTo(0);
    }

    @Test
    @DisplayName("Testing getMovieById response")
    void testGetMovieById(){
        webTestClient.get()
                .uri("movie/{id}","testId")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.title").isNotEmpty()
                .jsonPath("$.title").isEqualTo("Test Movie")
                .jsonPath("$.year").isEqualTo(2023)
                .jsonPath("$.type").isEqualTo("movie")
                .jsonPath("$.numMflixComments").isEqualTo(0);
    }

    @Test
    @DisplayName("Testing updateMovie response")
    void testUpdateMovie(){
        Movie movieUpdates = MoviesRepositoryTests.getMovie();
        movieUpdates.setTitle("Updated Title");
        movieUpdates.setType("series");
        movieUpdates.setNumMflixComments(72);

        webTestClient.put()
                .uri("/movie/{id}","testId")
                .body(Mono.just(movieUpdates),Movie.class)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBody()
                .jsonPath("$.title").isNotEmpty()
                .jsonPath("$.title").isEqualTo("Updated Title")
                .jsonPath("$.year").isEqualTo(2023)
                .jsonPath("$.type").isEqualTo("series")
                .jsonPath("$.numMflixComments").isEqualTo(72);
    }

    @Test
    @DisplayName("Testing deleteMovieById response")
    void testDeleteMovieById(){
        webTestClient.delete()
                .uri("/movie/{id}","testId")
                .exchange()
                .expectStatus().isOk();
    }

}
