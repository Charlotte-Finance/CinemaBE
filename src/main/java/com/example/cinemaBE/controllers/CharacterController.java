package com.example.cinemaBE.controllers;


import com.example.cinemaBE.domains.Character;
import com.example.cinemaBE.domains.CharacterKey;
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

    @PutMapping("/{actorId}/{movieId}")
    public ResponseEntity<?> update(@RequestBody Character character, @PathVariable int actorId, @PathVariable int movieId) {
        try {
            CharacterKey key = new CharacterKey(actorId, movieId);
            character.setKey(key);
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