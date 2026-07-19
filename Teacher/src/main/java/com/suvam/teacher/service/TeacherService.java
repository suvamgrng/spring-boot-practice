package com.suvam.teacher.service;

import com.suvam.teacher.model.Teacher;
import com.suvam.teacher.repository.UsersRepo;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    private final UsersRepo repo;

    public TeacherService(UsersRepo repo) {
        this.repo = repo;
    }

    public List<Teacher> getTeacher() {
        return repo.findAll(Sort.by("id"));
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
        teacher.setId(id);
        return repo.save(teacher);
    }

    public boolean deleteTeacher(int id) {
        if (!(repo.existsById(id))) {
           return false;
        }
        repo.deleteById(id);
        return true;
    }
}
