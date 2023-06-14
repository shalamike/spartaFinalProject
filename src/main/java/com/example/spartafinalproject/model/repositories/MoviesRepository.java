package com.example.spartafinalproject.model.repositories;

import com.example.spartafinalproject.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MoviesRepository extends MongoRepository<Movie,String> {
    @Query("{id: '?0'}")
    Movie findMovieById(String Id);

    List<Movie> findMovieByTitleContaining(String title);
}
