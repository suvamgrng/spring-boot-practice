package com.suvam.teacher.service;

import com.suvam.teacher.model.Users;
import com.suvam.teacher.repository.UsersRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepo repo;
    private final PasswordEncoder passwordEncoder;

    public UsersService(UsersRepo repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
        return "User Registered";
    }
}
