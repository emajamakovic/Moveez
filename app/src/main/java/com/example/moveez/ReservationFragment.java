package com.example.moveez;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class ReservationFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView reservation, projection;
    private String passed_reservation, passed_projection;
    private long id;
    private ListView listView;


    private String mParam1;
    private String mParam2;

    public ReservationFragment() {
        // Required empty public constructor
    }

    public ReservationFragment(long id) {
        this.id = id;
    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.reservation_layout, container, false);

        // listView = view.findViewById(R.id.reservation_list);

        // ReservationAdapter reservationAdapter = new ReservationAdapter(getReservation(),getContext());
        //listView.setAdapter(reservationAdapter);

        return view;
    }
}
/*
    private List<Reservation> getReservation() {
        List<Reservation> reservationList = new ArrayList<>();

        Reservation reservation = (Reservation) MovieDatabase.getInstance(getActivity()).reservationDao().getReservationByUserId(id);

        reservationList.add(reservation);

        return reservationList;
    }
}
*/