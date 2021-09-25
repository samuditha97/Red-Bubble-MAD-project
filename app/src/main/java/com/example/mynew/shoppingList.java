package com.example.mynew;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class shoppingList extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    static ListView listView;
    static ArrayList<String> items;
    static ListViewAdapter adapter;

    EditText input;
    ImageView enter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        /*------------------------Hooks------------------*/
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        /*----------------------ToolBar-------------------*/
        setSupportActionBar(toolbar);


        /*---------------------Navigation DrawerMenu-------------*/

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        /*-----------------shopping list view------------*/
        listView = findViewById(R.id.listview);
        input = findViewById(R.id.input);
        enter = findViewById(R.id.add);

        items = new ArrayList<>();
        items.add("Apple");
        items.add("Mango");
        items.add("Milk");
        items.add("Fish");
        items.add("Tomato");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = items.get(i);
                makeToast(name);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                makeToast("Removed: " + items.get(i));
                removeItem(i);
                return false;
            }
        });

        adapter = new ListViewAdapter(getApplicationContext(),items);
        listView.setAdapter(adapter);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = input.getText().toString();
                if(text == null || text.length() == 0){
                    makeToast("Enter an Item.");
                }else {
                    addItem(text);
                    input.setText("");
                    makeToast("Added: " + text);
                }
            }
        });
        loadContent();
    }

    //read the grocery list
    public void loadContent(){
        File path = getApplicationContext().getFilesDir();
        File readFrom = new File(path,"list.txt");
        byte[] content = new byte[(int) readFrom.length()];

        FileInputStream stream = null;
        try {
            stream = new FileInputStream(readFrom);
            stream.read(content);

            String s =new String(content);
            s = s.substring(1,s.length() - 1);
            String split[] = s.split(", ");
            items = new ArrayList<>(Arrays.asList(split));
            adapter = new ListViewAdapter(this,items);
            listView.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //save the grocery list
    @Override
    protected void onDestroy() {
        File path = getApplicationContext().getFilesDir();
        try {
            FileOutputStream writer = new FileOutputStream(new File(path,"list.txt"));
            writer.write(items.toString().getBytes());
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onDestroy();
    }

    public static void removeItem(int remove){
        items.remove(remove);
        listView.setAdapter(adapter);

    }


    public static void addItem(String item){
        items.add(item);
        listView.setAdapter(adapter);

    }

    Toast t;

    private void makeToast(String s){
        if (t != null) t.cancel();
        t = Toast.makeText(getApplicationContext(), s,Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }
}
