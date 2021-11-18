package com.example.cinemaBE.domains;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "actor")
public class Actor {
    private int id;
    private String name;
    private String firstname;
    private Date birth;
    private Date death;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Basic
    public Date getDeath() {
        return death;
    }

    public void setDeath(Date death) {
        this.death = death;
    }
}