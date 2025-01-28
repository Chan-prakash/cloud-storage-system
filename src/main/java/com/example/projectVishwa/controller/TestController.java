package com.example.projectVishwa.controller;

import com.example.projectVishwa.model.User;
import com.example.projectVishwa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test-users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
