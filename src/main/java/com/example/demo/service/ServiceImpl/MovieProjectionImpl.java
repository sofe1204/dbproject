package com.example.demo.service.ServiceImpl;

import com.example.demo.model.Movie;
import com.example.demo.model.MovieProjection;
import com.example.demo.repository.MovieProjectionRepository;
import com.example.demo.repository.MovieRepository;
import com.example.demo.service.MovieProjectionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovieProjectionImpl implements MovieProjectionService {

    private final MovieProjectionRepository projectionRepository;
    private final MovieRepository movieRepository;


    public MovieProjectionImpl(MovieProjectionRepository projectionRepository, MovieRepository movieRepository) {
        this.projectionRepository = projectionRepository;
        this.movieRepository = movieRepository;
    }


    @Override
    public List<MovieProjection> findAll() {
        return this.projectionRepository.findAll();
    }

    @Override
    public Optional<MovieProjection> findById(Integer projection_id) {
        return this.projectionRepository.findById(projection_id);
    }

    public List<MovieProjection> findAllProjections(Integer projection_id){
        return this.projectionRepository.findAllProjections(projection_id);
    }

    @Override
    @Transactional
    public Optional<MovieProjection> save(
            Integer projection_id,
            String projection_movie_start,
            String projection_movie_end,
            String projection_screening_date,
            String projection_type,
            Float projection_price,Integer movie_id) {
            Movie movie = this.movieRepository.findById(movie_id).get();
            return Optional.of(this.projectionRepository.save(new MovieProjection(projection_id,projection_movie_start,projection_movie_end,
                projection_screening_date,projection_type,projection_price,movie)));
    }

    @Override
    public void deleteById(Integer projection_id) {
        this.projectionRepository.deleteById(projection_id);
    }


    @Override
    public List<MovieProjection> findByMovieID(Integer movie_id){
        return this.projectionRepository.findByMovieID(movie_id);
    }


}
