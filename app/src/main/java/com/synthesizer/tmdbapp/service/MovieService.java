package com.synthesizer.tmdbapp.service;

import com.synthesizer.tmdbapp.service.response.GenreList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieService {

    @GET("genre/movie/list")
    Call<GenreList> getGenres();

}
