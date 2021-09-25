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
        pusername = findViewById(R.id.login_username);
        pemail = findViewById(R.id.email);
        ppassword = findViewById(R.id.password);
        pphone = findViewById(R.id.phone);
        mFirebaseAuth = FirebaseAuth.getInstance();

        //save data in firebase on button click

        signupBtn.setOnClickListener(new View.OnClickListener() {


            private Boolean validateName () {
                String val = pname.getEditText().getText().toString();

                if (val.isEmpty()) {
                    pname.setError("Field cannot be empty");
                    return false;
                } else {
                    pname.setError(null);
                    pname.setErrorEnabled(false);
                    return true;
                }
            }

            private Boolean validateUsername () {
                String val = pusername.getEditText().getText().toString();
                String noWhiteSpace = "\\A\\w{4,20}\\z";

                if (val.isEmpty()) {
                    pusername.setError("Field cannot be empty");
                    return false;
                } else if (val.length() >= 15) {
                    pusername.setError("Username is too long");
                    return false;
                } else if (!val.matches(noWhiteSpace)) {
                    pusername.setError("White spaces are not allowed");
                    return false;
                } else {
                    pusername.setError(null);
                    pusername.setErrorEnabled(false);
                    return true;
                }
            }

            private Boolean validateEmail () {
                String val = pemail.getEditText().getText().toString();
                String emailPattern = "[a-zA-z0-9._-]+@[a-z]+\\.+[a-z]+";

                if (val.isEmpty()) {
                    pemail.setError("Field cannot be empty");
                    return false;
                } else if (!val.matches(emailPattern)) {
                    pemail.setError("Invalid email address");
                    return false;
                } else {
                    pemail.setError(null);
                    pemail.setErrorEnabled(false);
                    return true;
                }
            }

            private Boolean validatePhone () {
                String val = pphone.getEditText().getText().toString();


                if (val.isEmpty()) {
                    pphone.setError("Field cannot be empty");
                    return false;
                } else {
                    pphone.setError(null);
                    pphone.setErrorEnabled(false);
                    return true;
                }
            }

            private Boolean validatePassword () {
                String val = ppassword.getEditText().getText().toString();


                if (val.isEmpty()) {
                    ppassword.setError("Field cannot be empty");
                    return false;
                } else {
                    ppassword.setError(null);
                    ppassword.setErrorEnabled(false);
                    return true;
                }
            }

            @Override
            public void onClick(View view) {

                if(!validateName() | !validateUsername() | !validateEmail() | !validatePhone() | !validatePassword()){
                    return;
                }

                FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
                DatabaseReference reference = rootNode.getReference("Users");

                //get all the values
                String name = pname.getEditText().getText().toString();
                String username = pusername.getEditText().getText().toString();
                String email = pemail.getEditText().getText().toString();
                String password = ppassword.getEditText().getText().toString();
                String phone = pphone.getEditText().getText().toString();


                SignupHelper helperClass = new SignupHelper(name, username, email, password, phone);

                reference.child(phone).setValue(helperClass);
            }
        });//register button method end

    }//oncreate method end


}







