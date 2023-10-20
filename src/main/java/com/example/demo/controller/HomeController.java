package com.example.demo.controller;

import com.example.demo.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value={"/", "/home"})
public class HomeController {

    @GetMapping
    public String getViewHome(Model model) {

        model.addAttribute("bodyContent","home");
        return "master-template";
    }

}
