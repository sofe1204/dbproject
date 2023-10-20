package com.example.demo.model.Client;

import com.example.demo.model.User;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ClientCompositeKey implements Serializable {

    @ManyToOne
    @JoinColumn(name="user_id")
    public User user;

    public ClientCompositeKey(User user) {
        this.user = user;
    }

    public ClientCompositeKey() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
