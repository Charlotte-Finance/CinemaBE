package com.example.cinemaBE.controllers;

import com.example.cinemaBE.domains.Movie;
import com.example.cinemaBE.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping("")
    public List<Movie> list() {
        return movieService.listAllMovie();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> get(@PathVariable Integer id) {
        try {
            Movie movie = movieService.getMovie(id);
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Movie movie) {
        movieService.saveMovie(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Movie movie, @PathVariable Integer id) {
        try {
            Movie existMovie = movieService.getMovie(id);
            movie.setId(id);
            movieService.saveMovie(movie);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        movieService.deleteMovie(id);
    }
}