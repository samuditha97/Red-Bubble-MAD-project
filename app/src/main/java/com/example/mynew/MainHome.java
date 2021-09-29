package com.example.mynew;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mynew.R;
import com.google.android.material.navigation.NavigationView;

public class MainHome extends AppCompatActivity {
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

        FamilyCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainHome.this,familyHome.class);
                startActivity(intent);
            }
        });

        HealthCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainHome.this,HealthHome.class);
                startActivity(intent);
            }
        });

        OfficialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainHome.this,OfficialHome.class);
                startActivity(intent);
            }
        });



        /*------------------------Hooks------------------*/
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        /*----------------------ToolBar-------------------*/
        setSupportActionBar(toolbar);


        /*---------------------Navigation DrawerMenu-------------*/

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }
}