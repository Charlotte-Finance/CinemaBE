package com.example.cinemaBE.services;

import com.example.cinemaBE.domains.Movie;
import com.example.cinemaBE.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> listAllMovie() {
        return movieRepository.findAll();
    }

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public Movie getMovie(Integer id) {
        return movieRepository.findById(id).get();
    }

    public void deleteMovie(Integer id) {
        movieRepository.deleteById(id);
    }
}