package com.example.mynew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mynew.R;

public class MainHome extends AppCompatActivity {

    private CardView FamilyCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);

        FamilyCardView = findViewById(R.id.FamilyCardView);

        FamilyCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainHome.this,familyHome.class);
                startActivity(intent);
            }
        });
      
      
    }
}