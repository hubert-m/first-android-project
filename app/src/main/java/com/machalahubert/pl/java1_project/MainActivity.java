package com.machalahubert.pl.java1_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();


        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_home()).commit();
            navigationView.setCheckedItem(R.id.home_frag);
        }
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch(menuItem.getItemId()) {
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_home()).commit();
                break;
            case R.id.settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_settings()).commit();
                break;



            case R.id.tools_nwd:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_tools_nwd()).commit();
                break;

            case R.id.tools_calc:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_tools_calc()).commit();
                break;

            case R.id.tools_pesel:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_tools_pesel()).commit();
                break;

            case R.id.others_calendar:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_others_calendar()).commit();
                break;


            case R.id.about_author:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_about_author()).commit();
                break;

            case R.id.author_site:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Fragment_author_site()).commit();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }


}
