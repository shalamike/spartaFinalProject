package com.example.spartafinalproject.services;

import com.example.spartafinalproject.model.dtos.Movie;
import com.example.spartafinalproject.model.repositories.MoviesRepository;
import com.example.spartafinalproject.model.services.MovieServices;
import com.example.spartafinalproject.repositories.MoviesRepositoryTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class MovieServicesTests {
    @Autowired
    MovieServices movieServices;
    @Autowired
    MoviesRepository moviesRepository;


    @Test
    @DisplayName("Test updateMovie method")
    void testUpdateMovie(){
        Movie oldMovie = MoviesRepositoryTests.getMovie();
        moviesRepository.save(oldMovie);

        Movie updatedMovie = MoviesRepositoryTests.getMovie();
        updatedMovie.setTitle("Update Title");
        updatedMovie.setType("series");
        movieServices.updateMovie(updatedMovie,oldMovie);

        Optional<Movie> result = moviesRepository.findById(oldMovie.getId());
        Assertions.assertEquals(updatedMovie.getTitle(),result.get().getTitle());
        moviesRepository.deleteById(updatedMovie.getId());
    }

    @Test
    @DisplayName("Test doesMovieExist method")
    void testDoesMovieExist(){
        Movie movie = MoviesRepositoryTests.getMovie();
        moviesRepository.save(movie);
        Assertions.assertTrue(movieServices.doesMovieExist(movie));
        moviesRepository.deleteById(movie.getId());
    }
}
