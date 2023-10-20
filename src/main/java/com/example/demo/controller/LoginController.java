//package com.example.demo.controller;
//
//import com.example.demo.exceptions.InvalidUserCredentialsException;
//import com.example.demo.model.User;
//import com.example.demo.service.AuthService;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//@RequestMapping("/login")
//public class LoginController {
//
//    private final AuthService authService;
//
//    public LoginController(AuthService authService) {
//        this.authService = authService;
//    }
//
//    @GetMapping
//    public String getLoginPage(Model model) {
//        model.addAttribute("bodyContent","login");
//        return "master-template";
//    }
//
//    @PostMapping
//    public String login(HttpServletRequest request, Model model) {
//        User user = null;
//        try{
//            user = this.authService.login(request.getParameter("user_username"),
//                    request.getParameter("user_password"));
//            request.getSession().setAttribute("user", user);
//            return "redirect:/movies";
//        }
//        catch (InvalidUserCredentialsException exception) {
//            model.addAttribute("hasError", true);
//            model.addAttribute("error", exception.getMessage());
//            return "login";
//        }
//    }
//}