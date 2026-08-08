package com.suvam.teacher.model;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class CustomUserDetails implements UserDetails {

    private final Users users;

    public CustomUserDetails(Users users) {
        this.users = users;
    }

    @Override
    public @NullMarked Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (users.getRole() != null && !users.getRole().isBlank()) {

            Stream.of(users.getRole().split(","))
                    .map(String::trim)
                    .map(SimpleGrantedAuthority::new)
                    .forEach(authorities::add);
        }

        if (users.getAuthority() != null && !users.getAuthority().isBlank()) {
            Stream.of(users.getAuthority().split(","))
                    .map(String::trim)
                    .map(SimpleGrantedAuthority::new)
                    .forEach(authorities::add);
        }

        return authorities;
    }

    @Override
    public @Nullable String getPassword() {
        return users.getPassword();
    }

    @Override
    public @NullMarked String getUsername() {
        return users.getUsername();
    }
}
