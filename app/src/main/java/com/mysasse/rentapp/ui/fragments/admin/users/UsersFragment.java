package com.mysasse.rentapp.ui.fragments.admin.users;

import android.os.Bundle;
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

public class UsersFragment extends Fragment {

    public UsersFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.users_fragment, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //Database handler instance
        DatabaseHandler dbh = new DatabaseHandler(getActivity());

        //Get the recycler view and set the users on the recycler
        RecyclerView usersRecyclerView = view.findViewById(R.id.users_recycler_view);
        usersRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        usersRecyclerView.setHasFixedSize(true);

        UsersAdapter adapter = new UsersAdapter(dbh.getAllUsers());

        usersRecyclerView.setAdapter(adapter);

    }
}
