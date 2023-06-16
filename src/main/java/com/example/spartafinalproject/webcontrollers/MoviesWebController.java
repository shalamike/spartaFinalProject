package com.example.spartafinalproject.webcontrollers;

import com.example.spartafinalproject.model.dtos.Movie;
import com.example.spartafinalproject.model.repositories.MoviesRepository;
import com.example.spartafinalproject.model.services.MovieServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String postMovieToCreate(@ModelAttribute("movieToCreate")Movie movie){
//        Model model =;
        if(movieServices.doesMovieExist(movie)){
            Movie existingMovie = moviesRepository.findMovieById(movie.getId()).get();
//            model.addAttribute("existingMovie",existingMovie);
            return "movie-already-exists";
        }
        try {
            Movie addedMovie = moviesRepository.save(movie);
//            model.addAttribute("addedMovie",addedMovie);
            return "movie-create-success";
        } catch (Exception e) {
//            model.addAttribute("movie",movie);
            return "movie-create-error";
        }
    }
    //read
    //update
    //delete
}
