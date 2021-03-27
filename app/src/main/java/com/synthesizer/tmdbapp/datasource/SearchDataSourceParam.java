package com.synthesizer.tmdbapp.datasource;

import androidx.annotation.NonNull;

import com.synthesizer.tmdbapp.interfaces.DataSourceParam;
import com.synthesizer.tmdbapp.service.BaseAPI;
import com.synthesizer.tmdbapp.service.MovieService;
import com.synthesizer.tmdbapp.service.response.MovieList;

import retrofit2.Call;

public class SearchDataSourceParam implements DataSourceParam {

    private MovieService movieService = BaseAPI.getAPI().create(MovieService.class);
    private String query;

    public SearchDataSourceParam(@NonNull String query){
        this.query = query;
    }

    @Override
    public Call<MovieList> call(int page) {
        return movieService.getMoviesBySearch(this.query,page);
    }
}
