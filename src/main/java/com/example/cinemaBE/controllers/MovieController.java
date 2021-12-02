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

    @GetMapping("/category/{categoryCode}")
    public List<Movie> listByCategory(@PathVariable String categoryCode) {
        return movieService.listMoviesByCategory(categoryCode);
    }

    @GetMapping("/liked/{userId}")
    public List<Movie> listByCategory(@PathVariable int userId) {
        return movieService.listMoviesByLike(userId);
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
    public ResponseEntity<Movie> add(@RequestBody Movie movie) {
        try {
            return new ResponseEntity<>(movieService.saveMovie(movie), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/by-director")
    public ResponseEntity<List<Movie>> byDirector(@RequestParam Integer directorId) {
        try {
            List<Movie> movies = movieService.getMoviesByDirector(directorId);
            return new ResponseEntity<>(movies, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/delete/")
    public ResponseEntity<Movie> delete(@RequestBody Movie movie) {
        try {
            movieService.deleteMovie(movie);
            return new ResponseEntity<>(movie, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}