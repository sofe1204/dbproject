package com.example.demo.repository;

import com.example.demo.model.Movie;
import com.example.demo.model.MovieProjection;
import com.example.demo.model.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface MovieProjectionRepository extends JpaRepository<MovieProjection, Integer> {
    //Optional<MovieProjection> findbyName(String name);

    @Query(value = "select * from MovieProjection as mp join Movie as m on m.movie_id=mp.movie_id",nativeQuery = true)
    List<MovieProjection> findJoined();

    @Query(value = "select * from MovieProjection where movie_id=?", nativeQuery = true)
    List<MovieProjection> findByMovieID(Integer movie_id);

    @Query(value="select m.movie_name,g.genre_name,mp.projection_screening_date,m.movie_cast\n" +
            "from movieprojection as mp\n" +
            "join movie as m on m.movie_id = mp.movie_id\n" +
            "join is_ as i on i.movie_id = m.movie_id\n" +
            "join genre as g on g.genre_id = i.genre_id\n",nativeQuery = true)
            public Set<MovieProjection> findSelected();

    @Query(value="select * from movieprojection where projection_id=?", nativeQuery = true)
    public List<MovieProjection> findAllProjections(Integer projection_id);

    @Query(value="select * from movieprojection where projection_id=?", nativeQuery = true)
    public List<MovieProjection> findProjectionsById(Integer projection_id);

}