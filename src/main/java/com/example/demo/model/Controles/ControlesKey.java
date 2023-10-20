package com.example.demo.model.Controles;

import com.example.demo.model.Employee.Employee;
import com.example.demo.model.MovieProjection;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ControlesKey implements Serializable {

    @ManyToOne
    @JoinColumn(name="user_id")
    public Employee employee;

    @ManyToOne
    @JoinColumn(name="projection_id")
    public MovieProjection movieProjection;

    public ControlesKey(Employee employee, MovieProjection movieProjection) {
        this.employee = employee;
        this.movieProjection = movieProjection;
    }

    public ControlesKey() {

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public MovieProjection getMovieProjection() {
        return movieProjection;
    }

    public void setMovieProjection(MovieProjection movieProjection) {
        this.movieProjection = movieProjection;
    }
}
