package com.example.spartafinalproject.model.repositories;

import com.example.spartafinalproject.model.dtos.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentsRepository extends MongoRepository<Comment,String> {

    @Query
    List<Comment> findCommentByMovieId(String id);
}
