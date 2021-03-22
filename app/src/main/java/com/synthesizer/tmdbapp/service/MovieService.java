package com.synthesizer.tmdbapp.service;

import com.synthesizer.tmdbapp.service.response.GenreList;
import com.synthesizer.tmdbapp.service.response.MovieList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {

    @GET("genre/movie/list")
    Call<GenreList> getGenres();

    @GET("movie/top_rated")
    Call<MovieList> getTopRatedMovies(@Query("page") Integer page);

}
