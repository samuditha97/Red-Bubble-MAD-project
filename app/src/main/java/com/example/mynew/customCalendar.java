package com.example.mynew;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class customCalendar extends LinearLayout {
    ImageView NextButton,PreviousButton;
    TextView CurrentDate;
    GridView gridView;
    private  static final int MAX_CALENDAR_DAYS = 42;
    Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
    Context context;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM////",Locale.ENGLISH);
    SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM",Locale.ENGLISH);
    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy",Locale.ENGLISH);

    List<Date> dates = new ArrayList<>();
    List<Events> eventsList = new ArrayList<>();

    public customCalendar(Context context){
        super(context);
    }

    public customCalendar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        IntializeLayout();

        PreviousButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.add(Calendar.MONTH,-1);
                SetUpCalendar();
            }
        });
        NextButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar.add(Calendar.MONTH,1);
                SetUpCalendar();
            }
        });


    }

    public customCalendar(Context context, @Nullable AttributeSet attrs, int defStyleAtt, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void IntializeLayout(){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_family_calander, this);
        NextButton = view.findViewById(R.id.next_btn);
        PreviousButton = view.findViewById(R.id.forward_btn);
        CurrentDate = view.findViewById(R.id.current_date);
        gridView = view.findViewById(R.id.gridview);
    }

    private void SetUpCalendar(){
        String currentDate = dateFormat.format(calendar.getTime());
        CurrentDate.setText(currentDate);
    }
}
