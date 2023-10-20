package com.example.demo.controller;

import com.example.demo.model.Auditorium;
import com.example.demo.model.Movie;
import com.example.demo.repository.AuditoriumRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/auditoriums")
public class AuditoriumController {

    private final AuditoriumRepository auditoriumRepository;


    public AuditoriumController(AuditoriumRepository auditoriumRepository) {
        this.auditoriumRepository = auditoriumRepository;
    }

    @GetMapping
    public String getProductPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Auditorium> auditoriums = this.auditoriumRepository.findAll();
        model.addAttribute("auditorium", auditoriums);
        model.addAttribute("bodyContent", "auditoriums");
        return "master-template";
    }
}
