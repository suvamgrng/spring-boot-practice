package com.suvam.crudpractice.controller;

import com.suvam.crudpractice.model.Student;
import com.suvam.crudpractice.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(service.getStudents());
    }


    @PostMapping("/students")
    public ResponseEntity<List<Student>> addStudent(@RequestBody List<Student> student) {
        if (student == null) {
            return ResponseEntity.badRequest().build();
        }
        service.addStudent(student);
        return ResponseEntity.status(201).body(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable long id,
                                                 @RequestBody Student student) {
        Student updated = service.updateStudent(id, student);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable long id) {
        Student deletedStudent = service.deleteStudent(id);

        if (deletedStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(deletedStudent);
    }
}
