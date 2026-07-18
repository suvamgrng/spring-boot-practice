package com.suvam.teacher.controller;

import com.suvam.teacher.model.Teacher;
import com.suvam.teacher.service.TeacherService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @GetMapping("/get-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
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
        if (teacher == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.addTeacher(teacher));
    }

    @PutMapping("/teacher/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable int id, @RequestBody Teacher teacher) {
        Teacher update = service.updateTeacher(id, teacher);

        if (teacher == null) {
            return ResponseEntity.badRequest().build();
        }
        if (update == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(update);
    }
}
