package com.synthesizer.tmdbapp.datasource;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.synthesizer.tmdbapp.interfaces.DataSourceParam;
import com.synthesizer.tmdbapp.model.Movie;
import com.synthesizer.tmdbapp.service.BaseAPI;
import com.synthesizer.tmdbapp.service.MovieService;
import com.synthesizer.tmdbapp.service.response.MovieList;

import org.jetbrains.annotations.Nullable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDataSource extends PageKeyedDataSource<Integer, Movie> {

    private DataSourceParam param;

    public MovieDataSource(@NonNull DataSourceParam param){
        this.param = param;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Movie> callback) {

        param.call(1).enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                callback.onResult(response.body().getResults(), null, 2);
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
                t.printStackTrace();
            }

        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Movie> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Movie> callback) {
        param.call(params.key).enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                callback.onResult(response.body().getResults(), params.key+1);
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
