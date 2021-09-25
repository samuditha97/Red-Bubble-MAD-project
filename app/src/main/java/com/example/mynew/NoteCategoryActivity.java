package com.example.mynew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class NoteCategoryActivity extends AppCompatActivity {

    private ImageView school, office;
    private ImageView personal, events;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_category);

        school = (ImageView) findViewById(R.id.school);
        office = (ImageView) findViewById(R.id.office);
        personal = (ImageView) findViewById(R.id.personal);
        events = (ImageView) findViewById(R.id.events);


        school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(NoteCategoryActivity.this, AddNoteActivity.class);
                intent.putExtra("category", "school");
                startActivity(intent);
            }
        });

        office.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(NoteCategoryActivity.this, AddNoteActivity.class);
                intent.putExtra("category", "office");
                startActivity(intent);
            }
        });

        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(NoteCategoryActivity.this, AddNoteActivity.class);
                intent.putExtra("category", "personal");
                startActivity(intent);
            }
        });

        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(NoteCategoryActivity.this, AddNoteActivity.class);
                intent.putExtra("category", "events");
                startActivity(intent);
            }
        });
    }
}