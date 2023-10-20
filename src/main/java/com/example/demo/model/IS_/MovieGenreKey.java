package com.example.demo.model.IS_;

import com.example.demo.model.Genre;
import com.example.demo.model.Movie;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class MovieGenreKey implements Serializable {



    @ManyToOne
    @JoinColumn(name="genre_id")
    public Genre genre;

    @ManyToOne
    @JoinColumn(name="movie_id")
    public Movie movie;

    public MovieGenreKey( Genre genre,Movie movie) {

        this.genre = genre;
        this.movie = movie;
    }

    public MovieGenreKey() {

    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
