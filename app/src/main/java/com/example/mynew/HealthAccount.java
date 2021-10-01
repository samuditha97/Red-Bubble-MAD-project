package com.example.mynew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HealthAccount extends AppCompatActivity {

    TextInputLayout name, age, gender, height, weight, bloodgroup;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    Button btndelete;

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
        btndelete = findViewById(R.id.btndelete);

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("HealthProfile");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds: snapshot.getChildren()){
                    UserHelperClass helperClass=ds.getValue(UserHelperClass.class);
                    String Name = helperClass.getName();
                    String Age = helperClass.getAge();
                    String Gender = helperClass.getGender();
                    String Height = helperClass.getHeight();
                    String Weight = helperClass.getWeight();
                    String BloodGroup = helperClass.getBloodGroup();

                    name.getEditText().setText(Name);
                    age.getEditText().setText(Age);
                    gender.getEditText().setText(Gender);
                    height.getEditText().setText(Height);
                    weight.getEditText().setText(Weight);
                    bloodgroup.getEditText().setText(BloodGroup);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String useridd = reference.push().getKey();
                deleteprof(useridd);
            }
        });
    }

    private void deleteprof(String useridd) {
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("HealthProfile");
        reference.child(useridd).getKey();

        reference.removeValue();
        Toast.makeText(HealthAccount.this, "Health Profile Deleted", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(HealthAccount.this,HealthHome.class);
        startActivity(intent);
    }


}