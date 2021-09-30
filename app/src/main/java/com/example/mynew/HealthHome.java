package com.example.mynew;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class HealthHome extends AppCompatActivity {

    private CardView health_profile;
    private CardView bmi;
    private CardView timer;
    private CardView profilesearcher;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_home);



        health_profile = findViewById(R.id.health_profile);
        bmi = findViewById(R.id.bmi);
        timer = findViewById(R.id.timer);
        profilesearcher = findViewById(R.id.profilesearcher);

        health_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthHome.this, HealthProfile.class);
                startActivity(intent);
            }
        });

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthHome.this, BMICalculator.class);
                startActivity(intent);
            }
        });

        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthHome.this, HealthTimer.class);
                startActivity(intent);
            }
        });

        profilesearcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthHome.this, HealthAccount.class);
                startActivity(intent);
            }
        });

    }

}