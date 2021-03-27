package com.synthesizer.tmdbapp.view;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.synthesizer.tmdbapp.viewmodel.MovieDetailViewModel;
import com.synthesizer.tmdbapp.R;

public class MovieDetailFragment extends Fragment {

    private MovieDetailViewModel mViewModel;

    public static MovieDetailFragment newInstance() {
        return new MovieDetailFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MovieDetailViewModel.class);
        // TODO: Use the ViewModel
    }

}