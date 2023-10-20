package com.example.demo.model.Reservation;


import com.example.demo.model.Client.Client;
import com.example.demo.model.MovieProjection;
import com.example.demo.model.PaymentType;
import com.example.demo.model.Seat.Seat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="reservation")
public class Reservations {

    @Id
    public Integer reservation_id;

    public LocalDateTime reservation_date;


    @ManyToOne
    @JoinColumn(name="payment_type_id")
    public PaymentType paymentType;

    @ManyToOne
    @JoinColumn(name="seat_id", referencedColumnName = "seat_id")
    @JoinColumn(name="auditorium_id", referencedColumnName = "auditorium_id")
    public Seat seat;

    @ManyToOne
    @JoinColumn(name="user_id")
    public Client client;

    @ManyToOne
    @JoinColumn(name="projection_id")
    public MovieProjection movieProjection;



    /*
    @Embedded
    public ReservationCombo reservationCombo;


     */

    public Reservations(Integer reservation_id, LocalDateTime reservation_date, PaymentType paymentType, Seat seat, Client client, MovieProjection movieProjection) {
        this.reservation_id = reservation_id;
        this.reservation_date = reservation_date;
        this.paymentType = paymentType;
        this.seat = seat;
        this.client = client;
        this.movieProjection = movieProjection;
    }

    public Reservations() {
    }

    public Integer getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Integer reservation_id) {
        this.reservation_id = reservation_id;
    }

    public LocalDateTime getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(LocalDateTime reservation_date) {
        this.reservation_date = reservation_date;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public MovieProjection getMovieProjection() {
        return movieProjection;
    }

    public void setMovieProjection(MovieProjection movieProjection) {
        this.movieProjection = movieProjection;
    }
}

