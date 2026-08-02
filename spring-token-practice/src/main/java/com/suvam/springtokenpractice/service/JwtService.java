package com.suvam.springtokenpractice.service;

import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public String generateToken() {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IlN1dmFtIEd1cnVuZyIsImFkbWluIjp0cnVlLCJpYXQiOjE1MTYyMzkwMjJ9.SKJv4Mmuj2zZhXApi7uScWsvANh6l6QgaucUt2H9GkM";
    }
}
