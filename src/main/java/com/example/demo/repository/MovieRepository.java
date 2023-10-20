package com.example.demo.repository;

import com.example.demo.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query(value = "select * from Movie where movie_id=?",nativeQuery = true)
    Optional<Movie> findAllByID(Integer movie_id);

    @Modifying
    @Query(value ="delete from Movie where movie_name=?;",nativeQuery = true)
    void deleteMovieByName(String movie_name);
    //@Override
    //@Query(value = "delete from Table where movie_id=?", nativeQuery = true)
    //void deleteByName(String name);

    @Query(value="select * from MovieProjection where movie_id=? ",nativeQuery = true)
    List<Movie> ViewByID(Integer movie_id);

    @Query(value ="select movie_name from Movie where movie_name=?",nativeQuery = true)
    Optional<Movie> findByName(String movie_name);


    @Query(value="select * from Movie where movie_name=?",nativeQuery = true)
    Optional<Movie> findAllByName(String s);
}