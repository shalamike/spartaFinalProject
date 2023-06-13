package com.example.spartafinalproject.model.repositories;

import com.example.spartafinalproject.model.dtos.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CommentRepository extends MongoRepository<Comment,String> {
    @Query("{id: '?0'}")
    Comment findCommentById(String id);
}
