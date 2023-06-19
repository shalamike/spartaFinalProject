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
import java.util.logging.Level;
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
            logger.log(Level.INFO,"Movie with the ID \""+movie.getId()+"\" already exists");
            return new ResponseEntity<>("A movie associated with the ID "+movie.getId()+" already exists", HttpStatus.BAD_REQUEST);
        }
        try {
            Movie addedMovie = repository.save(movie);
            logger.log(Level.INFO,"Movie with the ID \""+movie.getId()+"\" returned to user");
            return new ResponseEntity<>(addedMovie, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.log(Level.WARNING,"Internal Server Error");
            return new ResponseEntity<>("Movie has not been added  due to Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable("id") String id) {
        Optional<Movie> movie = repository.findMovieById(id);
        if (movie.isPresent()) {
            logger.log(Level.INFO,"Movie ID: "+ movie.get().getId()+", Title: "+movie.get().getTitle()+" returned to user");
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        } else {
            logger.log(Level.INFO,"No movies with the ID \""+id+"\" found");
            return new ResponseEntity<>("No movie with ID " + id + " found", HttpStatus.OK);
        }
    }

    @GetMapping("/movie/title/{title}")
    public ResponseEntity<?> getMovieByTitle(@PathVariable("title") String title) {
        List<Movie> movies = repository.findMovieByTitleContaining(title);
        if (movies.isEmpty()) {
            logger.log(Level.INFO,"No movies with titles containing \""+title+"\" returned to user");
            return new ResponseEntity<>("No movies with title " + title + " found", HttpStatus.OK);
        } else {
            logger.log(Level.INFO,"List of movies with titles containing \""+title+"\" returned to user");
            return new ResponseEntity<>(movies, HttpStatus.OK);
        }
    }


    @PutMapping("/movie/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable("id") String id, @RequestBody Movie movieUpdates) {
        Optional<Movie> movie = repository.findMovieById(id);
        if (movie.isPresent() && movieUpdates != null) {
            Movie movieStored = services.updateMovie(movieUpdates, movie.get());
            logger.log(Level.INFO,"Movie with the ID \""+id+"\" returned to user");
            return new ResponseEntity<>(movieStored, HttpStatus.OK);
        } else {
            logger.log(Level.INFO,"No movies with the ID \""+id+"\" returned to user");
            return new ResponseEntity<>("Movie with ID " + id + " does not exist, no updates made", HttpStatus.OK);
        }
    }


    @DeleteMapping("/movie/{id}")
    public ResponseEntity<?> deleteMovieById(@PathVariable("id") String id) {
        Optional<Movie> movie = repository.findMovieById(id);
        if (movie.isPresent()) {
            repository.deleteById(id);
            logger.log(Level.INFO,"Movie with the ID \""+id+"\" deleted by user");
            return new ResponseEntity<>("The following was deleted: "+movie.get(), HttpStatus.OK);
        } else {
            logger.log(Level.INFO,"No movies with the ID \""+id+"\" found, no deletion completed");
            return new ResponseEntity<>("Movie with ID " + id + " does not exist, no deletions completed", HttpStatus.OK);
        }
    }

}
