package com.example.demo.model.IS_;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name="is_")
public class MovieGenreCombination {

    @EmbeddedId
    MovieGenreKey movieGenreKey;

    public MovieGenreCombination(MovieGenreKey movieGenreKey) {
        this.movieGenreKey = movieGenreKey;
    }

    public MovieGenreCombination() {

    }

    public MovieGenreKey getMovieGenreKey() {
        return movieGenreKey;
    }

    public void setMovieGenreKey(MovieGenreKey movieGenreKey) {
        this.movieGenreKey = movieGenreKey;
    }
}
