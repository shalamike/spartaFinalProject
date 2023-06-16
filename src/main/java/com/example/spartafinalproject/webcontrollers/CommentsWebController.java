package com.example.spartafinalproject.webcontrollers;

import com.example.spartafinalproject.model.dtos.Comment;
import com.example.spartafinalproject.model.dtos.Movie;
import com.example.spartafinalproject.model.repositories.CommentsRepository;
import com.example.spartafinalproject.model.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentsWebController {

    private final CommentsRepository commentsRepository;
    private final MoviesRepository moviesRepository;

    @Autowired
    public CommentsWebController(CommentsRepository commentsRepository, MoviesRepository moviesRepository) {
        this.commentsRepository = commentsRepository;
        this.moviesRepository = moviesRepository;
    }

    @GetMapping("/comments")
    public String getAllComments(Model model) {
        model.addAttribute("comments", commentsRepository.findAll());
        return "comments";
    }

    @GetMapping("/comments/movie/{id}")
    public String getAllCommentsByMovie(@PathVariable String id, Model model) {
        model.addAttribute("comments", commentsRepository.findCommentByMovieId(id));
        return "movie-comments";
    }

    @GetMapping("/comment/{id}")
    public String getComment(@PathVariable String id, Model model) {
        Comment comment = commentsRepository.findById(id).orElse(null);
        model.addAttribute("comment", comment);

        try {
            if(comment!= null) {
                Movie movie = moviesRepository.findById(comment.getMovieId()).orElse(null);
                model.addAttribute("movie", movie);
            }
        } catch(IllegalArgumentException ignored) {}

        return "comment";
    }

    @GetMapping("/comment/create")
    public String showCommentForm(Model model) {
        Comment comment = new Comment();
        model.addAttribute("commentToCreate", comment);
        return "comment-create-form";
    }

    @PostMapping("/comment/create")
    public String createComment(@ModelAttribute("commentToCreate") Comment comment) {
        commentsRepository.save(comment);
        return "create-comment-success";
    }



}
