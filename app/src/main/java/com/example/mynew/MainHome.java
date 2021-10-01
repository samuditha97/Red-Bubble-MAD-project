package com.example.mynew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.mynew.R;
import com.google.android.material.navigation.NavigationView;

public class MainHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    private CardView FamilyCardView;
    private CardView HealthCardView;
    private CardView OfficialCardView;
    private CardView BudgetCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        FamilyCardView = findViewById(R.id.FamilyCardView);
        HealthCardView = findViewById(R.id.HealthCardView);
        OfficialCardView = findViewById(R.id.OfficialCardView);
        BudgetCardView = findViewById(R.id.BudgetCardView);

        FamilyCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainHome.this, familyHome.class);
                startActivity(intent);
            }
        });

        HealthCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainHome.this, HealthHome.class);
                startActivity(intent);
            }
        });

        OfficialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainHome.this, OfficialHome.class);
                startActivity(intent);
            }
        });

        BudgetCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainHome.this, BudgetDashboardActivity.class);
                startActivity(intent);
            }
        });



        /*------------------------Hooks------------------*/
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        /*----------------------ToolBar-------------------*/
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);


        /*---------------------Navigation DrawerMenu-------------*/
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intent = new Intent(MainHome.this, MainHome.class);
                startActivity(intent);
                break;
            case R.id.nav_logout:
                Intent intent3 = new Intent(MainHome.this,Login.class);
                startActivity(intent3);
                break;
            case R.id.nav_account:
                Intent intent1 = new Intent(MainHome.this, UserProfile.class);
                startActivity(intent1);
                break;

        }
        return true;
    }
}

