package com.suvam.springtokenpractice.service;

import com.suvam.springtokenpractice.model.Officer;
import com.suvam.springtokenpractice.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private UserRepo repo;

    public MyUserDetailsService(UserRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Officer officer = repo.findByUsername(username);

        if (officer == null) {
            throw  new UsernameNotFoundException("User not found");
        }
        return null;
    }
}
