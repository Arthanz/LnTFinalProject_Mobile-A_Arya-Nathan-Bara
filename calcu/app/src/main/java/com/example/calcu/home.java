package com.example.calcu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class home extends AppCompatActivity {
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    PagerAdapter pagerAdapter;


    Button plus, less, reset;
    TextView counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize ViewPager2 and TabLayout
        viewPager2 = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.tablayout);
        // Set up ViewPager2 with PagerAdapter
        setViewPager2(viewPager2);

        // Attach TabLayoutMediator to connect TabLayout and ViewPager2
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> tab.setText(pagerAdapter.getPageTitle(position))).attach();

        // Initialize plus button
        plus = findViewById(R.id.bt_plusplus);

    }

    // Inflate the options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.listmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // Handle menu item clicks
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int menu = item.getItemId();
        switch(menu) {
            case R.id.logout:
                startActivity(new Intent(home.this, MainActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // Set up the ViewPager2 with PagerAdapter
    public void setViewPager2 (ViewPager2 viewPager2) {
        if (pagerAdapter == null) {
            // Add three fragments to the PagerAdapter
            pagerAdapter = new PagerAdapter(this);
            pagerAdapter.addFragment(new Fragment1(), "Counter");
            pagerAdapter.addFragment(new Fragment2(), "Luas");
            pagerAdapter.addFragment(new Fragment3(), "Volume");
            // Set the adapter for the ViewPager2
            viewPager2.setAdapter(pagerAdapter);
        }
    }
}