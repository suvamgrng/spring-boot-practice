package com.suvam.springtokenpractice.controller;

import com.suvam.springtokenpractice.model.Officer;
import com.suvam.springtokenpractice.service.OfficerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OfficerController {

    private final OfficerService service;

    public OfficerController(OfficerService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String greet(HttpServletRequest request) {
        return "Hello Officer!!" +request.getSession().getId();
    }

    @GetMapping("/get-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @GetMapping("/officer")
    public List<Officer> getOfficers() {
        return service.getOfficers();
    }

    @PostMapping("/officer")
    public Officer addOfficer(@RequestBody Officer officer) {
        Officer ofc = service.addOfficer(officer);

        if (!(ofc == null)) {
            return ofc;
        }
        return null;
    }
}
