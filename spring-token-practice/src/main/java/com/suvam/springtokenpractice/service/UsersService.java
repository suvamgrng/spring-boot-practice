package com.suvam.springtokenpractice.service;

import com.suvam.springtokenpractice.model.Users;
import com.suvam.springtokenpractice.repo.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UserRepo repo;
    private final PasswordEncoder encoder;
    public UsersService(UserRepo repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public String register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return "Registered Successfully";
    }
}
