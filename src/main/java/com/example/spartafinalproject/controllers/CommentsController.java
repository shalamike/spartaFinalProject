package com.example.spartafinalproject.controllers;

import com.example.spartafinalproject.model.dtos.Comment;
import com.example.spartafinalproject.model.dtos.Movie;
import com.example.spartafinalproject.model.repositories.CommentsRepository;
import com.example.spartafinalproject.model.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class CommentsController {
    private CommentsRepository commentsRepository;
    private MoviesRepository moviesRepository;

    @Autowired
    public CommentsController(CommentsRepository commentsRepository, MoviesRepository moviesRepository) {
        this.commentsRepository = commentsRepository;
        this.moviesRepository = moviesRepository;
    }

    @GetMapping("/comments")
    public ResponseEntity<?> getAllComments() {
        List<Comment> comments = commentsRepository.findAll();
        if(comments.isEmpty()) {
            return new ResponseEntity<>("There are no comments!", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(comments, HttpStatus.OK);
        }
    }

    @GetMapping("/comments/movie")
    public ResponseEntity<?> getCommentsByMovie(@RequestParam String id) {
        Optional<Movie> movie = moviesRepository.findById(id);
        if(movie.isEmpty()) {
            return new ResponseEntity<>("Movie does not exist!", HttpStatus.BAD_REQUEST);
        }

        List<Comment> comments = commentsRepository.findCommentByMovieId(id);
        if(!comments.isEmpty()) {
            return new ResponseEntity<>(comments, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("There are no comments for this movie!", HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/comment")
    public ResponseEntity<?> getCommentById(@RequestParam String id) {
        Optional<Comment> comment = commentsRepository.findById(id);

        if(comment.isPresent()) {
            return new ResponseEntity<>(comment.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Comment does not exist!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/comment")
    public ResponseEntity<?> createComment(@RequestBody Comment comment) {
        Optional<Comment> _comment = commentsRepository.findById(comment.getId());

        if(_comment.isPresent()) {
            return new ResponseEntity<>("A comment with this ID already exists!", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(commentsRepository.save(comment), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/comment")
    public ResponseEntity<String> deleteComment(@RequestParam String id) {
        Optional<Comment> comment = commentsRepository.findById(id);

        if(comment.isPresent()) {
            commentsRepository.delete(comment.get());
            return new ResponseEntity<>("Comment successfully deleted!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find comment to delete!", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/comment")
    public ResponseEntity<?> updateComment(@RequestParam String id, @RequestBody Comment comment) {
        Optional<Comment> commentData = commentsRepository.findById(id);

        if (commentData.isPresent()) {
            Comment _comment = commentData.get();

            Date date = comment.getDate();
            if (date != null) _comment.setDate(date);
            String email = comment.getEmail();
            if (email != null) _comment.setEmail(email);
            String moveId = comment.getMovieId();
            if (moveId != null) _comment.setMovieId(moveId);
            String text = comment.getText();
            if (text != null) _comment.setText(text);
            String name = comment.getName();
            if (name != null) _comment.setName(name);

            return new ResponseEntity<>(commentsRepository.save(_comment), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find comment to update!", HttpStatus.BAD_REQUEST);
    }
}
















}
