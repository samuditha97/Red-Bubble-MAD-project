package com.example.mynew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GPACalculator extends AppCompatActivity {

    private EditText Credit,Grade;
    private Button addCourse,seeGpa,erase;
    private TextView textView;
    double counter=0,total_credit= 0,credit= 0,grade= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpacalculator);
        Credit = findViewById(R.id.editText);
        Grade = findViewById(R.id.editText2);
        addCourse = findViewById(R.id.button_gpa);
        seeGpa = findViewById(R.id.buttonGpa_view);
        erase = findViewById(R.id.butoon_erase);
        textView = findViewById(R.id.textView_gpaview);
        addCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                credit = Double.parseDouble(Credit.getText().toString());
                grade = Double.parseDouble(Grade.getText().toString());
                counter += (grade*credit);
                total_credit+=credit;
                Toast.makeText(getApplicationContext(),"Credit : "+credit+"\ngrade : "+grade,Toast.LENGTH_LONG).show();
                Credit.setText("");
                Grade.setText("");
            }
        });

        seeGpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double result = counter/total_credit;
                textView.setText("Your GPA : "+result);

            }
        });

        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter =0;
                total_credit=0;
                credit=0;
                grade=0;
                Credit.setText("");
                Grade.setText("");
                textView.setText("");
            }
        });

    }
}