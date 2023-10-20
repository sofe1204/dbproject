package com.example.demo.repository;

import com.example.demo.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

    @Query(value="select g.genre_id ,g.genre_name, count(r) as rezervacii from genre as g\n" +
            "     join is_ as i on i.genre_id = g.genre_id\n" +
            "     join movie as m on m.movie_id  = i.movie_id\n" +
            "     join movieprojection as mp on mp.movie_id = m.movie_id\n" +
            "     join reservation as r on r.projection_id = mp.projection_id\n" +
            "     and r.reservation_date between now() - interval '2 month' and now()\n" +
            "     group by g.genre_id\n" +
            "     order by rezervacii desc\n" +
            "     limit 3;",nativeQuery = true)
    List<Genre> SelectTopThree();


}