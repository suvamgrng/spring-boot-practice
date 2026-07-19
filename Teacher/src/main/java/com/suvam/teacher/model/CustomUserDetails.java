package com.suvam.teacher.model;

import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private final Users users;

    public CustomUserDetails(Users users) {
        this.users = users;
    }

    @Override
    public @NullMarked Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority(
                        "ROLE_" + users.getRole()
                )
        );
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
