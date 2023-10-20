package com.example.demo.model;

import com.example.demo.model.Gives.Gives;
import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name="auditorium")
public class Auditorium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer auditorium_id;

    String auditorium_name;
    Integer auditorium_capacity;

    @ManyToOne
    @JoinColumn(name = "firm_id")
    public Firm firm;

    public Auditorium(Integer auditorium_id, String auditorium_name, Integer auditorium_capacity, Firm firm) {
        this.auditorium_id = auditorium_id;
        this.auditorium_name = auditorium_name;
        this.auditorium_capacity = auditorium_capacity;
        this.firm = firm;
    }

    public Auditorium() {

    }

    public Integer getAuditorium_id() {
        return auditorium_id;
    }

    public void setAuditorium_id(Integer auditorium_id) {
        this.auditorium_id = auditorium_id;
    }

    public String getAuditorium_name() {
        return auditorium_name;
    }

    public void setAuditorium_name(String auditorium_name) {
        this.auditorium_name = auditorium_name;
    }

    public Integer getAuditorium_capacity() {
        return auditorium_capacity;
    }

    public void setAuditorium_capacity(Integer auditorium_capacity) {
        this.auditorium_capacity = auditorium_capacity;
    }

    public Firm getFirm() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }
}
