package com.example.spartafinalproject.repositories;

import com.example.spartafinalproject.model.theatersupport.Theaters;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface TheatersRepository extends MongoRepository<Theaters, String> {
//    String findById(int id);

    @Query("{id: '?0'}")
    Optional<Theaters> findById(String id);

    @Query
    Optional<Theaters>findByTheaterId(Integer id);

    @Query
    void deleteByTheaterId(Integer id);


}
