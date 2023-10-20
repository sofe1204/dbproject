package com.example.demo.model.Reservation;

import com.example.demo.model.Client.Client;
import com.example.demo.model.MovieProjection;
import com.example.demo.model.PaymentType;
import com.example.demo.model.Seat.Seat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class ReservationCombo implements Serializable {

    @ManyToOne
    public PaymentType paymentType;

    @ManyToOne
    public Client client;

    @ManyToOne
    public Seat seat;

    @ManyToOne
    public MovieProjection movieProjection;

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public MovieProjection getMovieProjection() {
        return movieProjection;
    }

    public void setMovieProjection(MovieProjection movieProjection) {
        this.movieProjection = movieProjection;
    }
}
