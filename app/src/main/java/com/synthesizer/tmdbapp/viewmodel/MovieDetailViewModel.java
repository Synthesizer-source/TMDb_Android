package com.synthesizer.tmdbapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.synthesizer.tmdbapp.service.BaseAPI;
import com.synthesizer.tmdbapp.service.MovieService;
import com.synthesizer.tmdbapp.service.response.MovieDetail;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieDetailViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<MovieDetail> movieDetail;
    private MovieService movieService = BaseAPI.getAPI().create(MovieService.class);
    public MovieDetailViewModel(int movieID){
        movieDetail = new MutableLiveData<>();
        loadMovieDetail(movieID);
    }

    private void loadMovieDetail(int movieID){
        movieService.getMovieByID(movieID).enqueue(new Callback<MovieDetail>() {
            @Override
            public void onResponse(Call<MovieDetail> call, Response<MovieDetail> response) {
                if(response.isSuccessful()){
                    movieDetail.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<MovieDetail> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public LiveData<MovieDetail> getMovieDetail() {
        return movieDetail;
    }
}