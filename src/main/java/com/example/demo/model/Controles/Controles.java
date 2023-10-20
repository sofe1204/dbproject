package com.example.demo.model.Controles;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name="controles")
public class Controles {

    @EmbeddedId
    private ControlesKey controlesKey;

    public Controles(ControlesKey controlesKey) {
        this.controlesKey = controlesKey;
    }

    public Controles() {

    }

    public ControlesKey getControlesKey() {
        return controlesKey;
    }

    public void setControlesKey(ControlesKey controlesKey) {
        this.controlesKey = controlesKey;
    }
}
