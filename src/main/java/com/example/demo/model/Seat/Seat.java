package com.example.demo.model.Seat;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="seat")
public class Seat {

    @EmbeddedId
    public SeatCompositeKey seatCompositeKey;

    Integer seat_number;

    public Seat(SeatCompositeKey seatCompositeKey, Integer seat_number) {
        this.seatCompositeKey = seatCompositeKey;
        this.seat_number = seat_number;

    }

    public Seat() {
    }

    public SeatCompositeKey getSeatCompositeKey() {
        return seatCompositeKey;
    }

    public void setSeatCompositeKey(SeatCompositeKey seatCompositeKey) {
        this.seatCompositeKey = seatCompositeKey;
    }

    public Integer getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(Integer seat_number) {
        this.seat_number = seat_number;
    }

}
