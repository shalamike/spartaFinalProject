package com.example.spartafinalproject.webcontrollers;

import com.example.spartafinalproject.controllers.MoviesController;
import com.example.spartafinalproject.model.dtos.Movie;
import com.example.spartafinalproject.model.dtos.moviessupport.Tomatoes;
import com.example.spartafinalproject.model.dtos.moviessupport.Viewer;
import com.example.spartafinalproject.model.repositories.MoviesRepository;
import com.example.spartafinalproject.model.services.MovieServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/web")
public class MoviesWebController {
    static Logger logger = Logger.getLogger(MoviesWebController.class.getName());

    private MoviesRepository moviesRepository;
    private MovieServices movieServices;

    @Autowired
    public MoviesWebController(MoviesRepository moviesRepository, MovieServices movieServices) {
        this.moviesRepository = moviesRepository;
        this.movieServices = movieServices;
    }

    //create
    @GetMapping("/movie/create")
    public String getMovieToCreate(Model model) {
        Movie movie = new Movie();
        model.addAttribute("movieToCreate", movie);
        logger.log(Level.INFO,"User sent to enter movie details via movie-create-form");
        return "movie-create-form";
    }

    @PostMapping("/movie/create")
    public String postMovieToCreate(@ModelAttribute("movieToCreate") Movie movie) throws IllegalAccessException {
        movieServices.setEmptyAttributesToNull(movie);
        if (movieServices.doesMovieExist(movie)) {
            logger.log(Level.INFO,"Movie with the ID \""+movie.getId()+"\" already exists");
            return "movie-already-exists";
        }
        try {
            Movie addedMovie = moviesRepository.save(movie);
            logger.log(Level.INFO,"Movie with the ID \""+movie.getId()+"\" returned to user");
            return "movie-create-success";
        } catch (Exception e) {
            logger.log(Level.WARNING,"Internal Server Error");
            return "movie-create-error";
        }
    }

    //read

    //getMovieById add hateoas

    @GetMapping("/movies/titles/{title}")
    public String getMoviesByTitle(Model model, @PathVariable String title) {
        List<Movie> movies = moviesRepository.findMovieByTitleContaining(title);
        if (movies.isEmpty()) {
            logger.log(Level.INFO,"No movies with titles containing \""+title+"\" returned to user");
            return "no-movies-found";
        } else {
            logger.log(Level.INFO,"List of movies with titles containing \""+title+"\" returned to user");
            model.addAttribute("movies", movies);
            return "movies";
        }
    }

    //update
    //delete
    @GetMapping("/movie/delete/{id}")
    String deleteMovie(@PathVariable String id) {
        Optional<Movie> movie = moviesRepository.findMovieById(id);
        if (movie.isPresent()) {
            moviesRepository.deleteById(id);
            logger.log(Level.INFO, "Movie with the ID \"" + id + "\" deleted by user");
            return "movie-confirm-delete";
        }else {
            logger.log(Level.INFO,"No movies with the ID \""+id+"\" found, no deletion completed");
            return "no-movies-found";
        }
    }
}
