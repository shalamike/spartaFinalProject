package com.example.spartafinalproject.repositories;

import com.example.spartafinalproject.model.dtos.Comment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class CommentsRepositoryTests {

    @Autowired
    CommentsRepository commentsRepository;

    @Test
    @DisplayName("Check that a comment is returned when requesting to find a comment with a valid ID")
    void checkFindCommentByValidId() {
        Comment comment = commentsRepository.findById("5a9427648b0beebeb69579e7").get();
        Assertions.assertNotNull(comment);
    }

    @Test
    @DisplayName("Check that a comment can be successfully created")
    void checkSaveNewComment() {
        commentsRepository.save(new Comment(new Date(2023-05-14), "John Smith", "abcde1234", "This movie was so amazing", "573a1390f29313caabcd4135", "johnsmith@gmail.com"));
        Comment comment = commentsRepository.findById("abcde1234").get();
        Assertions.assertNotNull(comment);

    }

}
