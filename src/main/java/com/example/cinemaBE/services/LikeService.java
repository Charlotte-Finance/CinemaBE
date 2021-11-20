package com.example.cinemaBE.services;

import com.example.cinemaBE.domains.Like;
import com.example.cinemaBE.domains.User;
import com.example.cinemaBE.repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public List<Like> listAllLike() {
        return likeRepository.findAll();
    }

    public void saveLike(Like like) {
        likeRepository.save(like);
    }

    public Like getLike(Integer id) {
        return likeRepository.findById(id).get();
    }

    public void deleteLike(Integer id) {
        likeRepository.deleteById(id);
    }

    public Like getLikeByUserAndMovie(int user_id, int movie_id) {
        return likeRepository.findByUserIdAndMovieId(user_id, movie_id);
    }

    public Like changeLike(int user_id, int movie_id, boolean isLiked) {
        Like like = likeRepository.findByUserIdAndMovieId(user_id, movie_id);
        if (like == null) {
            Like newLike = new Like(user_id, movie_id);
            saveLike(newLike);
            return newLike;
        } else {
            deleteLike(like.getId());
            return like;
        }
    }
}