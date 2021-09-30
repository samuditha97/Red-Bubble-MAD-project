package com.example.mynew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class HealthProfileFinder extends AppCompatActivity {

    TextInputLayout Name;
    Button searched;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_profile_finder);

        searched = findViewById(R.id.reg_btn);
    }

    private Boolean validatename() {

        String val = Name.getEditText().getText().toString();
        if (val.isEmpty()) {
            Name.setError("Field cannot be empty");
            return false;
        } else {
            Name.setError(null);
            Name.setErrorEnabled(false);
            return true;
        }
    }

    public void searched(View view) {
        //Validate Login Info
        if (!validatename()) {
            return;
        } else {
            isUser();
        }
    }

    private void isUser() {
        final String userEnteredName = Name.getEditText().getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("HealthProfile");
        Query checkUser = reference.orderByChild("Name").equalTo(userEnteredName);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Name.setError(null);
                    Name.setErrorEnabled(false);
                    String nameFromDB = dataSnapshot.child(userEnteredName).child("Name").getValue(String.class);
                    String ageFromDB = dataSnapshot.child(userEnteredName).child("Age").getValue(String.class);
                    String genderFromDB = dataSnapshot.child(userEnteredName).child("Gender").getValue(String.class);
                    String heightFromDB = dataSnapshot.child(userEnteredName).child("Height").getValue(String.class);
                    String weightFromDB = dataSnapshot.child(userEnteredName).child("Weight").getValue(String.class);
                    String bloodgroupFromDB = dataSnapshot.child(userEnteredName).child("BloodGroup").getValue(String.class);

                    Intent intent = new Intent(getApplicationContext(), HealthAccount.class);
                    intent.putExtra("Name", nameFromDB);
                    intent.putExtra("Age", ageFromDB);
                    intent.putExtra("Gender", genderFromDB);
                    intent.putExtra("Height", heightFromDB);
                    intent.putExtra("Weight", weightFromDB);
                    intent.putExtra("BloodGroup", bloodgroupFromDB);
                    startActivity(intent);
                }

                }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}