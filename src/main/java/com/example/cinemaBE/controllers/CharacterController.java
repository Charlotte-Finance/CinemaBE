package com.example.cinemaBE.controllers;


import com.example.cinemaBE.domains.Character;
import com.example.cinemaBE.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    @Autowired
    CharacterService characterService;

    @GetMapping("")
    public List<Character> list() {
        return characterService.listAllCharacter();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> get(@PathVariable Integer id) {
        try {
            Character character = characterService.getCharacter(id);
            return new ResponseEntity<>(character, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Character> add(@RequestBody Character character) {
        try {
            return new ResponseEntity<>(characterService.saveCharacter(character), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/by-movie")
    public ResponseEntity<List<Character>> byMovie(@RequestParam Integer movieId) {
        try {
            List<Character> characters = characterService.getCharactersByMovie(movieId);
            return new ResponseEntity<>(characters, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/by-actor")
    public ResponseEntity<List<Character>> byActor(@RequestParam Integer actorId) {
        try {
            List<Character> characters = characterService.getCharactersByActor(actorId);
            return new ResponseEntity<>(characters, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/delete/")
    public ResponseEntity<Character> delete(@RequestBody Character character) {
        try {
            characterService.deleteCharacter(character);
            return new ResponseEntity<>(character, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}