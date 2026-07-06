package com.suvam.springtokenpractice.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfficerController {

    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "Hello Officer!!" +request.getSession().getId() ;
    }

    @GetMapping("/get-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
