package com.example.popularmovies.viewmodel;

public class DataFormatConverter {
    public static String createParcelableString(MovieModel movie){
        String rawData = movie.getPosterPath()+"@"+movie.getOriginalTitle()+"@"+movie.getOverview()+"@"+movie.getReleaseDate()
                +"@"+movie.getVoteAverage()+"@"+movie.getVoteCount();

        return rawData;

    }

    public static String[] extractData(String data){
        String[] splitArray = data.split("@");
        return splitArray;
    }

}
