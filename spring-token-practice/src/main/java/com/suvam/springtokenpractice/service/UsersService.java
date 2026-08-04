package com.suvam.springtokenpractice.service;

import com.suvam.springtokenpractice.model.Users;
import com.suvam.springtokenpractice.repo.UserRepo;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UserRepo repo;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtService service;

    public UsersService(UserRepo repo, PasswordEncoder encoder, AuthenticationManager authManager, JwtService service) {
        this.repo = repo;
        this.encoder = encoder;
        this.authManager = authManager;
        this.service = service;
    }

    public String register(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return "Registered Successfully";
    }

    public String verify(Users user) {
        Authentication authentication = authManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()
                ));

        if (authentication.isAuthenticated()) return service.generateToken(user.getUsername());
        return "Login Failed";
    }
}
