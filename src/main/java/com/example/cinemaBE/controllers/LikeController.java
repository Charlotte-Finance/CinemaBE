package com.example.cinemaBE.controllers;

import com.example.cinemaBE.domains.Like;
import com.example.cinemaBE.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/likes")
public class LikeController {
    @Autowired
    LikeService likeService;

    @GetMapping("")
    public List<Like> list() {
        return likeService.listAllLike();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Like> get(@PathVariable Integer id) {
        try {
            Like like = likeService.getLike(id);
            return new ResponseEntity<>(like, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/is_liked")
    public boolean isLiked(@RequestParam Integer userId, @RequestParam Integer movieId) {
        try {

            Like like = likeService.getLikeByUserAndMovie(userId, movieId);
            System.out.println(like);
            return like != null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @PostMapping("/change-like")
    public ResponseEntity<Like> changeLike(@RequestBody Map<String, String> likeData) {
        try {
            int userId = Integer.parseInt(likeData.get("user_id"));
            int movieId = Integer.parseInt(likeData.get("movie_id"));
            Boolean isLiked = Boolean.parseBoolean(likeData.get("is_liked"));
            Like like = likeService.changeLike(userId, movieId, isLiked);
            System.out.println(like);
            return new ResponseEntity<>(like, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Like like) {
        likeService.saveLike(like);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Like like, @PathVariable Integer id) {
        try {
            Like existLike = likeService.getLike(id);
            like.setId(id);
            likeService.saveLike(like);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        likeService.deleteLike(id);
    }
}