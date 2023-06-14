package com.example.spartafinalproject.model.respositories;

import com.example.spartafinalproject.model.dtos.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UsersRepository extends MongoRepository<User, String> {
    @Query("{id: '?0'}")
    User findUserById(String id);


}


