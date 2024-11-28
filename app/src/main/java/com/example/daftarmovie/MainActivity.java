package com.example.daftarmovie;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Data gambar dan judul
        int[] images = {
                R.drawable.list1, R.drawable.list2, R.drawable.list3,
                R.drawable.list4, R.drawable.list5, R.drawable.list6
        };

        String[] titles = {
                "Sonic Boom", "Sonic 2013", "Sonic X 2003-2006",
                "Sonic the Hedgehog 2020", "Sonic the Hedgehog 2", "Sonic the Hedgehog 3"
        };

        // Setup RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);  // Deklarasi recyclerView

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3)); // Grid dengan 3 kolom
        GridAdapter adapter = new GridAdapter(this, images, titles);
        recyclerView.setAdapter(adapter);

        // Menambahkan GridSpacingItemDecoration untuk memberikan jarak antar item
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, 16, true));  // 2 kolom, spacing 16dp

        // Setup BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.nav_home) {
                Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show();
                return true;
            } else if (item.getItemId() == R.id.nav_favorites) {
                Toast.makeText(this, "Favorites clicked", Toast.LENGTH_SHORT).show();
                return true;
            } else if (item.getItemId() == R.id.nav_settings) {
                Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
                return true;
            } else {
                return false;
            }
        });
    }
}
