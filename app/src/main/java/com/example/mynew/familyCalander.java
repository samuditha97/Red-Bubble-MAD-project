package com.example.mynew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.google.android.material.textfield.TextInputLayout;




public class familyCalander extends AppCompatActivity {

    TextInputLayout event, time, date, month, year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_calander);


        String EVENT = event.getEditText().getText().toString();
        String TIME = time.getEditText().getText().toString();
        String DATE = date.getEditText().getText().toString();
        String MONTH = month.getEditText().getText().toString();
        String YEAR = year.getEditText().getText().toString();

        Events events = new Events("EVENT","TIME","DATE","MONTH","YEAR");


    }
    String userEnteredEvent = event.getEditText().getText().toString().trim();
    String userEnteredTime = time.getEditText().getText().toString().trim();
    String userEnteredDate = date.getEditText().getText().toString().trim();
    String userEnteredMonth = month.getEditText().getText().toString().trim();
    String userEnteredYear = year.getEditText().getText().toString().trim();


    }