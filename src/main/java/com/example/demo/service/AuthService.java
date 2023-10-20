package com.example.demo.service;

import com.example.demo.model.User;

import java.util.Optional;

public interface AuthService {
    public Optional<User> login(String username, String password);
}
