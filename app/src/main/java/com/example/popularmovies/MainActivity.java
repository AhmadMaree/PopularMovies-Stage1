package com.example.popularmovies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.popularmovies.Movies.Movies;
import com.example.popularmovies.Movies.MoviesRespons;
import com.example.popularmovies.Movies.MoviesServesis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    MyAdapter adapter;
    GridLayoutManager gridLayoutManager;
    ProgressBar progressBar;
    List<Movies> movies;
    private static final String MyKey = "f20b6998a176ffe5dd20c219fccb0ea7";
    public Call <MoviesRespons>call;
    public  int popular ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rec_view);
        progressBar = findViewById(R.id.indeterminateBar);
        gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new MyAdapter(this, movies);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        ForShowProgress();
        movies = new ArrayList<>();
        fetchData(1);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.popular_movie_menu) {
            popular = 1;
           ForShowProgress();
            fetchData(popular);
        }  if (id == R.id.toprate_movies_menu) {
            popular = 0;
            ForShowProgress();
            fetchData(popular);
        }


        return super.onOptionsItemSelected(item);
    }
    public  void ForShowProgress(){
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }



    private void fetchData(int DatatopOrpopular) {
        //Genrate the services

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        MoviesServesis service = retrofit.create(MoviesServesis.class);
        switch (DatatopOrpopular) {
            case 0:
                //Run the requst
                call = service.getTop(MyKey);
               // Toast.makeText(MainActivity.this,"TOOOOOOOOOOOOOP",Toast.LENGTH_SHORT).show();
                break;

            case 1:
                call = service.getpopular(MyKey);
                    break;
        }

        // Do something after 5s = 5000ms
      call.enqueue(new Callback<MoviesRespons>() {
            @Override
            public void onResponse(Call<MoviesRespons> call, Response<MoviesRespons> response) {
                //Upadte Ui
                //Respons Movies
                if (response.isSuccessful()) {

                    MoviesRespons moviesRespons = response.body();
                    movies = moviesRespons.getmResults();

                    adapter = new MyAdapter(MainActivity.this, movies);
                    recyclerView.setLayoutManager(gridLayoutManager);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.INVISIBLE);
                }


                return;


            }

            @Override
            public void onFailure(Call<MoviesRespons> call, Throwable t) {
                //display err !! ok
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT);

            }
        });

    }




    }

















