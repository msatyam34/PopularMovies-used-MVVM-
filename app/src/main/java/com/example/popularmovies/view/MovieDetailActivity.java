package com.example.popularmovies.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.popularmovies.R;
import com.example.popularmovies.viewmodel.DataFormatConverter;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView movieImageView;
    private TextView movieTitleTextView;
    private TextView descriptionTextView;
    private TextView releaseDateTextView;
    private TextView ratingTextView;
    private TextView reviewsTextView;

    private String[] splitArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        //initializing views
        initViews();

        // getting rawData from mainActivity using intent.
        Intent intent = getIntent();
        String data = intent.getStringExtra("Data");

        //extracting data which is to be used for views
        splitArray = DataFormatConverter.extractData(data);


        setViews();



    }

    public void initViews(){
        movieImageView =findViewById(R.id.movieImageView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        movieTitleTextView = findViewById(R.id.movieTitleTextView);
        releaseDateTextView = findViewById(R.id.releaseDateTextView);
        ratingTextView = findViewById(R.id.ratingTextView);
        reviewsTextView = findViewById(R.id.reviewsTextView);

    }

    public void setViews(){
        String baseURL = "https://image.tmdb.org/t/p/w500";

        Glide.with(MovieDetailActivity.this)
                .load(baseURL+splitArray[0])
                .into(movieImageView);

        movieTitleTextView.setText(splitArray[1]);
        descriptionTextView.setText(splitArray[2]);
        releaseDateTextView.setText(splitArray[3]);
        ratingTextView.setText(splitArray[4]);
        reviewsTextView.setText(splitArray[5]);


    }

}