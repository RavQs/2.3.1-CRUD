package com.example.alishevcrud.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    private Long id;
    private String name;
    private String post;
    private byte age;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
