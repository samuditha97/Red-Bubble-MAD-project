package com.example.mynew;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;


public class Login extends AppCompatActivity implements View.OnClickListener{

    private TextInputLayout pemail,ppassword;
    private Button forgetPassword,login_enter_btn;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        login_enter_btn = (Button) findViewById(R.id.login_enter_btn);
        login_enter_btn.setOnClickListener(this);

        forgetPassword = (Button) findViewById(R.id.forgetPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        pemail = (TextInputLayout) findViewById(R.id.email);
        ppassword = (TextInputLayout) findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_enter_btn:
                userLogin();
                break;


        }

    }

    private void userLogin() {
        String email = pemail.getEditText().toString().trim();
        String password = ppassword.getEditText().toString().trim();

        if (email.isEmpty()){
            pemail.setError("username is required");
            pemail.requestFocus();
            return;
        }
        if (password.isEmpty()){
            ppassword.setError("password is required");
            ppassword.requestFocus();
            return;
        }


        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //redirect to user profile
                    startActivity(new Intent(Login.this,UserProfile.class));
                }else {
                    Toast.makeText(Login.this,"Failed to login please check your credentials",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}


