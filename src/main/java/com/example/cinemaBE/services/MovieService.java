package com.example.cinemaBE.services;

import com.example.cinemaBE.domains.Like;
import com.example.cinemaBE.domains.Movie;
import com.example.cinemaBE.domains.User;
import com.example.cinemaBE.repositories.LikeRepository;
import com.example.cinemaBE.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private LikeRepository likeRepository;
    public List<Movie> listAllMovie() {
        return movieRepository.findAll();
    }

    public List<Movie> listMoviesByCategory(String categoryCode) {
        return movieRepository.findByCategoryCode(categoryCode);
    }
    public List<Movie> listMoviesByLike(int userId) {
        List<Movie> movies = new ArrayList<>();
        List<Like> likes = likeRepository.findByUserId(userId);
        for (Like like : likes){
            Movie movie = movieRepository.findById(like.getMovieId());
            movies.add(movie);
        }
        return movies;
    }

    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie getMovie(Integer id) {
        return movieRepository.findById(id).get();
    }

    public void deleteMovie(Movie movie) {
        movieRepository.delete(movie);
    }
}