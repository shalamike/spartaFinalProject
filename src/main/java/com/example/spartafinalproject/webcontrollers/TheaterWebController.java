package com.example.spartafinalproject.webcontrollers;


import com.example.spartafinalproject.model.dtos.Theaters;
import com.example.spartafinalproject.model.repositories.TheatersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("web")
public class TheaterWebController {

    private final TheatersRepository theatersRepository;

    @Autowired
    public TheaterWebController(TheatersRepository theatersRepository) {
        this.theatersRepository = theatersRepository;
    }

    @GetMapping("/theaters")
    public String getAllTheaters(Model model){
        model.addAttribute("theaters",theatersRepository.findAll());
        return "theaters-find";
    }

    @GetMapping("/theaters/id")
    public String getTheaterById(@RequestParam String id, Model model){
        model.addAttribute("theaters", theatersRepository.findById(id));
        return "theaters-find-by-id";
    }

    @GetMapping("/theaters/theaterid")
    public String getTheaterByTheaterId(@RequestParam int id, Model model){
        model.addAttribute("theaters", theatersRepository.findByTheaterId(id));
        return "theaters-find-by-id";
    }

    @GetMapping("/theaters/update/{id}")
    public String getTheaterToUpdate(@PathVariable String id, Model model){
        Optional<Theaters> theater= theatersRepository.findById(id);
        if(theater.isPresent()){
            model.addAttribute("theaterToUpdate", theater);
            return "theaters-update-form";
        } else
            return "theaters-not-found";
    }

    @GetMapping("/theaters/create")
    public String getTheaterToCreate(Model model){
            model.addAttribute("newTheater", new Theaters());
            return "theaters-create-form";
    }

    @PostMapping("/theaters/created")
    public String create(@ModelAttribute("newTheater")Theaters newTheater){
        if (theatersRepository.existsById(newTheater.getId()) || theatersRepository.findByTheaterId(newTheater.getTheaterId()).isPresent())
            return "theater-exists-form";
        else
            return "theaters-create-form";

    }

    @PostMapping("/theaters/update")
    public String updateTheater(@ModelAttribute("theaterToUpdate")Theaters theaterToUpdate){
        if ((theatersRepository.existsById(theaterToUpdate.getId()) && theatersRepository.findByTheaterId(theaterToUpdate.getTheaterId()).isPresent())){
            theatersRepository.save(theaterToUpdate);
            return "theaters-update-success";
        }
        else
            return "theaters-not-updated";
    }
}
