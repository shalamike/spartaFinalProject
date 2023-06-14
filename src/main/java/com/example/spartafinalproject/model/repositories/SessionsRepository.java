package com.example.spartafinalproject.model.repositories;

import com.example.spartafinalproject.model.dtos.Sessions;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SessionsRepository extends MongoRepository<Sessions, String> {
}
