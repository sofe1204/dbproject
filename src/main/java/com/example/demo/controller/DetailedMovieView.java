package com.example.demo.controller;

import com.example.demo.model.MovieProjection;
import com.example.demo.repository.MovieProjectionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/movie/projections")
public class DetailedMovieView {

    private final MovieProjectionRepository movieProjectionRepository;

    public DetailedMovieView(MovieProjectionRepository movieProjectionRepository) {
        this.movieProjectionRepository = movieProjectionRepository;
    }

    @RequestMapping("/detailed-preview/")
    public String viewMovieDetail(@RequestParam(value = "movie_id", required = false) Integer movie_id, Model model) {
        List<MovieProjection> moviegoer = movieProjectionRepository.findByMovieID(movie_id);
        model.addAttribute("moviegoer", moviegoer);
        return "view";
    }
}
