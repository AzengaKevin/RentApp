package com.mysasse.rentapp.ui.fragments.admin.properties;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mysasse.rentapp.R;
import com.mysasse.rentapp.data.DatabaseHandler;

public class PropertiesFragment extends Fragment {

    public PropertiesFragment() {

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.properties_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //Create Database Handler instance
        DatabaseHandler dbh = new DatabaseHandler(getActivity());
        //Register necessary views
        RecyclerView housesRecyclerView = view.findViewById(R.id.houses_recycler_view);
        housesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        housesRecyclerView.setHasFixedSize(true);
        FloatingActionButton addHouseFab = view.findViewById(R.id.add_house_fab);

        HousesAdapter adapter = new HousesAdapter(dbh.getAllHouses());
        housesRecyclerView.setAdapter(adapter);

        addHouseFab.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.addHouseFragment));
    }
}
