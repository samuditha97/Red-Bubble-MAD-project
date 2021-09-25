package com.example.mynew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class HealthAccount extends AppCompatActivity {

    TextInputLayout name, age, gender, height, weight, bloodgroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_account);

        //Hooks
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        bloodgroup = findViewById(R.id.bloodgroup);

        showAllUserData();

    }
        private void showAllUserData() {
            Intent intent = getIntent();
            String Name = intent.getStringExtra("Name");
            String Age = intent.getStringExtra("Age");
            String Gender = intent.getStringExtra("Gender");
            String Height = intent.getStringExtra("Height");
            String Weight = intent.getStringExtra("Weight");
            String BloodGroup = intent.getStringExtra("BloodGroup");

            name.getEditText().setText(Name);
            age.getEditText().setText(Age);
            gender.getEditText().setText(Gender);
            height.getEditText().setText(Height);
            weight.getEditText().setText(Weight);
            bloodgroup.getEditText().setText(BloodGroup);

        }

}