package com.example.spartafinalproject.model.repositories;

import com.example.spartafinalproject.model.dtos.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MoviesRepository extends MongoRepository<Movie,String> {
    @Query("{id: '?0'}")
    Optional<Movie> findMovieById(String Id);

    List<Movie> findMovieByTitleContaining(String title);
}
