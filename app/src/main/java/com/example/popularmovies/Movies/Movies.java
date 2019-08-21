package com.example.popularmovies.Movies;

import com.google.gson.annotations.SerializedName;

public class Movies {
     @SerializedName("vote_average")
     double mVote_average;
     @SerializedName( "title")
     String mTitel;
     @SerializedName("poster_path")
     String mPoster_path;
     @SerializedName("original_title")
     String mOriginal;
     @SerializedName("overview")
     String mOverview ;
     @SerializedName("release_date")
     String mRelease_date;
    public double getmVote_average() {
        return mVote_average;
    }
    public String getmTitel() {
        return mTitel;
    }
    public String getmPoster_path() {
        return "https://image.tmdb.org/t/p/w185/"+mPoster_path;
    }
    public String getmOriginal() {
        return mOriginal;
    }
    public String getmOverview() {
        return mOverview;
    }
    public String getmRelease_date() {
        return mRelease_date;
    }









}
