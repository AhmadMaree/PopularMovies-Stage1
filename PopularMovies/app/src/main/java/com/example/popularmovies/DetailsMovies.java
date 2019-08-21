package com.example.popularmovies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.graphics.drawable.DrawableWrapper;

import com.squareup.picasso.Picasso;

public class DetailsMovies extends AppCompatActivity
{
    TextView relase_date;
    TextView rate_avg;
    ImageView image_movie;
    TextView name_movie;
    TextView plotSynopsis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_movies);
            //Define
        relase_date=findViewById(R.id.relase_date);
        rate_avg=findViewById(R.id.rateing);
        image_movie=findViewById(R.id.image_movie);
        name_movie=findViewById(R.id.name_movie);
        plotSynopsis=findViewById(R.id.poltsyniosis);


        Intent intent  =getIntent();
        if (intent.hasExtra("original_title")) {

            String title= intent.getExtras().getString("original_title");
            String image = getIntent().getExtras().getString("poster_path");
            String descrpition = getIntent().getExtras().getString("overview");
            String rating = getIntent().getExtras().getString("vote_average");
            String date_relase = getIntent().getExtras().getString("release_date");

            Picasso.with(this).load(image)
                    .placeholder(R.drawable.load)
                    .into(image_movie);

            rate_avg.setText(rating);
            plotSynopsis.setText(descrpition);
            name_movie.setText(title);
            relase_date.setText(date_relase);




        }



    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}
