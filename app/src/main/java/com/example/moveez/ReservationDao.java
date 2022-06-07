package com.example.moveez;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
import java.util.Map;

@Dao
public interface ReservationDao {
    @Query("SELECT * FROM reservations")
    public List<Reservation> getAllReservation();

    @Insert
    public void addReservation(Reservation reservation );

    @Query("SELECT * FROM reservations WHERE id = :id LIMIT 1")
    Reservation getReservationById(long id);

    @Query(
            "SELECT * FROM reservations JOIN user ON user_id = user.id"
    )
    public Map<User, List<Reservation>> loadUserReservations();

    @Query(
            "SELECT * FROM reservations JOIN movies ON movie_id = movies.id"
    )
    public Map<Movie, List<Reservation>> loadUserMovieReservations();
}
