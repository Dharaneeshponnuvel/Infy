package com.example.ass1.model;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "users-details")
public class userdetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String username;
    private String sport;
    private String gender;
    private int age;
    private String country;
    private String city;
    private int height;
    private int weight;
    private int mobileNumber;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getSport() {
        return sport;
    }
    public void setSport(String sport) {
        this.sport = sport;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public userdetails() {}
    public userdetails(String username, String sport, String gender, int age, String country, String city, int height, int weight, int mobileNumber) {
        this.username = username;
        this.sport = sport;
        this.gender = gender;
        this.age = age;
        this.country = country;
        this.city = city;
        this.height = height;
        this.weight = weight;
        this.mobileNumber = mobileNumber;
    }
    public userdetails(Long id, String username, String sport, String gender, int age, String country, String city, int height, int weight, int mobileNumber) {

    }



}
