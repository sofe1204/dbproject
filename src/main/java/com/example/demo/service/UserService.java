package com.example.demo.service;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User register(Integer user_id, String user_username,String user_password,String user_repeatedPassword,String user_phone_number, String user_email,String user_name,String user_surname, Role user_role);


}
