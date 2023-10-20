package com.example.demo.controller;

import com.example.demo.model.Genre;
import com.example.demo.model.IS_.MovieGenreCombination;
import com.example.demo.model.IS_.MovieGenreKey;
import com.example.demo.model.Movie;
import com.example.demo.repository.GenreRepository;
import com.example.demo.repository.MovieGenreCombinationRepository;
import com.example.demo.service.MovieProjectionService;
import com.example.demo.service.MovieService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieProjectionService movieProjectionService;
    private final MovieGenreCombinationRepository movieGenreCombinationRepository;
    private final GenreRepository genreRepository;

    public MovieController(MovieService movieService, MovieProjectionService movieProjectionService, MovieGenreCombinationRepository movieGenreCombinationRepository, GenreRepository genreRepository) {
        this.movieService = movieService;
        this.movieProjectionService = movieProjectionService;
        this.movieGenreCombinationRepository = movieGenreCombinationRepository;
        this.genreRepository = genreRepository;
    }


    @GetMapping
    public String getMoviePage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Movie> movie= this.movieService.findAll();
        model.addAttribute("movie", movieGenreCombinationRepository.findAll());
        model.addAttribute("bodyContent", "movies");
        return "master-template";
    }
    @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
    @GetMapping("/add-form")
    public String addMoviePage(Model model) {
        List<Movie> movie = this.movieService.findAll();
        List<Genre> genres = this.genreRepository.findAll();
        model.addAttribute("movie", movie);
        model.addAttribute("genre", genres);
        model.addAttribute("bodyContent", "add-movie");
        return "master-template";
    }

    @PreAuthorize("hasRole('ROLE_EMPLOYEE')")
    @PostMapping("/add")
    public String saveMovie(
            @RequestParam(required = false) Integer movie_id,
            @RequestParam String movie_name,
            @RequestParam String movie_age_category,
            @RequestParam String movie_cast,
            @RequestParam String movie_film_director,
            @RequestParam String movie_production,
            @RequestParam String movie_time_duration,
            @RequestParam Integer genre_id )
             {

            this.movieService.save(movie_id, movie_name, movie_age_category, movie_cast, movie_production,movie_film_director, movie_time_duration);
                 MovieGenreKey movieGenreKey = new MovieGenreKey();
                 movieGenreKey.setMovie(this.movieService.findById(movie_id).get());
                 movieGenreKey.setGenre(this.genreRepository.findById(genre_id).get());
                 MovieGenreCombination movieGenreCombination = new MovieGenreCombination();
                 movieGenreCombination.setMovieGenreKey(movieGenreKey);
            this.movieGenreCombinationRepository.save(movieGenreCombination);
        return "redirect:/movies";
    }

    /*
    @RequestMapping("/view/movies/id?={movie_id}")
    public String viewMovies(Model model, @RequestParam Integer movie_id){
        List<MovieProjection> moviegoer = movieProjectionService.findByMovieID(movie_id);
        model.addAttribute("moviegoer", moviegoer);
        return "view";
    }*/





}
