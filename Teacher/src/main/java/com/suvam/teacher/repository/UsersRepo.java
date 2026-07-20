package com.suvam.teacher.repository;

import com.suvam.teacher.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
