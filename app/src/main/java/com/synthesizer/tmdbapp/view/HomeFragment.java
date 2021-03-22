package com.synthesizer.tmdbapp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.synthesizer.tmdbapp.R;
import com.synthesizer.tmdbapp.adapter.MovieListAdapter;
import com.synthesizer.tmdbapp.model.Movie;
import com.synthesizer.tmdbapp.service.response.GenreList;
import com.synthesizer.tmdbapp.service.BaseAPI;
import com.synthesizer.tmdbapp.service.MovieService;
import com.synthesizer.tmdbapp.viewmodel.HomeViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private RecyclerView recyclerView;
    private MovieListAdapter movieListAdapter;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.recyclerViewHome);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        // TODO: Use the ViewModel

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        movieListAdapter = new MovieListAdapter();
        recyclerView.setAdapter(movieListAdapter);
        observe();
    }

    public void observe(){
        mViewModel.getMoviesPagedList().observe(getViewLifecycleOwner(), new Observer<PagedList<Movie>>() {
            @Override
            public void onChanged(PagedList<Movie> movies) {
                movieListAdapter.submitList(movies);
            }
        });
    }

}