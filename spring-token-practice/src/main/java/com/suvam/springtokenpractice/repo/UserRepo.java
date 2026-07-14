package com.suvam.springtokenpractice.repo;

import com.suvam.springtokenpractice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
