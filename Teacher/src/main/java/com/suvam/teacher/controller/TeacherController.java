package com.suvam.teacher.controller;

import com.suvam.teacher.model.Teacher;
import com.suvam.teacher.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String greet() {
        return "Hello World";
    }

    @GetMapping("/teacher")
    public ResponseEntity<List<Teacher>> getTeacher() {
        return ResponseEntity.ok(service.getTeacher());
    }

    @PostMapping("/teacher")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        return ResponseEntity.ok(service.addTeacher(teacher));
    }

    public ResponseEntity<Teacher> updateTeacher(@PathVariable int id, @RequestBody Teacher teacher) {
        return ResponseEntity.ok(service.updateTeacher(id, teacher));
    }
}
