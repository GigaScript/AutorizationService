package com.example.autorizationservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class User {
    private String login;
    private String password;
    private List<Authorities> authorities;
}
