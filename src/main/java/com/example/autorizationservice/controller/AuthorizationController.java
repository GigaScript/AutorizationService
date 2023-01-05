package com.example.autorizationservice.controller;

import com.example.autorizationservice.UserResolver;
import com.example.autorizationservice.model.Authorities;
import com.example.autorizationservice.model.User;
import com.example.autorizationservice.service.AuthorizationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@UserResolver User user) {
        return service.getAuthorities(user);
    }
}
