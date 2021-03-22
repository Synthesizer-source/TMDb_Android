package com.synthesizer.tmdbapp.service.response;

import com.synthesizer.tmdbapp.model.Movie;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieList implements Serializable {
    private int page;
    private List<Movie> results;
    private int total_pages;
    private int total_results;
}
