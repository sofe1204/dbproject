package com.example.demo.controller;

import com.example.demo.model.Auditorium;
import com.example.demo.model.Gives.Gives;
import com.example.demo.model.Gives.GivesKey;
import com.example.demo.model.Movie;
import com.example.demo.model.MovieProjection;
import com.example.demo.repository.*;
import com.example.demo.service.MovieProjectionService;
import com.example.demo.service.MovieService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projections")
public class MovieProjectionController {
    private final MovieProjectionService movieProjectionService;
    private final MovieService movieService;
    private final MovieProjectionRepository movieProjectionRepository;
    private final MovieGenreCombinationRepository movieGenreCombinationRepository;
    private final AuditoriumRepository auditoriumRepository;
    private final GivesRepository givesRepository;
    private final SeatRepository seatRepository;
    public MovieProjectionController(MovieProjectionService movieProjectionService, MovieService movieService, MovieProjectionRepository movieProjectionRepository, MovieGenreCombinationRepository movieGenreCombinationRepository, AuditoriumRepository auditoriumRepository, GivesRepository givesRepository, SeatRepository seatRepository) {
        this.movieProjectionService = movieProjectionService;
        this.movieService = movieService;
        this.movieProjectionRepository = movieProjectionRepository;
        this.movieGenreCombinationRepository = movieGenreCombinationRepository;
        this.auditoriumRepository = auditoriumRepository;
        this.givesRepository = givesRepository;
        this.seatRepository = seatRepository;
    }

    @GetMapping
    public String getProjectionPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<MovieProjection> movieprojection = this.movieProjectionService.findAll();
        model.addAttribute("movieprojection", movieprojection);
        model.addAttribute("bodyContent", "projections");
        return "master-template";
    }
    @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
    @GetMapping("/add-form")
    public String addProjectionPage(Model model) {
        List<Movie> movie = this.movieService.findAll();
        List<Auditorium> auditorium = this.auditoriumRepository.findAll();
        model.addAttribute("movie", movie);
        model.addAttribute("auditorium", auditorium);
        model.addAttribute("bodyContent", "add-projection");
        return "master-template";
    }
    @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
    @PostMapping("/add")
    public String saveProjection(
            @RequestParam(required = false) Integer projection_id,
            @RequestParam String projection_movie_start,
            @RequestParam String projection_movie_end,
            @RequestParam String projection_screening_date,
            @RequestParam String projection_type,
            @RequestParam Float projection_price,
            @RequestParam Integer movie_id,
            @RequestParam Integer auditorium_id) {
            this.movieProjectionService.save(projection_id, projection_movie_start, projection_movie_end, projection_screening_date, projection_type, projection_price, movie_id);

            Gives gives = new Gives();
            GivesKey givesKey = new GivesKey();
            MovieProjection movieProjection = this.movieProjectionService.findById(projection_id).get();
            Auditorium auditorium = this.auditoriumRepository.findById(auditorium_id).get();
            givesKey.setMovieProjection(movieProjection);
            givesKey.setAuditorium(auditorium);
            gives.setGivesKey(givesKey);
            gives.setSeat_limitation(35);
            this.givesRepository.save(gives);
            return "redirect:/projections";
    }
}
