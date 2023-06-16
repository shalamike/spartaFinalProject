package com.example.spartafinalproject.controllers;

import com.example.spartafinalproject.model.dtos.Movie;
import com.example.spartafinalproject.model.repositories.MoviesRepository;
import com.example.spartafinalproject.model.services.MovieServices;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class MoviesController {
    static Logger logger = Logger.getLogger(MoviesController.class.getName());
    private MoviesRepository repository;
    private MovieServices services;

    @Autowired
    public MoviesController(MoviesRepository repository, MovieServices services) {
        this.repository = repository;
        this.services = services;
    }

    @PostMapping("/movie")
    public ResponseEntity<?> createMovie(@Valid @RequestBody Movie movie) {
        if(services.doesMovieExist(movie)){
            return new ResponseEntity<>("A movie associated with the ID "+movie.getId()+" already exists", HttpStatus.BAD_REQUEST);
        }
        try {
            Movie addedMovie = repository.save(movie);
            return new ResponseEntity<>(addedMovie, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Movie has not been added  due to Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable("id") String id) {
        Optional<Movie> movie = repository.findMovieById(id);
        if (movie.isPresent()) {
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No movie with ID " + id + " found", HttpStatus.OK);
        }
    }

    @GetMapping("/movie/title/{title}")
    public ResponseEntity<?> getMovieByTitle(@PathVariable("title") String title) {
        Optional<List<Movie>> movies = repository.findMovieByTitleContaining(title);
        if (movies.isPresent()) {
            return new ResponseEntity<>(movies.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No movies with title " + title + " found", HttpStatus.OK);
        }
    }


    @PutMapping("/movie/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable("id") String id, @RequestBody Movie movieUpdates) {
        Optional<Movie> movie = repository.findMovieById(id);
        if (movie.isPresent() && movieUpdates != null) {
            Movie movieStored = services.updateMovie(movieUpdates, movie.get());
            return new ResponseEntity<>(movieStored, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Movie with ID " + id + " does not exist, no updates made", HttpStatus.OK);
        }
    }


    @DeleteMapping("/movie/{id}")
    public ResponseEntity<?> deleteMovieById(@PathVariable("id") String id) {
        Optional<Movie> movie = repository.findMovieById(id);
        if (movie.isPresent()) {
            repository.deleteById(id);
            return new ResponseEntity<>("The following was deleted: "+movie.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Movie with ID " + id + " does not exist, no deletions completed", HttpStatus.OK);
        }
    }

}
