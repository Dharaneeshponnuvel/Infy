package com.example.ass1.service;

import com.example.ass1.model.user;
import com.example.ass1.model.userdetails;
import com.example.ass1.reposistory.AppUserRepository;
import com.example.ass1.reposistory.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private UserDetailsRepository userDetailsRepository; // Add new repository

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private String currentUsername; // Remove @Autowired here


    public void saveUser(String username, String password) {
        user newUser = new user();
        newUser.setUsername(username);
        newUser.setPassword(bCryptPasswordEncoder.encode(password));
        userRepository.save(newUser);
    }


    public user findByUsername(String username) {
        this.currentUsername = username;
        return userRepository.findByUsername(username);
    }


    public boolean checkPassword(String rawPassword, String encodedPassword) {
        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
    }


    public userdetails getUserDetails(String username) {
        return userDetailsRepository.findByUsername(username);
    }


    public userdetails updateUserDetails(String username, userdetails updatedDetails) {

        userdetails existingDetails = userDetailsRepository.findByUsername(username);

        if (existingDetails != null) {

            if (updatedDetails.getSport() != null) {
                existingDetails.setSport(updatedDetails.getSport());
            }
            if (updatedDetails.getGender() != null) {
                existingDetails.setGender(updatedDetails.getGender());
            }
            if (updatedDetails.getAge() != 0) {
                existingDetails.setAge(updatedDetails.getAge());
            }
            if (updatedDetails.getCountry() != null) {
                existingDetails.setCountry(updatedDetails.getCountry());
            }
            if (updatedDetails.getCity() != null) {
                existingDetails.setCity(updatedDetails.getCity());
            }
            if (updatedDetails.getHeight() != 0) {
                existingDetails.setHeight(updatedDetails.getHeight());
            }
            if (updatedDetails.getWeight() != 0) {
                existingDetails.setWeight(updatedDetails.getWeight());
            }
            if (updatedDetails.getMobileNumber() != 0) {
                existingDetails.setMobileNumber(updatedDetails.getMobileNumber());
            }


            return userDetailsRepository.save(existingDetails);
        }
        return null;
    }

}
