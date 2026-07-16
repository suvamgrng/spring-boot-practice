package com.suvam.student.service;

import com.suvam.student.model.Teacher;
import com.suvam.student.repository.TeacherRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepo repo;

    public TeacherService(TeacherRepo repo) {
        this.repo = repo;
    }

    public List<Teacher> getStudent() {
        return repo.findAll();
    }
}
