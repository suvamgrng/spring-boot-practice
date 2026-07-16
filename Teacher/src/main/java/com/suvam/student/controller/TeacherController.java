package com.suvam.student.controller;

import com.suvam.student.model.Teacher;
import com.suvam.student.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/student")
    public ResponseEntity<List<Teacher>> getStudent() {
        return ResponseEntity.ok(service.getStudent());
    }
}
