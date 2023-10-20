package com.example.demo.repository;

import com.example.demo.model.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Integer> {

    @Query(value="select * from auditorium as a\n" +
            "     join gives as g on g.auditorium_id = a.auditorium_id\n" +
            "     join movieprojection as m on m.projection_id = g.projection_id\n" +
            "     where m.projection_id=?",nativeQuery = true)
    public List<Auditorium> SelectAuditoriumsByProjection(Integer projection_id);


}