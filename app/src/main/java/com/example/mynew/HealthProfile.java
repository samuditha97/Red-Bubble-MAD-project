package com.example.mynew;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class HealthProfile extends AppCompatActivity {
    //Variables
    TextInputLayout name, age, gender, height, weight, bloodgroup;
    Button reg_btn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_profile);
//Hooks to all xml elements in activity_sign_up.xml
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        bloodgroup = findViewById(R.id.bloodgroup);
        reg_btn = findViewById(R.id.reg_btn);
//Save data in FireBase on button click
        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("HealthProfile");

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//Get all the values
                String Name = name.getEditText().getText().toString();
                String Age = age.getEditText().getText().toString();
                String Gender = gender.getEditText().getText().toString();
                String Height = height.getEditText().getText().toString();
                String Weight = weight.getEditText().getText().toString();
                String BloodGroup = bloodgroup.getEditText().getText().toString();

                if (Name.isEmpty() || Age.isEmpty() || Gender.isEmpty() || Height.isEmpty() || Weight.isEmpty() || BloodGroup.isEmpty())
                {
                    Toast.makeText(HealthProfile.this, "Please complete the fields", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(HealthProfile.this, "Health Profile created succesfully", Toast.LENGTH_LONG).show();
                    String useridd = reference.push().getKey();
                    UserHelperClass helperClass = new UserHelperClass();
                    helperClass.setName(Name);
                    helperClass.setAge(Age);
                    helperClass.setGender(Gender);
                    helperClass.setHeight(Height);
                    helperClass.setWeight(Weight);
                    helperClass.setBloodGroup(BloodGroup);

                    reference.child(useridd).setValue(helperClass, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {

                            Intent intent = new Intent(HealthProfile.this,HealthAccount.class);
                            startActivity(intent);
                        }
                    });
                }
            }
        });//Register Button method end
    }//onCreate Method End
}