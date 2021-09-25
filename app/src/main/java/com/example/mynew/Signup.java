package com.example.mynew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    ImageView backBtn;
    Button signupBtn;
    TextView titleText;

    //get data variables
    TextInputLayout pname, pusername, pemail, ppassword, pphone;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);

        //Hooks
        backBtn = findViewById(R.id.signup_back_btn);
        signupBtn = findViewById(R.id.signup_enter_btn);
        titleText = findViewById(R.id.signup_title_txt);

        //hooks for getting data
        pname = findViewById(R.id.name);
        pusername = findViewById(R.id.username);
        pemail = findViewById(R.id.email);
        ppassword = findViewById(R.id.password);
        pphone = findViewById(R.id.phone);
        mFirebaseAuth = FirebaseAuth.getInstance();

        //save data in firebase on button click

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 rootNode = FirebaseDatabase.getInstance();
                 reference = rootNode.getReference("Users");

                //get all the values
                String name = pname.getEditText().getText().toString();
                String username = pusername.getEditText().getText().toString();
                String email = pemail.getEditText().getText().toString();
                String password = ppassword.getEditText().getText().toString();
                String phone = pphone.getEditText().getText().toString();


                SignupHelper helperClass = new SignupHelper(name,username,email,phone,password);

                reference.child(phone).setValue(helperClass);
            }
        });//register button method end

    }//oncreate method end


}







