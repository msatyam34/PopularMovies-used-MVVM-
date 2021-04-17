package com.example.popularmovies.viewmodel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponseModel {

    @SerializedName("page")
    private Integer page;

    @SerializedName("results")
    private List<MovieModel> movieList = null;

    @SerializedName("total_pages")
    private Integer totalPages;

    @SerializedName("total_results")
    private Integer totalResults;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<MovieModel> getMovieList() {
        return movieList;
    }

    public void setResults(List<MovieModel> movieList) {
        this.movieList = movieList;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }
}
