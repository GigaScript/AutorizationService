package com.example.autorizationservice.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Data
public class User {
    @Size(min = 2,max = 10)
    private String user;
    @Size(min = 1,max = 10)
    private String password;
    private List<Authorities> authorities;

    public User() {
    }

    public User(String login, String password, List<Authorities> authorities) {
        this.user = login;
        this.password = password;
        this.authorities = authorities;
    }

    public void setUser(String login) {
        this.user = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return user.equals(user1.user) && password.equals(user1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user,password);
    }
}
