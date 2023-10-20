package com.example.demo.repository;

import com.example.demo.model.Gives.Gives;
import com.example.demo.model.Gives.GivesKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GivesRepository extends JpaRepository<Gives, GivesKey> {

    @Query(value = "SELECT * FROM Gives WHERE projection_id=?",nativeQuery = true)
    Optional<Gives> findAllByProjectionId(Integer projection_id);
}