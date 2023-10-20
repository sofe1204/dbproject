package com.example.demo.repository;

import com.example.demo.model.Works_in.WorksInKey;
import com.example.demo.model.Works_in.Works_in;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Works_inRepository extends JpaRepository<Works_in, WorksInKey> {
}