package com.example.ass1.reposistory;

import com.example.ass1.model.userdetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<userdetails, Long> {
    userdetails findByUsername(String username);
}
