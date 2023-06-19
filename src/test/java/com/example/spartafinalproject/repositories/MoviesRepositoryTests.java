package com.example.spartafinalproject.repositories;

import com.example.spartafinalproject.model.dtos.Movie;
import com.example.spartafinalproject.model.repositories.MoviesRepository;
import com.example.spartafinalproject.model.services.MovieServices;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MoviesRepositoryTests {
    @Autowired
    MoviesRepository moviesRepository;

    public static Movie getMovie(){
        Movie movie = new Movie("Test Movie", 2023,"movie");
        movie.setId("testId");
        return movie;
    }

    @Test
    @Order(1)
    @DisplayName("Testing findMovieById method")
    void testFindMovieById(){
        Movie movie = getMovie();
        moviesRepository.save(movie);
        Optional<Movie> result = moviesRepository.findMovieById(movie.getId());
        Assertions.assertEquals(movie.getId(),result.get().getId());
    }

    @Test
    @Order(2)
    @DisplayName("Testing findMovieByTitleContaining method")
    void testFindMovieByTitleContaining(){
        Movie movie = getMovie();
        moviesRepository.save(movie);
        List<Movie> results = moviesRepository.findMovieByTitleContaining(movie.getTitle());
        Assertions.assertNotNull(results);
    }

    @Test
    @Order(3)
    @DisplayName("Testing deleteById method")
    void testDeleteById(){
        Movie movie = getMovie();
        moviesRepository.deleteById(movie.getId());
        Optional<Movie> result = moviesRepository.findMovieById(movie.getId());
        Assertions.assertEquals(Optional.empty(),result);
    }

}
