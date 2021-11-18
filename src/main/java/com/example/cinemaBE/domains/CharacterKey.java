package com.example.cinemaBE.domains;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CharacterKey implements Serializable {
    private int actorId;
    private int movieId;

    public CharacterKey() {

    }

    public CharacterKey(int actorId, int movieId) {
        this.actorId = actorId;
        this.movieId = movieId;
    }

    @Basic
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Basic
    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

}

