package com.mysasse.rentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mysasse.rentapp.data.DatabaseHandler;
import com.mysasse.rentapp.ui.LoginActivity;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Init the database handler
        DatabaseHandler dbh = new DatabaseHandler(this);

        Log.d(TAG, "onCreate: users count: " + dbh.getAllUsers().size());

        //Get toolbar and set it as the action bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Register the bottom navigation view
        BottomNavigationView navigationView = findViewById(R.id.default_bnv);

        //Setup the App Bar Configuration
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.homeFragment, R.id.rentAblesFragment, R.id.transactionsFragment)
                .build();

        //Get the nav controller from the nav host fragment
        NavController navController = Navigation.findNavController(this, R.id.default_nav_host_fragment);

        //Navigation UI Stuff
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.default_options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.login:
                startActivity(new Intent(this, LoginActivity.class));
                return true;
            case R.id.admin:
                startActivity(new Intent(this, AdminActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
