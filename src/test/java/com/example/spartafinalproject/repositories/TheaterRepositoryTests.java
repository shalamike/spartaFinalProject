package com.example.spartafinalproject.repositories;

import com.example.spartafinalproject.model.repositories.TheatersRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TheaterRepositoryTests {

    @Autowired
    TheatersRepository theatersRepository;

    @Test
    @DisplayName("check that the theater list is not null")
    public void testIfTheatersNotNull(){
        Assertions.assertNotNull(theatersRepository.findAll());
    }

    @Test
    @DisplayName("check that the theater list is not 0")
    public void testIfTheatersNotZero(){
        Assertions.assertTrue(theatersRepository.findAll().size() > 0);
    }

    @Test
    @DisplayName("check that user can search for correct theater by given theater id 1420")
    public void testFindByTheaterId1420(){
        Assertions.assertEquals("59a47286cfa9a3a73e51e81d",theatersRepository.findByTheaterId(1420).get().getId());
    }


    @Test
    @DisplayName("check that user can search for correct theater by given theater id 1006")
    public void testFindByTheaterId1009(){
        Assertions.assertEquals("59a47286cfa9a3a73e51e73e",theatersRepository.findByTheaterId(1009).get().getId());

    }

    @Test
    @DisplayName("check that user can search for correct theater by given theater id 1057")
    public void testFindByTheaterId1057(){
        Assertions.assertEquals("59a47286cfa9a3a73e51e791",theatersRepository.findByTheaterId(1057).get().getId());
    }



}
