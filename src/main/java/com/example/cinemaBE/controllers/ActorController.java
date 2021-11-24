package com.example.cinemaBE.controllers;

import com.example.cinemaBE.domains.Actor;
import com.example.cinemaBE.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/actors")
public class ActorController {
    @Autowired
    ActorService actorService;

    @GetMapping("")
    public List<Actor> list() {
        return actorService.listAllActor();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> get(@PathVariable Integer id) {
        try {
            Actor actor = actorService.getActor(id);
            return new ResponseEntity<>(actor, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/by-movie")
    public ResponseEntity<List<Actor>> byMovie(@RequestParam Integer movieId) {
        try {
            List<Actor> actors = actorService.getActorsByMovieId(movieId);
            return new ResponseEntity<>(actors, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Actor actor) {
        actorService.saveActor(actor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Actor actor, @PathVariable Integer id) {
        try {
            Actor existActor = actorService.getActor(id);
            actor.setId(id);
            actorService.saveActor(actor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        actorService.deleteActor(id);
    }
}