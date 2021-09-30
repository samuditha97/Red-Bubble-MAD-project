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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;



public class Signup extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText pname,pemail,pphone,ppassword;
    private TextView signup_title_txt;
    private Button signup_enter_btn;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        signup_title_txt = (TextView) findViewById(R.id.signup_title_txt);
        signup_title_txt.setOnClickListener(this);

        signup_enter_btn = (Button) findViewById(R.id.signup_enter_btn);
        signup_enter_btn.setOnClickListener(this);

        pname =(TextInputEditText) findViewById(R.id.name);
        pemail =(TextInputEditText) findViewById(R.id.email);
        pphone =(TextInputEditText) findViewById(R.id.phone);
        ppassword =(TextInputEditText) findViewById(R.id.password);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signup_title_txt:
                startActivity(new Intent(this,Login.class));
                break;
            case  R.id.signup_enter_btn:
                signup_enter_btn();
                break;

        }

    }

    private void signup_enter_btn() {
        String email = pemail.getText().toString().trim();
        String password = ppassword.getText().toString().trim();
        String name = pname.getText().toString().trim();
        String phone = pphone.getText().toString().trim();


        if (name.isEmpty()){
            pname.setError("Name is required");
            pname.requestFocus();
            return;
        }
        if (email.isEmpty()){
            pemail.setError("email is required");
            pemail.requestFocus();
            return;

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            pemail.setError("please provide valid email");
            pemail.requestFocus();
            return;
        }
        if (phone.isEmpty()){
            pphone.setError("phone number is required");
            pphone.requestFocus();
            return;

        }
        if (password.isEmpty()){
            ppassword.setError("password is required");
            ppassword.requestFocus();
            return;

        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            User user = new User(name, email, phone);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Signup.this, "User has been registered successfully", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);

                                        //redirect to login
                                    } else {
                                        Toast.makeText(Signup.this, "Failed to register try agin", Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });
                        }else{
                            Toast.makeText(Signup.this, "Failed to register try agin", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

    }
}







