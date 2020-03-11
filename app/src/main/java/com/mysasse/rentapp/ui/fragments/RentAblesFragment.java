package com.mysasse.rentapp.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mysasse.rentapp.R;
import com.mysasse.rentapp.data.DatabaseHandler;
import com.mysasse.rentapp.ui.fragments.admin.properties.HousesAdapter;

public class RentAblesFragment extends Fragment {
    private static final String TAG = "RentAblesFragment";

    public RentAblesFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.rentables_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //Create Database Handler instance
        DatabaseHandler dbh = new DatabaseHandler(getActivity());
        //Register necessary views
        RecyclerView housesRecyclerView = view.findViewById(R.id.houses_recycler_view);
        housesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        housesRecyclerView.setHasFixedSize(true);

        Log.d(TAG, "onViewCreated: houses count: " + dbh.getAllHouses().size());
        HousesAdapter adapter = new HousesAdapter(dbh.getAllHouses());
        housesRecyclerView.setAdapter(adapter);
    }
}
