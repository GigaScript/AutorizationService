package com.example.autorizationservice.service;

import com.example.autorizationservice.exception.InvalidCredentials;
import com.example.autorizationservice.exception.UnauthorizedUser;
import com.example.autorizationservice.model.Authorities;
import com.example.autorizationservice.model.User;
import com.example.autorizationservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {

        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user.getUser(), user.getPassword());
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getUser());
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
