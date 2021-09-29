package com.example.mynew;

        import androidx.appcompat.app.ActionBarDrawerToggle;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.widget.Toolbar;
        import androidx.cardview.widget.CardView;
        import androidx.core.view.GravityCompat;
        import androidx.drawerlayout.widget.DrawerLayout;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;

        import com.google.android.material.navigation.NavigationView;

public class OfficialHome extends AppCompatActivity {

    private CardView NotePadCardView;
    private CardView GPACardView;
    private CardView EmergencyCardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_official_home);



        NotePadCardView = findViewById(R.id.NotePadCardView);
        GPACardView = findViewById(R.id.GPACardView);
        EmergencyCardView = findViewById(R.id.EmergencyCardView);

        NotePadCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OfficialHome.this, NotepadActivity.class);
                startActivity(intent);
            }
        });

        GPACardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OfficialHome.this, GPACalculator.class);
                startActivity(intent);
            }
        });

        EmergencyCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OfficialHome.this, EmergencyPlacesActivity.class);
                startActivity(intent);
            }
        });
    }

}