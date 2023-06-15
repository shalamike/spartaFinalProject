package com.example.spartafinalproject.repositories;

import com.example.spartafinalproject.model.dtos.Movie;
import com.example.spartafinalproject.model.repositories.MoviesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class MoviesRepositoryTests {
    @Autowired
    MoviesRepository moviesRepository;

    private Movie getMovie(){
        Movie movie = new Movie("Test Movie", 2023,"movie");
        movie.setId("testId");
        return movie;
    }

    @Test
    @DisplayName("Testing findMovieById method")
    void testFindMovieById(){
        Movie movie = getMovie();
        moviesRepository.save(movie);
        Optional<Movie> result = moviesRepository.findMovieById(movie.getId());
        Assertions.assertEquals(movie.getId(),result.get().getId());
    }

}
