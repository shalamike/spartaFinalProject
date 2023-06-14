package com.example.spartafinalproject.model.repositories;

import com.example.spartafinalproject.model.dtos.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<User, String> {
}
