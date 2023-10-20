package com.example.demo.repository;

import com.example.demo.model.PaymentType;
import com.example.demo.model.Seat.Seat;
import com.example.demo.model.Seat.SeatCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, SeatCompositeKey> {

    @Query(value="select * from Seat ", nativeQuery = true)
    public Optional<Seat> findAllSeats();


    @Query(value="select * from seat as s \n" +
            "      join gives as g on g.auditorium_id = s.auditorium_id\n" +
            "      join reservation as r on r.seat_id = s.seat_id and \n" +
            "      r.auditorium_id = s.auditorium_id \n" +
            "      join movieprojection as m on m.projection_id = r.projection_id\n" +
            "      where g.projection_id=?",nativeQuery = true)
    public List<Seat> SelectionByProjection(Integer projection_id);

    @Query(value="select * from seat as s\n" +
            "     join gives as g on g.auditorium_id = s.auditorium_id\n" +
            "     join auditorium as a on a.auditorium_id = g.auditorium_id\n" +
            "     join movieprojection as m on m.projection_id = g.projection_id\n" +
            "     where m.projection_id=?",nativeQuery = true)
    public List<Seat> selectFreeSeatsByProjection(Integer projection_id);

    @Query(value="select * from seat where auditorium_id=?",nativeQuery = true)
    public Optional<Seat> selectById(Integer auditorium_id);

    @Query(value="select * from seat where seat_id=? and auditorium_id=?",nativeQuery = true)
    public Optional<Seat> findSeatAuditorium(Integer seat_id,Integer auditorium_id);

}