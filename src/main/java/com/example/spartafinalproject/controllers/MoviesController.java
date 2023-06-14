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
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
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
        try {
            Movie addedMovie = repository.save(movie);//throws MethodArgumentNotValidException if one of the NotNull fields are violated
            return new ResponseEntity<>(addedMovie, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable("id") String id) {
        Optional<Movie> movie = repository.findMovieById(id);
        if (movie.isPresent()) {
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No movie with id " + id + " found", HttpStatus.OK);
        }
        /*EXCEPTION THROWN WHEN DATE IS ENTERED INCORRECTLY
        Resolved [org.springframework.http.converter.HttpMessageNotReadableException: JSON parse error: Cannot deserialize value of type `java.util.Date` from String "hjhhsfj": not a valid representation (error: Failed to parse Date value 'hjhhsfj': Cannot parse date "hjhhsfj": not compatible with any of standard forms ("yyyy-MM-dd'T'HH:mm:ss.SSSX", "yyyy-MM-dd'T'HH:mm:ss.SSS", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd"))]
         */
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
            /*  EXCEPTION THROWN WHEN NO REQUEST BODY IS ADDED
            [org.springframework.http.converter.HttpMessageNotReadableException: Required request body is missing: public org.springframework.http.ResponseEntity<?> com.example.spartafinalproject.controllers.MoviesController.updateMovie(java.lang.String,com.example.spartafinalproject.model.dtos.Movie)]
             */
            return new ResponseEntity<>(movieStored, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Movie with ID " + id + " does not exist, no updates made", HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/movie/{id}")
    public ResponseEntity<?> deleteMovieById(@PathVariable("id") String id) {
        Optional<Movie> movie = repository.findMovieById(id);
        if (movie.isPresent()) {
            repository.deleteById(id);
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No movie with id " + id + " found", HttpStatus.OK);
        }
    }

}
