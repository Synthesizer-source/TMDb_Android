package com.synthesizer.tmdbapp.viewmodel.factory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.synthesizer.tmdbapp.viewmodel.MovieDetailViewModel;

public class MovieDetailViewModelFactory implements ViewModelProvider.Factory {

    private int movieID;
    public MovieDetailViewModelFactory(@NonNull int movieID){
        this.movieID = movieID;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MovieDetailViewModel(movieID);
    }
}
