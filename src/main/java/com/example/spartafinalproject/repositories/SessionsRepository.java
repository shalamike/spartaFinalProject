package com.example.spartafinalproject.repositories;

import com.example.spartafinalproject.model.sessionssupport.Sessions;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SessionsRepository extends MongoRepository<Sessions, String> {
}
