package com.example.popularmovies.viewmodel;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.popularmovies.model.ApiInterface;
import com.example.popularmovies.model.RetrofitClient;
import com.example.popularmovies.view.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListViewModel extends ViewModel {

    private MutableLiveData<List<MovieModel>> moviesList;

    public MovieListViewModel() {
        moviesList = new MutableLiveData<>();
    }

    public MutableLiveData<List<MovieModel>> getMoviesListObserver() {
        return moviesList;
    }

    public void getData(){
        ApiInterface apiInterface = RetrofitClient.getClient();
        Call<ApiResponseModel> call = apiInterface.getApiResponse();
        call.enqueue(new Callback<ApiResponseModel>() {
            @Override
            public void onResponse(Call<ApiResponseModel> call, Response<ApiResponseModel> response) {
                ApiResponseModel apiResponse = response.body();
                moviesList.postValue(apiResponse.getMovieList());

            }

            @Override
            public void onFailure(Call<ApiResponseModel> call, Throwable t) {
                moviesList.postValue(null);

            }
        });

    }
}
