package com.example.demo.model.Employee;

import com.example.demo.model.User;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class EmployeeKey implements Serializable {

    @ManyToOne
    @JoinColumn(name="user_id")
    public User user;

    public EmployeeKey(User user) {
        this.user = user;
    }

    public EmployeeKey() {

    }

    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }
}
