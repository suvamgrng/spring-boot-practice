package com.suvam.teacher.repository;

import com.suvam.teacher.model.Teacher;
import com.suvam.teacher.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Teacher, Integer> {
    Users findByUsername(String username);
}
