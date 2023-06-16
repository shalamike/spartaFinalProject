package com.example.spartafinalproject.webcontrollers;

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

@Controller
@RequestMapping("/web")
public class MoviesWebController {
    private MoviesRepository moviesRepository;
    private MovieServices movieServices;

    @Autowired
    public MoviesWebController(MoviesRepository moviesRepository, MovieServices movieServices) {
        this.moviesRepository = moviesRepository;
        this.movieServices = movieServices;
    }

    //create
    @GetMapping("/movie/create")
    public String getMovieToCreate(Model model){
        Movie movie=new Movie();
        model.addAttribute("movieToCreate",movie);
        return "movie-create-form";
    }

    @PostMapping("/movie/create")
    public String postMovieToCreate(@ModelAttribute("movieToCreate")Movie movie) throws IllegalAccessException {
        movieServices.setEmptyAttributesToNull(movie);
        if(movieServices.doesMovieExist(movie)){
            return "movie-already-exists";
        }
        try {
            Movie addedMovie = moviesRepository.save(movie);
            return "movie-create-success";
        } catch (Exception e) {
            return "movie-create-error";
        }
    }
    //read
    @GetMapping("/movies/titles/{title}")
    public String getMoviesByTitle(Model model,@PathVariable String title) {
        Optional<List<Movie>> movies = moviesRepository.findMovieByTitleContaining(title);
        if (movies.isPresent()) {
            model.addAttribute("movies",movies.get());
            return "movies";
        } else {
            return "no-movies-found";
        }
    }
    //update
    //delete
    @GetMapping("/movie/delete/{id}")
    String deleteMovie(@PathVariable String id){
        moviesRepository.deleteById(id);
        return "movie-confirm-delete";
    }
}
