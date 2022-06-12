package com.example.moveez;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class Reserve extends AppCompatActivity {

    private TextView movieName;
    private TextView movieProjection;
    private ImageView movieImage;

    public static final String RESERVATION_ID = "RESERVATION_ID";
    public static final String MOVIE_PROJECTION = "MOVIE_PROJECTION";

    public static final String CHANNEL_ID = "My channel";
    private long id;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reserve_layout);

        movieName = findViewById(R.id.movieN);
        movieProjection = findViewById(R.id.movieP);
        movieImage = findViewById(R.id.movieI);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            id=extras.getLong(MovieDetails.USER_ID);
            setTitle(extras.getString(MovieDetails.MOVIE_NAME));
            movieImage.setImageResource(extras.getInt(MovieDetails.MOVIE_IMAGE));
            movieName.setText(extras.getString(MovieDetails.MOVIE_NAME));
            movieProjection.setText(extras.getString(MovieDetails.MOVIE_PROJECTION));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Custom Channel", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


    }

    public void onReserve(View view) {
//        String movie_projection = movieProjection.getText().toString();
//        String movie_name = movieName.getText().toString();
//        Movie movie = MovieDatabase.getInstance(this).movieDao().getMovieByName(movie_name);
//        long movieID = movie.getId();
//        Reservation reservation = new Reservation(movieID);
//        MovieDatabase.getInstance(this).reservationDao().addReservation(reservation);
//        long reservationID = reservation.getId();
//
//        Intent intent = new Intent(this, ReservationFragment.class);
//        intent.putExtra(RESERVATION_ID, reservationID);
//        intent.putExtra(MOVIE_PROJECTION, movie_projection);
//        startActivity(intent);

        Reservation reservation = new Reservation(movieName.getText().toString(), movieProjection.getText().toString(),id);
        MovieDatabase.getInstance(this).reservationDao().addReservation(reservation);


        new AlertDialog.Builder(Reserve.this).setTitle("Moveez").setMessage("Your reservation is complete!").show();

        Intent notificationIntent = new Intent(Reserve.this, Notification.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(Reserve.this, 0, notificationIntent, PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(Reserve.this, CHANNEL_ID);

        builder.setContentTitle("Moveez").setContentText("Your reservation is complete!").setSmallIcon(R.drawable.ic_baseline_local_movies_24)
                .setColor(Color.RED).addAction(R.drawable.ic_baseline_local_movies_24, "Notification", pendingIntent);


        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Reserve.this);
        managerCompat.notify(1,builder.build());



    }

}
