package com.example.autorizationservice.repository;

import com.example.autorizationservice.model.Authorities;
import com.example.autorizationservice.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final Map<String, User> users = new ConcurrentHashMap<>();

    public UserRepository() {
        addUser("user1",
                new User(
                        "user1"
                        , "1",
                        Arrays.asList(Authorities.DELETE, Authorities.WRITE)
                )
        );
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        User user1 = users.get(user);
        List<Authorities> authorities = new ArrayList<>();
        if (user1 != null && user1.getPassword().equals(password)) {
            authorities = user1.getAuthorities();
        }
        return authorities;
    }

    public void addUser(String login, User user) {
        users.put(login, user);
    }
}