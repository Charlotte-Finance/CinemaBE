package com.example.cinemaBE.domains;

import javax.persistence.*;

@Entity
@Table(name = "likes")
public class Like {
    private int id;
    private int userId;
    private int movieId;

    public Like(int userId, int movieId){
        this.userId = userId;
        this.movieId = movieId;
    }

    public Like() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}