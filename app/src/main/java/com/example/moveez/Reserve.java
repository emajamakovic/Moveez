package com.example.moveez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Reserve extends AppCompatActivity {

    private TextView movieName;
    private TextView movieProjection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reserve_layout);

        movieName = findViewById(R.id.movieN);
        movieProjection = findViewById(R.id.movieP);
/*
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            setTitle(extras.getString(MovieDetails.MOVIE_NAME));
            movieName.setText(extras.getString(MovieDetails.MOVIE_NAME));
            movieProjection.setText(extras.getString(MovieDetails.MOVIE_PROJECTION));
        }*/

        Intent intent = getIntent();
        String movie_name = intent.getStringExtra("MOVIE_NAME");
        String movie_projection = intent.getStringExtra("PROJECTION_NAME");

        movieName.setText(movie_name);
        movieProjection.setText(movie_projection);


    }

    public void onReserve(View view) {
        String movie_name = movieName.getText().toString();
        Movie movie = MovieDatabase.getInstance(this).movieDao().getMovieByName(movie_name);
        Intent intent = new Intent(this, ReservationFragment.class);
        startActivity(intent);
    }
}
