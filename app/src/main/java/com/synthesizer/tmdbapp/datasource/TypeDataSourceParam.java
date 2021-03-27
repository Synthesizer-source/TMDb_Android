package com.synthesizer.tmdbapp.datasource;

import androidx.annotation.NonNull;

import com.synthesizer.tmdbapp.interfaces.DataSourceParam;
import com.synthesizer.tmdbapp.service.BaseAPI;
import com.synthesizer.tmdbapp.service.MovieService;
import com.synthesizer.tmdbapp.service.response.MovieList;

import retrofit2.Call;

public class TypeDataSourceParam implements DataSourceParam {

    private MovieService movieService = BaseAPI.getAPI().create(MovieService.class);
    private String type;

    public TypeDataSourceParam(@NonNull String type){
        this.type = type;
    }

    @Override
    public Call<MovieList> call(int page) {
        return movieService.getMoviesByType(this.type,page);
    }




}
