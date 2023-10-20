
package com.example.demo.controller.Rest;

import com.example.demo.model.Movie;
import com.example.demo.model.dto.MovieDto;
import com.example.demo.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/movies")
public class MovieRestController {
    private final com.example.demo.service.MovieService MovieService;

    public MovieRestController(MovieService MovieService) {
        this.MovieService = MovieService;
    }

    @GetMapping
    private List<Movie> findAll() {
        return this.MovieService.findAll();
    }

    @GetMapping("/{movie_id}")
    public ResponseEntity<Movie> findById(@PathVariable Integer movie_id) {
        return this.MovieService.findById(movie_id)
                .map(movie -> ResponseEntity.ok().body(movie))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}