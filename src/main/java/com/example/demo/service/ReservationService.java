package com.example.demo.service;

import com.example.demo.model.Reservation.Reservations;

import java.util.Optional;

public interface ReservationService {
    Optional<Reservations> save(Integer reservation_id, String reservation_end_date, Integer payment_type_id, Integer user_id, Integer seat_id, Integer auditorium_id, Integer projection_id);
    Optional<Reservations> findAll();
}
