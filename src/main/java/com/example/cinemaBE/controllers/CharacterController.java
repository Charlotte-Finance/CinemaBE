package com.example.cinemaBE.controllers;


import com.example.cinemaBE.domains.Character;
import com.example.cinemaBE.domains.Director;
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
    public void add(@RequestBody Character character) {
        characterService.saveCharacter(character);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Character character, @PathVariable int id) {
        try {
            Character existCharacter = characterService.getCharacter(id);
            character.setId(id);
            characterService.saveCharacter(character);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        characterService.deleteCharacter(id);
    }
}