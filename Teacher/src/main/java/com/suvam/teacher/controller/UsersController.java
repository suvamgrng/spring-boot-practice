package com.suvam.teacher.controller;

import com.suvam.teacher.model.Users;
import com.suvam.teacher.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    private final UsersService service;

    public UsersController(UsersService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users user) {
        if (user == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(service.register(user));
    }

    @PostMapping("/api/login")
    public ResponseEntity<String> verify(@RequestBody Users user) {
        String result = service.verify(user);
        if (result.equals("Login Failed")) {
            return ResponseEntity.status(401).body(result);
        }
        return ResponseEntity.ok(result);
    }
}
