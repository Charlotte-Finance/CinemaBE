package com.example.cinemaBE.repositories;


import com.example.cinemaBE.domains.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Integer> {
    Like findByUserIdAndMovieId(int userId, int movieId);

    List<Like> findByUserId(int userId);
}