package com.synthesizer.tmdbapp.interfaces;

import com.synthesizer.tmdbapp.service.response.MovieList;

import retrofit2.Call;

public interface DataSourceParam {

    public Call<MovieList> call(int page);
}
