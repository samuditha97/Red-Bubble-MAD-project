package com.example.mynew;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class NotepadActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton fab;
    Adapter adapter;
    List<Model> notesList;
    DatabaseNoteClass databaseNoteClass;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);

        recyclerView=findViewById(R.id.recycler_note_view);
        fab=findViewById(R.id.fab);
        coordinatorLayout = findViewById(R.id.layout_main);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(NotepadActivity.this, NoteAddActivity.class);
                startActivity(intent);
            }
        });

        notesList=new ArrayList<>();
        databaseNoteClass=new DatabaseNoteClass(this);
        fetchAllNotesFromDatabase();


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, NotepadActivity.this, notesList);
        recyclerView.setAdapter(adapter);


    }

    private void fetchAllNotesFromDatabase() {
        Cursor cursor = databaseNoteClass.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No Data to show", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                notesList.add(new Model(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.options_menu,menu);

        MenuItem searchIteam=menu.findItem(R.id.searchbar_note);
        SearchView searchView= (SearchView) searchIteam.getActionView();
        searchView.setQueryHint("Search Notes Here");

        SearchView.OnQueryTextListener listener=new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        };

        searchView.setOnQueryTextListener(listener);

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.delete_all_notes) {
            deleteAllNotes();
        }


        return super.onOptionsItemSelected(item);
    }

    private void deleteAllNotes() {
        DatabaseNoteClass db = new DatabaseNoteClass(NotepadActivity.this);
        db.deleteAllNotes();
        recreate();
    }

}

