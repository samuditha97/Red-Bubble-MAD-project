package com.example.mynew;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class HealthProfile extends AppCompatActivity {
    //Variables
    TextInputLayout regName, age, gender, height, weight, bloodgroup;
    Button regBtn;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_profile);
//Hooks to all xml elements in activity_sign_up.xml
        regName = findViewById(R.id.reg_name);
        age = findViewById(R.id.age);
        gender = findViewById(R.id.gender);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        bloodgroup = findViewById(R.id.bloodgroup);
        regBtn = findViewById(R.id.reg_btn);
//Save data in FireBase on button click
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("HealthProfile");
//Get all the values
                String Name = regName.getEditText().getText().toString();
                String Age = age.getEditText().getText().toString();
                String Gender = gender.getEditText().getText().toString();
                String Height = height.getEditText().getText().toString();
                String Weight = weight.getEditText().getText().toString();
                String BloodGroup = bloodgroup.getEditText().getText().toString();
                UserHelperClass helperClass = new UserHelperClass(Name, Age, Gender, Height, Weight, BloodGroup);
                reference.child(Name).setValue(helperClass);
            }
        });//Register Button method end
    }//onCreate Method End
}