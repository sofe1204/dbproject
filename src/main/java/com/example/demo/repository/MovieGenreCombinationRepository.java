package com.example.demo.repository;

import com.example.demo.model.IS_.MovieGenreCombination;
import com.example.demo.model.IS_.MovieGenreKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieGenreCombinationRepository extends JpaRepository<MovieGenreCombination, MovieGenreKey> {

}