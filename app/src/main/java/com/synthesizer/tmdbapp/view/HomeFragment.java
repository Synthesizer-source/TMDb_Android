package com.synthesizer.tmdbapp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.synthesizer.tmdbapp.R;
import com.synthesizer.tmdbapp.adapter.TempAdapter;
import com.synthesizer.tmdbapp.service.response.GenreList;
import com.synthesizer.tmdbapp.service.BaseAPI;
import com.synthesizer.tmdbapp.service.MovieService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;
    private RecyclerView recyclerView;
    private TempAdapter tempAdapter;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = root.findViewById(R.id.recyclerViewHome);

        getData();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        // TODO: Use the ViewModel

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        tempAdapter = new TempAdapter();
        recyclerView.setAdapter(tempAdapter);
    }

    synchronized private void getData(){
        MovieService movieService = BaseAPI.getAPI().create(MovieService.class);
        movieService.getGenres().enqueue(new Callback<GenreList>() {
            @Override
            public void onResponse(Call<GenreList> call, Response<GenreList> response) {
                if(response.isSuccessful())
                    System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<GenreList> call, Throwable t) {
                System.out.println(t.getMessage());
            }

        });
    }

}