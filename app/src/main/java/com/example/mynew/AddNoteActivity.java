package com.example.mynew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AddNoteActivity extends AppCompatActivity {

    private String CategoryName,Description;
    private Button AddNoteButton;
    private ImageView InputnoteImage;
    private EditText InputNoteTitle, InputNoteSubTitle, InputNoteDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        CategoryName = getIntent().getExtras().get("category").toString();

        AddNoteButton = (Button) findViewById(R.id.add_new_note);
        InputnoteImage = (ImageView) findViewById(R.id.note_image);
        InputNoteTitle = (EditText) findViewById(R.id.note_title);
        InputNoteSubTitle = (EditText) findViewById(R.id.note_subtitle);
        InputNoteDescription = (EditText) findViewById(R.id.note_description);
    }
}