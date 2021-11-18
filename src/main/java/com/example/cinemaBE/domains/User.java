package com.example.cinemaBE.domains;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    private int id;
    private String username;
    private String password;
    private String role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
