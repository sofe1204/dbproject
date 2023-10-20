package com.example.demo.service.ServiceImpl;


import com.example.demo.exceptions.InvalidArgumentsException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> login(String username, String password) {
        if(username==null || username.isEmpty() || password==null || password.isEmpty())
        {

            throw new InvalidArgumentsException();
        }
        return  userRepository.findByUsernameAndPassword(username,password);
    }

}
