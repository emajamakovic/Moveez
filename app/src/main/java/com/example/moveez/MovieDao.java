package com.example.moveez;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MovieDao {
    @Query("SELECT * FROM movies")
    public List<Movie> getAll();

    @Insert
    public void addItem(Movie movie );

    @Query("SELECT * FROM movies WHERE id = :id LIMIT 1")
    Movie getMovieById(long id);
}
