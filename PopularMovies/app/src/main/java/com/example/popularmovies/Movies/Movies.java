package com.example.popularmovies.Movies;

import com.google.gson.annotations.SerializedName;

public class Movies {

   @SerializedName("id")
    String mId;
    @SerializedName("vote_count")
    int mVote_count;
   @SerializedName("vote_average")
   double mVote_average;
   @SerializedName( "title")
   String mTitel;
   @SerializedName("popularity")
   double mPopularity;
   @SerializedName("poster_path")
   String mPoster_path;
   @SerializedName("original_title")
   String mOriginal;
    @SerializedName("backdrop_path")
    String mBackdrop;
    @SerializedName("overview")
    String mOverview ;
    @SerializedName("release_date")
    String mRelease_date;





    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public int getmVote_count() {
        return mVote_count;
    }

    public void setmVote_count(int mVote_count) {
        this.mVote_count = mVote_count;
    }

    public double getmVote_average() {
        return mVote_average;
    }

    public void setmVote_average(double mVote_average) {
        this.mVote_average = mVote_average;
    }

    public String getmTitel() {
        return mTitel;
    }

    public void setmTitel(String mTitel) {
        this.mTitel = mTitel;
    }

    public double getmPopularity() {
        return mPopularity;
    }

    public void setmPopularity(double mPopularity) {
        this.mPopularity = mPopularity;
    }

    public String getmPoster_path() {
        return "https://image.tmdb.org/t/p/w185/"+mPoster_path;
    }

    public void setmPoster_path(String mPoster_path) {
        this.mPoster_path = mPoster_path;
    }

    public String getmOriginal() {
        return mOriginal;
    }

    public void setmOriginal(String mOriginal) {
        this.mOriginal = mOriginal;
    }

    public String getmBackdrop() {
        return mBackdrop;
    }

    public void setmBackdrop(String mBackdrop) {
        this.mBackdrop = mBackdrop;
    }

    public String getmOverview() {
        return mOverview;
    }

    public void setmOverview(String mOverview) {
        this.mOverview = mOverview;
    }

    public String getmRelease_date() {
        return mRelease_date;
    }

    public void setmRelease_date(String mRelease_date) {
        this.mRelease_date = mRelease_date;
    }











}
