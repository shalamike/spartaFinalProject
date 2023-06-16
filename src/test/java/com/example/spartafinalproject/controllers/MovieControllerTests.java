package com.example.spartafinalproject.controllers;

import com.example.spartafinalproject.model.dtos.Movie;
import com.example.spartafinalproject.repositories.MoviesRepositoryTests;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MovieControllerTests {
    @Autowired
    WebTestClient webTestClient;

    @Test
    @Order(1)
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
    @Order(2)
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
    @Order(3)
    @DisplayName("Testing getMovieByTitle response")
    void testGetMovieByTitle(){
        Movie movie = MoviesRepositoryTests.getMovie();
        webTestClient.get()
                .uri("movie/title/{title}",movie.getTitle())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Movie.class);

    }



    @Test
    @Order(4)
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
    @Order(5)
    @DisplayName("Testing deleteMovieById response")
    void testDeleteMovieById(){
        webTestClient.delete()
                .uri("/movie/{id}","testId")
                .exchange()
                .expectStatus().isOk();
    }

}
