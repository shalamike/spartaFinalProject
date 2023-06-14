package com.example.spartafinalproject.repositories;

import com.example.spartafinalproject.model.moviessupport.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MoviesRepository extends MongoRepository<Movie,String> {
    @Query("{id: '?0'}")
    Movie findMovieById(String Id);
}
