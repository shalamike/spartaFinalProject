package com.example.spartafinalproject.controllers;

import com.example.spartafinalproject.model.dtos.Theaters;
import com.example.spartafinalproject.model.repositories.TheatersRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/theaters/")
public class TheaterController {

    private TheatersRepository theatersRepository;

    private final ObjectMapper mapper;

    @Autowired
    TheaterController(TheatersRepository theatersRepository, ObjectMapper mapper){
        this.theatersRepository = theatersRepository;
        this.mapper = mapper;
    }

    @GetMapping("all")
    public ResponseEntity<String>getAllTheaters(){
        List<Theaters> theaterList = theatersRepository.findAll();
        if (theaterList.size()!=0)
            return getStringResponseEntity(theaterList);
        else{
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("content-type", "application/json");
            return new ResponseEntity<>("{\"message\":\"no theaters actually exist\"}", httpHeaders, HttpStatus.OK);
        }
    }

    @GetMapping("theaterid/{theaterid}")
    public ResponseEntity<?>getTheaterByTheaterId(@PathVariable int theaterid){
        Optional<Theaters> theater = theatersRepository.findByTheaterId(theaterid);
        if (theater.isPresent())
            return new ResponseEntity<>(theater.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>("No theater with theaterId " + theaterid + " found", HttpStatus.OK);
    }

    @GetMapping(value = "id/{id}")
    public ResponseEntity<?>getTheaterByIdString(@PathVariable String id){
        Optional<Theaters> theater = theatersRepository.findById(id);
        if (theater.isPresent())
            return new ResponseEntity<>(theater.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>("No theater with id " + id + " found", HttpStatus.OK);

    }

    @PostMapping(value = "")
    public ResponseEntity<?> addTheater(@RequestBody Theaters theater){
        if(!theatersRepository.existsById(theater.getId()) && theatersRepository.findByTheaterId(theater.getTheaterId()).isEmpty())
            return new ResponseEntity<>(theatersRepository.save(theater), HttpStatus.CREATED);
        else
            return new ResponseEntity<>("A Theater with this ID already exists!", HttpStatus.BAD_REQUEST);
    }

    @PutMapping(value = "theaterid/{id}")
    public ResponseEntity<?> updateTheaterByTheaterId(@PathVariable Integer id, @RequestBody Theaters theater){
        Optional<Theaters> theaterToUpdate = theatersRepository.findByTheaterId(id);
        return getResponseEntity(theater, theaterToUpdate);
    }

    @PutMapping(value = "id/{id}")
    public ResponseEntity<?> updateTheaterById(@PathVariable String id, @RequestBody Theaters theater){
        Optional<Theaters> theaterToUpdate = theatersRepository.findById(id);
        return getResponseEntity(theater, theaterToUpdate);
    }

    private ResponseEntity<?> getResponseEntity(@RequestBody Theaters theater, Optional<Theaters> theaterToUpdate) {
        int originalTheaterId = theaterToUpdate.get().getTheaterId();
        String originalId = theaterToUpdate.get().getId();
        if(theaterToUpdate.isPresent())
            if (originalId.equals(theater.getId()) && originalTheaterId == theater.getTheaterId())
                return new ResponseEntity<>(theatersRepository.save(theater), HttpStatus.CREATED);
            else
                return new ResponseEntity<>("Keys do not match with the original entry, please ensure they stay the same when updating", HttpStatus.BAD_REQUEST);
        else
            return new ResponseEntity<>("A Theater with this ID doesnt exist, Use Post to create one", HttpStatus.BAD_REQUEST);
    }


    @DeleteMapping(value = "id/{id}")
    public ResponseEntity<?>deleteById(@PathVariable String id){
        Optional<Theaters> theaterToDelete = theatersRepository.findById(id);
        if (theaterToDelete.isPresent()){
            theatersRepository.deleteById(id);
            return new ResponseEntity<>("Theater deleted",  HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("No theater found to delete", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "theaterid/{theaterid}")
    public ResponseEntity<String>deleteBytheaterId(@PathVariable Integer theaterid){
        Optional<Theaters> theaterToDelete = theatersRepository.findByTheaterId(theaterid);
        if (theaterToDelete.isPresent()){
            theatersRepository.deleteByTheaterId(theaterid);
            return new ResponseEntity<>("Theater deleted",  HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("No theater found to delete", HttpStatus.BAD_REQUEST);
        }
    }


    private ResponseEntity<String> getStringResponseEntity(List<Theaters> theaters) {
        new HttpHeaders().add("content-type", "application/json");
        if (theaters.size()!=0) {
            ResponseEntity<String> response = null;
            try {
                response = new ResponseEntity<>(
                        mapper.writeValueAsString(theaters),
                        new HttpHeaders(),
                        HttpStatus.OK
                );
                return response;
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity<>(
                "{\"message\":\"This Theater doesnt exist\"}",
                new HttpHeaders(),
                HttpStatus.NOT_FOUND);
    }

}
