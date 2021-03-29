package com.synthesizer.tmdbapp.service.response;

import com.synthesizer.tmdbapp.model.Genre;
import com.synthesizer.tmdbapp.model.ProductionCompany;
import com.synthesizer.tmdbapp.model.ProductionCountry;
import com.synthesizer.tmdbapp.model.SpokenLanguage;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDetail implements Serializable {

    private boolean adult;
    private String backdrop_path;
    private Object belongs_to_collection;
    private int budget;
    private List<Genre> genres;
    private String homepage;
    private int id;
    private String imdb_id;
    private String original_language;
    private String original_title;
    private String overview;
    private double popularity;
    private Object poster_path;
    private List<ProductionCompany> production_companies;
    private List<ProductionCountry> production_countries;
    private String release_date;
    private int revenue;
    private int runtime;
    private List<SpokenLanguage> spoken_languages;
    private String status;
    private String tagline;
    private String title;
    private boolean video;
    private double vote_average;
    private int vote_count;
}
