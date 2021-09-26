package com.example.mynew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BudgetHome extends AppCompatActivity {

    private CardView budgetCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_home);

        budgetCardView = findViewById(R.id.budgetCardView);

        budgetCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BudgetHome.this, MyBudget.class);
                startActivity(intent);
            }
        });
    }
}