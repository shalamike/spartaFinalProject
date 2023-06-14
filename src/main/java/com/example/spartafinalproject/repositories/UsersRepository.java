package com.example.spartafinalproject.repositories;

import com.example.spartafinalproject.model.userssupport.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users, String> {
}
