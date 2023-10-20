package com.example.demo.repository;

import com.example.demo.model.Controles.Controles;
import com.example.demo.model.Controles.ControlesKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ControlesRepository extends JpaRepository<Controles, ControlesKey> {
}