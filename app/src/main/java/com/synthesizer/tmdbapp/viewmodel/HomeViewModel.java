package com.synthesizer.tmdbapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.synthesizer.tmdbapp.datasource.MovieDataSourceFactory;
import com.synthesizer.tmdbapp.model.Movie;

import java.util.concurrent.Executors;

public class HomeViewModel extends ViewModel {

    private LiveData<PagedList<Movie>> moviesPagedList;
    private final MovieDataSourceFactory factory;

    public HomeViewModel(){
        factory = new MovieDataSourceFactory();
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true) // ?
                .setInitialLoadSizeHint(10) // ?
                .setPageSize(20)
                .setPrefetchDistance(4)
                .build();

        moviesPagedList = new LivePagedListBuilder<Integer, Movie>(factory, config)
                .setFetchExecutor(Executors.newFixedThreadPool(5))
                .build();


    }

    public LiveData<PagedList<Movie>> getMoviesPagedList() {
        return moviesPagedList;
    }
}