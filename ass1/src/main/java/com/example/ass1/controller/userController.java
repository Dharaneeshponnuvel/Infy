package com.example.ass1.controller;

import com.example.ass1.model.userdetails;
import com.example.ass1.model.user;
import com.example.ass1.service.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class userController {

    @Autowired
    private UserServiceImpl userService;


    private String currentUsername;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        user user = userService.findByUsername(username);

        if (user != null && userService.checkPassword(password, user.getPassword())) {
            // Store the logged-in username in the instance variable
            this.currentUsername = username;
            return ResponseEntity.ok("Login successful.");
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials: Username or password is incorrect");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestParam String username, @RequestParam String password) {
        userService.saveUser(username, password);
        return ResponseEntity.ok("Signup successful. You can now login.");
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        // Clear the stored username on logout
        this.currentUsername = null;
        return ResponseEntity.ok("Logout successful");
    }


    @GetMapping("/user-details")
    public ResponseEntity<?> getUserDetails() {
        if (this.currentUsername != null) {
            userdetails userDetails = userService.getUserDetails(this.currentUsername);
            return ResponseEntity.ok(userDetails);
        } else {
            return ResponseEntity.badRequest().body("No user is logged in.");
        }
    }


    @PutMapping("/user-details/update/{username}")
    public ResponseEntity<?> updateUserDetails(@PathVariable String username, @RequestBody userdetails updatedDetails) {
        userdetails updatedUserDetails = userService.updateUserDetails(username, updatedDetails);

        if (updatedUserDetails != null) {
            return ResponseEntity.ok(updatedUserDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
