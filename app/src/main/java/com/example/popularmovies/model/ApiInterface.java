package com.example.popularmovies.model;

import com.example.popularmovies.viewmodel.ApiResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/3/movie/popular?api_key=da069e3970819cec25856ebe20aae42c")
    Call<ApiResponseModel> getApiResponse();
}
