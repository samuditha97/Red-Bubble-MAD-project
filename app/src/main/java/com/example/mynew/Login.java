package com.example.mynew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Queue;

public class Login extends AppCompatActivity {

    ImageView backBtn;
    Button login;
    TextView titleText;
    TextInputLayout username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        //Hooks
        backBtn = findViewById(R.id.login_back_btn);
        login = findViewById(R.id.login_enter_btn);
        titleText = findViewById(R.id.login_title_txt);
    }


        private Boolean validateUsername () {
            String val = username.getEditText().getText().toString();

            if (val.isEmpty()) {
                username.setError("Field cannot be empty");
                return false;
            } else {
                username.setError(null);
                username.setErrorEnabled(false);
                return true;
            }
        }

        private Boolean validatePassword () {
            String val = password.getEditText().getText().toString();


            if (val.isEmpty()) {
                password.setError("Field cannot be empty");
                return false;
            } else {
                password.setError(null);
                password.setErrorEnabled(false);
                return true;
            }
        }



        public void loggedin(View view){
            //validate login info
            if (!validateUsername() | !validatePassword()) {
                return;
            } else {
                isUser();
            }
        }

        private void isUser() {
            String userEnteredUsername = username.getEditText().getText().toString().trim();
            String userEnteredPassword = password.getEditText().getText().toString().trim();

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");

            Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);
            checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    if (snapshot.exists()) {

                        username.setError(null);
                        username.setErrorEnabled(false);

                        String passwordFromDB = snapshot.child(userEnteredUsername).child("password").getValue(String.class);

                        if (passwordFromDB.equals(userEnteredPassword)) {

                            username.setError(null);
                            username.setErrorEnabled(false);

                            String nameFromDB = snapshot.child(userEnteredUsername).child("name").getValue(String.class);
                            String usernameFromDB = snapshot.child(userEnteredUsername).child("username").getValue(String.class);
                            String phoneFromDB = snapshot.child(userEnteredUsername).child("phone").getValue(String.class);
                            String emailFromDB = snapshot.child(userEnteredUsername).child("email").getValue(String.class);

                            Intent intent = new Intent(getApplicationContext(), UserProfile.class);
                            intent.putExtra("name", nameFromDB);
                            intent.putExtra("username", usernameFromDB);
                            intent.putExtra("email", emailFromDB);
                            intent.putExtra("phone", phoneFromDB);
                            intent.putExtra("password", passwordFromDB);

                            startActivity(intent);
                        } else {
                            password.setError("Wrong Password");
                            password.requestFocus();
                        }
                    } else {
                        username.setError("No such User exist");
                        username.requestFocus();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }



        public void call_signup_login_Screen (View view){
        Intent intent = new Intent(getApplicationContext(), login_signup.class);

        Pair[] pairs = new Pair[1];
        pairs[0] = new Pair<View, String>(findViewById(R.id.login_back_btn), "trasition_login");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }

    }


    }
