package com.example.cinemaBE.domains;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    private String code;
    private String label;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}