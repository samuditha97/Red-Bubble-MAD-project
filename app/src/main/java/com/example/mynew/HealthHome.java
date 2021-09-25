package com.example.mynew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HealthHome extends AppCompatActivity {

    private CardView health_profile;
    private CardView bmi;
    private CardView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_home);

        health_profile = findViewById(R.id.health_profile);
        bmi = findViewById(R.id.bmi);
        timer = findViewById(R.id.timer);

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

    }
}