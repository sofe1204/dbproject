package com.example.demo.model.Gives;

import com.example.demo.model.Auditorium;
import com.example.demo.model.MovieProjection;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class GivesKey implements Serializable {


    @ManyToOne
    @JoinColumn(name="projection_id")
    public MovieProjection movieProjection;

    @ManyToOne
    @JoinColumn(name="auditorium_id")
    public Auditorium auditorium;

    public MovieProjection getMovieProjection() {
        return movieProjection;
    }

    public void setMovieProjection(MovieProjection movieProjection) {
        this.movieProjection = movieProjection;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }


}
