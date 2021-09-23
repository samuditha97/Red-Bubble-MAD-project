package com.example.mynew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class EmergencyPlacesActivity extends AppCompatActivity {

    private static final String TAG = "EmergencyPlacesActivity";
    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mPhone = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_places);
        Log.d(TAG, "onCreate: started");
        initImageBitmaps();
    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: started");
        mImageUrls.add("https://upload.wikimedia.org/wikipedia/en/d/d1/Lanka_Hospitals_logo.png");
        mNames.add("Lanka Hospitals  No:940");
        mImageUrls.add("https://www.logolynx.com/images/logolynx/5a/5ab647016211a7647ade0b764e68881f.jpeg");
        mNames.add("Sri Lanka Police  No:911");
        mImageUrls.add("https://img.traveltriangle.com/blog/wp-content/tr:w-700,h- 400/uploads/2015/06/Mirissa-Fisheries-Harbor.jpg");
        mNames.add("Srilanka.travel  No: 900");
        mImageUrls.add("https://upload.wikimedia.org/wikipedia/en/thumb/1/1d/Sri_Lanka_Police_logo.svg/800px-Sri_Lanka_Police_logo.svg.png");
        mNames.add("Sri Lanka Police  No:119");
        mImageUrls.add("https://upload.wikimedia.org/wikipedia/en/d/d1/Lanka_Hospitals_logo.png");
        mNames.add("Lanka Hospitals  No:940");
        mImageUrls.add("https://www.logolynx.com/images/logolynx/5a/5ab647016211a7647ade0b764e68881f.jpeg");
        mNames.add("Sri Lanka Police  No:911");
        mImageUrls.add("https://img.traveltriangle.com/blog/wp-content/tr:w-700,h- 400/uploads/2015/06/Mirissa-Fisheries-Harbor.jpg");
        mNames.add("Srilanka.travel  No: 900");
        mImageUrls.add("https://upload.wikimedia.org/wikipedia/en/thumb/1/1d/Sri_Lanka_Police_logo.svg/800px-Sri_Lanka_Police_logo.svg.png");
        mNames.add("Sri Lanka Police  No:119");
        initRecyclerView();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: started");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames,mImageUrls,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}