package com.example.demo.repository;

import com.example.demo.model.Firm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FirmRepository extends JpaRepository<Firm, Integer> {

}