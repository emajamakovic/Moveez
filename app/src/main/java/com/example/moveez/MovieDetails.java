package com.example.moveez;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MovieDetails extends AppCompatActivity {
    private ImageView imageView;
    private TextView name;
    private TextView year;
    private TextView genre;
    private TextView actors;
    private TextView projection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

        imageView = findViewById(R.id.movie_image);
        name = findViewById(R.id.name_movie);
        year = findViewById(R.id.year_movie);
        genre = findViewById(R.id.genre_movie);
        actors = findViewById(R.id.actors_movie);
        projection = findViewById(R.id.projection_movie);


        Bundle extras = getIntent().getExtras();
        if(extras != null){
            setTitle(extras.getString(MovieFragment.EXTRA_NAME));
            imageView.setImageResource(extras.getInt(MovieFragment.EXTRA_IMAGE));
            name.setText(extras.getString(MovieFragment.EXTRA_NAME));
            year.setText(extras.getString(MovieFragment.EXTRA_YEAR));
            genre.setText(extras.getString(MovieFragment.EXTRA_GENRE));
            actors.setText(extras.getString(MovieFragment.EXTRA_ACTORS));
            projection.setText(extras.getString(MovieFragment.EXTRA_PROJECTION));

        }
    }

    public void reserve(View view) {
            Intent intent = new Intent(this, Reserve.class);
            startActivity(intent);
        }
    }

