package com.example.moveez;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ReservationAdapter extends BaseAdapter {
    private List<Movie> reservationList;
    private Context context;

    public ReservationAdapter(List<Reservation> reservationList, Context context) {
       // this.reservationList = reservationList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return reservationList.size();
    }

    @Override
    public Object getItem(int position) {
        return reservationList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return reservationList.indexOf(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.movielist_layout, parent, false);


        Reservation reservation = (Reservation) getItem(position);
        TextView username = convertView.findViewById(R.id.reservation);
        TextView projection = convertView.findViewById(R.id.projection);

/*
        username.setText(reservation.getName());
        actors.setText(movie.getActors());*/
        return null;
    }
}
