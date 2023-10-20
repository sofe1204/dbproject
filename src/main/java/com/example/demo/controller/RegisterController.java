package com.example.demo.controller;

import com.example.demo.exceptions.InvalidArgumentsException;
import com.example.demo.exceptions.PasswordsDoNotMatchException;
import com.example.demo.model.Role;
import com.example.demo.service.AuthService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final AuthService authService;
    private final UserService userService;

    public RegisterController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        model.addAttribute("bodyContent","register");
        return "master-template";
    }

    @PostMapping
    public String register(@RequestParam(required = false) Integer user_id,
                           @RequestParam String user_username,
                           @RequestParam String user_password,
                           @RequestParam String user_repeatedPassword,
                           @RequestParam String user_phone_number,
                           @RequestParam String user_email,
                           @RequestParam String user_name,
                           @RequestParam String user_surname,
                           @RequestParam Role user_role) {
        try{
            this.userService.register( user_id, user_username, user_password,user_repeatedPassword,
                    user_phone_number, user_name,  user_surname,  user_email,  user_role);
            return "redirect:/login";
        } catch (InvalidArgumentsException | PasswordsDoNotMatchException exception) {
            return "redirect:/register?error=" + exception.getMessage();
        }
    }
}
