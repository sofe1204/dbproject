package com.example.demo.model.Gives;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name="gives")
public class Gives {

    @EmbeddedId
    private GivesKey givesKey;

    Integer seat_limitation;

    public Gives() {

    }

    public GivesKey getGivesKey() {
        return givesKey;
    }

    public Gives(GivesKey givesKey, Integer seat_limitation) {
        this.givesKey = givesKey;
        this.seat_limitation = seat_limitation;
    }


    public void setGivesKey(GivesKey givesKey) {
        this.givesKey = givesKey;
    }

    public Integer getSeat_limitation() {
        return seat_limitation;
    }

    public void setSeat_limitation(Integer seat_limitation) {
        this.seat_limitation = seat_limitation;
    }
}
