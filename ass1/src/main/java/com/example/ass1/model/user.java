package com.example.ass1.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "\"user\"")
public class user {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;


    public user() {
    }

    public user(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public user(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
