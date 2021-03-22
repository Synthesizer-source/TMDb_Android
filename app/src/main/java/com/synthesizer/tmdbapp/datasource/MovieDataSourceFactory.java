package com.synthesizer.tmdbapp.datasource;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.synthesizer.tmdbapp.model.Movie;

public class MovieDataSourceFactory extends DataSource.Factory<Integer, Movie> {

    MutableLiveData<MovieDataSource> movieDataSource;

    @NonNull
    @Override
    public DataSource<Integer, Movie> create() {
        MovieDataSource source = new MovieDataSource();
        movieDataSource = new MutableLiveData<>();
        movieDataSource.postValue(source);
        return source;
    }
}
