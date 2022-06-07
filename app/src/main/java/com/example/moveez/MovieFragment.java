package com.example.moveez;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class MovieFragment extends  Fragment {
    private ListView listView;
    public static final String EXTRA_IMAGE = "EXTRA_IMAGE";
    public static final String EXTRA_NAME= "EXTRA_NAME";
    public static final String EXTRA_YEAR = "EXTRA_YEAR";
    public static final String EXTRA_GENRE = "EXTRA_GENRE";
    public static final String EXTRA_ACTORS= "EXTRA_ACTORS";
    public static final String EXTRA_PROJECTION = "EXTRA_PROJECTION";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.movie_layout, container, false);

        listView = view.findViewById(R.id.movie_list);

        MovieAdapter movieAdapter = new MovieAdapter(getMovie(),getContext());
        listView.setAdapter(movieAdapter);

        listView.setOnItemClickListener(onItemClickListener);


        return view;
    }


    private final AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Movie movie = (Movie) parent.getItemAtPosition(position);
            Intent intent = new Intent(getContext(), MovieDetails.class);
            intent.putExtra(EXTRA_IMAGE, movie.getImageResId());
            intent.putExtra(EXTRA_NAME, movie.getName());
            intent.putExtra(EXTRA_ACTORS, movie.getActors());
            intent.putExtra(EXTRA_GENRE, movie.getGenre());
            intent.putExtra(EXTRA_YEAR, movie.getYear());
            intent.putExtra(EXTRA_PROJECTION, movie.getProjection());

            startActivity(intent);
        }
    };


        private List<Movie> getMovie()
        {
            List<Movie> movieList = new ArrayList<>();
            movieList.add(new Movie(R.drawable.movie1,"Avatar","2009","Sci-fi","Zoe Saldana, Sam Worthington","Date: 10/06/2022 Time: 18:00"));
            movieList.add(new Movie(R.drawable.movie2,"Cherry","2021","Drama","Tom Holland, Ciara Bravo","Date: 12/06/2022 Time: 17:00"));
            movieList.add(new Movie(R.drawable.movie3,"Split","2016","Horror","James McAvoy, Ana Taylor-Joy","Date: 12/06/2022 Time: 20:00"));
            movieList.add(new Movie(R.drawable.movie4,"Whiplash","2014","Music","Milles Teller, J.K. Simmons","Date: 14/06/2022 Time: 16:00"));
            movieList.add(new Movie(R.drawable.movie5,"Dune","2021","Action","Timothee Chalamet, Zendaya","Date: 15/06/2022 Time: 18:00"));

            return movieList;
        }
}


