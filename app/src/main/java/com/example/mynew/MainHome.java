package com.example.mynew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mynew.R;

public class MainHome extends AppCompatActivity {

    private CardView FamilyCardView;
    private CardView HealthCardView;
    private CardView OfficialCardView;
    private CardView BudgetCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        BudgetCardView = findViewById(R.id.BudgetCardView);

        BudgetCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainHome.this, BudgetHome.class);
                startActivity(intent);
            }
        });
    }
}