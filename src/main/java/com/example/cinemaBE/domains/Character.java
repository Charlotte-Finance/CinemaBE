package com.example.cinemaBE.domains;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "characters")
public class Character {
    @EmbeddedId
    private CharacterKey key;

    private String name;


    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterKey getKey() {
        return key;
    }

    public void setKey(CharacterKey key) {
        this.key = key;
    }

}