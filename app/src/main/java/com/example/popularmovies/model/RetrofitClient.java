package com.example.popularmovies.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit = null;
    private static ApiInterface apiInterface;

    public static ApiInterface getClient () {
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://api.themoviedb.org")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiInterface =retrofit.create(ApiInterface.class);
        }
        return apiInterface;
    }


}
