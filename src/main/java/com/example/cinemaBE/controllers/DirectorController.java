package com.example.cinemaBE.controllers;

import com.example.cinemaBE.domains.Director;
import com.example.cinemaBE.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/directors")
public class DirectorController {
    @Autowired
    DirectorService directorService;

    @GetMapping("")
    public List<Director> list() {
        return directorService.listAllDirector();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> get(@PathVariable Integer id) {
        try {
            Director director = directorService.getDirector(id);
            return new ResponseEntity<>(director, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Director> add(@RequestBody Director director) {
        try {
            return new ResponseEntity<>(directorService.saveDirector(director), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @PostMapping("/delete/")
    public ResponseEntity<Director> delete(@RequestBody Director director) {
        try {
            directorService.deleteDirector(director);
            return new ResponseEntity<>(director, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}