package com.suvam.student.repository;

import com.suvam.student.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface TeacherRepo extends JpaRepository<Teacher, Integer> {
    ResponseEntity<Teacher> readStudentById(int id);
}
