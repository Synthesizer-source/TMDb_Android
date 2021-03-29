package com.synthesizer.tmdbapp.service;

import com.synthesizer.tmdbapp.service.response.GenreList;
import com.synthesizer.tmdbapp.service.response.MovieDetail;
import com.synthesizer.tmdbapp.service.response.MovieList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {

    @GET("genre/movie/list")
    Call<GenreList> getGenres();

    @GET("movie/{type}")
    Call<MovieList> getMoviesByType(@Path ("type") String type, @Query("page") Integer page);

    @GET("search/movie")
    Call<MovieList> getMoviesBySearch(@Query("query") String query, @Query("page") Integer page);

    @GET("movie/{movie_id}")
    Call<MovieDetail> getMovieByID(@Path("movie_id") int movieID);
}
