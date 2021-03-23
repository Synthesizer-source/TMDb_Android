package com.synthesizer.tmdbapp.datasource;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

import com.synthesizer.tmdbapp.interfaces.DataSourceParam;
import com.synthesizer.tmdbapp.model.Movie;

public class MovieDataSourceFactory extends DataSource.Factory<Integer, Movie> {

    private MutableLiveData<MovieDataSource> movieDataSource;
    private DataSourceParam param;

    @NonNull
    @Override
    public DataSource<Integer, Movie> create() {
        MovieDataSource source = new MovieDataSource(param);
        movieDataSource = new MutableLiveData<>();
        movieDataSource.postValue(source);
        return source;
    }

    public void updateType(TypeDataSourceParam param){
        this.param = param;
        this.refresh();
    }

    public void searchMovies(SearchDataSourceParam param){
        this.param = param;
        this.refresh();
    }

    private void refresh(){
        if(movieDataSource.getValue() != null) movieDataSource.getValue().invalidate();
    }
}
