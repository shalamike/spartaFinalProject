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

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class TheaterController {

    private TheatersRepository theatersRepository;

    private final ObjectMapper mapper;

    @Autowired
    TheaterController(TheatersRepository theatersRepository, ObjectMapper mapper){
        this.theatersRepository = theatersRepository;
        this.mapper = mapper;
    }

    @GetMapping("theaters/all")
    public ResponseEntity<String>getAllTheaters(){
        Optional<Theaters> theaterList = theatersRepository.findAll().stream().findAny();
        return getStringResponseEntity(theaterList.stream().toList());
    }

    @GetMapping("theaters/theaterId/{theaterId}")
    public ResponseEntity<String>getTheaterByTheaterId(@PathVariable int theaterId){
        Optional<Theaters> theater = theatersRepository.findByTheaterId(theaterId);
        List<Theaters> theaters = new ArrayList<>();
        theaters.add(theater.get());
        return getStringResponseEntity(theaters);
    }

    @GetMapping(value = "/theaters/id/{id}")
    public ResponseEntity<String>getTheaterByIdString(@PathVariable String id){
        Optional<Theaters> theater = theatersRepository.findById(id);
        List<Theaters> theaters = new ArrayList<>();
        theaters.add(theater.get());
        return getStringResponseEntity(theaters);
    }

    @PostMapping(value = "/theaters")
    public ResponseEntity<String> addTheater(@RequestBody Theaters theater){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("content-type", "application/json");
        if (theatersRepository.existsById(theater.getId())) {
            ResponseEntity<String> response = new ResponseEntity<>("theater already exist and cannot be added", httpHeaders, HttpStatus.CONFLICT);
            return response;
        } else {
            ResponseEntity<String> theaterCreatedResponse = new ResponseEntity<>("{\"message\":\"new theater added\"}", httpHeaders, HttpStatus.OK);
            theatersRepository.save(theater);
            return theaterCreatedResponse;
        }
    }

    @PutMapping(value = "/theater/{theaterid}")
    public ResponseEntity<String> updateTheater(@PathVariable Integer theaterid, @RequestBody Theaters theater){
        Optional<Theaters> theaterToUpdate = theatersRepository.findByTheaterId(theaterid);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("content-type", "application/json");
        if (theaterToUpdate.isPresent()){
            ResponseEntity<String> response = new ResponseEntity<>("Theater updated", httpHeaders, HttpStatus.OK
            );
            Theaters updatedTheater = theaterToUpdate.get();
            updatedTheater.setLocation(theater.getLocation());
            updatedTheater.setId(theater.getId());
            theatersRepository.save(updatedTheater);
            return  response;
        }
        else {
            ResponseEntity<String> theaterNotFoundResponse = new ResponseEntity<>("{\"message\":\"Theater doesnt exist. Use Post to create one instead\"}", httpHeaders, HttpStatus.BAD_REQUEST);
            return theaterNotFoundResponse;
        }
    }

    @DeleteMapping(value = "/theater/id/{id}")
    public ResponseEntity<String>deleteById(@PathVariable String id){
        Optional<Theaters> theaterToDelete = theatersRepository.findById(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("content-type", "application/json");
        if (theaterToDelete.isPresent()){
            ResponseEntity<String> response = new ResponseEntity<>("Theater deleted", httpHeaders, HttpStatus.OK);
            theatersRepository.deleteById(id);
            return response;
        }
        else {
            ResponseEntity<String> theaterNotFoundResponse = new ResponseEntity<>("{\"message\":\"Theater to delete doesnt exist\"}", httpHeaders, HttpStatus.BAD_REQUEST);
            return theaterNotFoundResponse;
        }
    }

    @DeleteMapping(value = "/theater/theaterid/{id}")
    public ResponseEntity<String>deleteBytheaterId(@PathVariable Integer id){
        Optional<Theaters> theaterToDelete = theatersRepository.findByTheaterId(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("content-type", "application/json");
        if (theaterToDelete.isPresent()){
            ResponseEntity<String> response = new ResponseEntity<>("Theater deleted", httpHeaders, HttpStatus.OK);
            theatersRepository.deleteByTheaterId(id);
            return response;
        }
        else {
            ResponseEntity<String> theaterNotFoundResponse = new ResponseEntity<>("{\"message\":\"Theater to delete doesnt exist\"}", httpHeaders, HttpStatus.BAD_REQUEST);
            return theaterNotFoundResponse;
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
        ResponseEntity<String> theaterNotFound = new ResponseEntity<>(
                "{\"message\":\"This Theater doesnt exist\"}",
                new HttpHeaders(),
                HttpStatus.NOT_FOUND);
        return theaterNotFound;
    }

}
