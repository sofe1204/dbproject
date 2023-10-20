package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="firm")
public class Firm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer firm_id;

    String firm_city;
    String firm_adress;
    String firm_name;

    public Firm(Integer firm_id, String firm_city, String firm_adress, String firm_name) {
        this.firm_id = firm_id;
        this.firm_city = firm_city;
        this.firm_adress = firm_adress;
        this.firm_name = firm_name;
    }

    public Firm() {
    }

    public Integer getFirm_id() {
        return firm_id;
    }

    public void setFirm_id(Integer firm_id) {
        this.firm_id = firm_id;
    }

    public String getFirm_city() {
        return firm_city;
    }

    public void setFirm_city(String firm_city) {
        this.firm_city = firm_city;
    }

    public String getFirm_adress() {
        return firm_adress;
    }

    public void setFirm_adress(String firm_adress) {
        this.firm_adress = firm_adress;
    }

    public String getFirm_name() {
        return firm_name;
    }

    public void setFirm_name(String firm_name) {
        this.firm_name = firm_name;
    }
}
