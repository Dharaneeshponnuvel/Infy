package com.example.ass1.reposistory;

import com.example.ass1.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<user, Long> {
    user findByUsername(String username);
}
