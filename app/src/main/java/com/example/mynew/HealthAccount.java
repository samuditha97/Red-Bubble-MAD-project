package com.example.mynew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.textfield.TextInputLayout;

public class HealthAccount extends AppCompatActivity {

    TextInputLayout regName, age, gender, height, weight, bloodgroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_account);

        //Hooks
        regName = findViewById(R.id.name);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        bloodgroup = findViewById(R.id.bloodgroup);

        showAllUserData();

    }
        private void showAllUserData() {
            Intent intent = getIntent();
            String Name = intent.getStringExtra("name");
            String Age = intent.getStringExtra("age");
            String Gender = intent.getStringExtra("gender");
            String Height = intent.getStringExtra("height");
            String Weight = intent.getStringExtra("weight");
            String BloodGroup = intent.getStringExtra("bloodgroup");

            regName.getEditText().setText(Name);
            age.getEditText().setText(Age);
            gender.getEditText().setText(Gender);
            height.getEditText().setText(Height);
            weight.getEditText().setText(Weight);
            bloodgroup.getEditText().setText(BloodGroup);

        }

}