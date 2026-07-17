package com.suvam.teacher.service;

import com.suvam.teacher.model.Teacher;
import com.suvam.teacher.repository.TeacherRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final TeacherRepo repo;

    public TeacherService(TeacherRepo repo) {
        this.repo = repo;
    }

    public List<Teacher> getTeacher() {
        return repo.findAll();
    }

    public Teacher addTeacher(Teacher teacher) {
        if (teacher == null) {
            return null;
        }
        return repo.save(teacher);
    }

    public Teacher updateTeacher(int id, Teacher teacher) {
        if (!(repo.existsById(id))) {
            return null;
        }
        return repo.save(teacher);
    }

}
