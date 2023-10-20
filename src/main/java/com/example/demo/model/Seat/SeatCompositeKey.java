package com.example.demo.model.Seat;

import com.example.demo.model.Auditorium;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class SeatCompositeKey implements Serializable {

    @ManyToOne
    @JoinColumn(name="auditorium_id")
    public Auditorium auditorium;

    public Integer seat_id;

    public SeatCompositeKey(Auditorium auditorium_id,Integer seat_id) {
        this.auditorium = auditorium_id;
        this.seat_id=seat_id;
    }

    public SeatCompositeKey() {

    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium_id) {
        this.auditorium = auditorium_id;
    }

    public Integer getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(Integer seat_id) {
        this.seat_id = seat_id;
    }
}
