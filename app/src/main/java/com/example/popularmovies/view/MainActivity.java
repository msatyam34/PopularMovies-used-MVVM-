package com.example.popularmovies.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.popularmovies.R;
import com.example.popularmovies.adapter.RecyclerViewAdapter;
import com.example.popularmovies.viewmodel.DataFormatConverter;
import com.example.popularmovies.viewmodel.MovieListViewModel;
import com.example.popularmovies.viewmodel.MovieModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {

    //movieModelList contains all the data which will be used for views
    private List<MovieModel> movieModelList;
    private MovieListViewModel viewModel;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing recyclerView
        initRecyclerView();



        viewModel = new ViewModelProvider(MainActivity.this).get(MovieListViewModel.class);
        viewModel.getMoviesListObserver().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                if(movieModels != null){
                    movieModelList = movieModels;
                    recyclerViewAdapter.setMovieList(movieModels);
                } else {
                    Toast.makeText(MainActivity.this,"Connect to a Network",Toast.LENGTH_SHORT).show();
                }
            }
        });
        viewModel.getData();



    }


    private void initRecyclerView(){
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,movieModelList,this);
        recyclerView.setAdapter(recyclerViewAdapter);

    }


    //onMovieClick is used to change the activity
    @Override
    public void onMovieClick(MovieModel movie) {
        String data = DataFormatConverter.createParcelableString(movie);
        Intent intent = new Intent(getApplicationContext(),MovieDetailActivity.class);
        intent.putExtra("Data",data);
        startActivity(intent);


    }
}