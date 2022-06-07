package com.example.moveez;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "reservations")
public class Reservation {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private long movie_id;
    private long user_id;

    public Reservation(long movie_id, long user_id) {
        this.movie_id = movie_id;
        this.user_id = user_id;
    }

    public long getId() {
        return id;
    }

    public long getMovie_id() {
        return movie_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMovie_id(long movie_id) {
        this.movie_id = movie_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
