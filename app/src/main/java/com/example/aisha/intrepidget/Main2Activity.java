package com.example.aisha.intrepidget;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.setDrawerIndicatorEnabled(false);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //making the first fragment my default
        FirstFragment firstFragment = new FirstFragment();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.rel_layout_for_frag,
                firstFragment,
                firstFragment.getTag()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_language_right) {
            if (drawer.isDrawerOpen(Gravity.RIGHT))
            {
                drawer.closeDrawer(Gravity.RIGHT);
            }

            else{
                drawer.openDrawer(Gravity.RIGHT);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //opening new fragments for each of my app functionalities
        //also settingCustomAnimation here
        if (id == R.id.nav_planning) {
            FirstFragment firstFragment = new FirstFragment();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_slide_in_from_left,
                            R.anim.anim_slide_out_from_left)
                    .replace(R.id.rel_layout_for_frag,
                            firstFragment,
                            firstFragment.getTag()).commit();
        }

        else if (id == R.id.nav_expenses) {
            SecondFragment secondFragment = new SecondFragment();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_slide_in_from_left,
                            R.anim.anim_slide_out_from_left)
                    .replace(R.id.rel_layout_for_frag,
                            secondFragment,
                            secondFragment.getTag()).commit();
        }

        else if (id == R.id.nav_manage) {
            ThirdFragment thirdFragment = new ThirdFragment();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_slide_in_from_left,
                            R.anim.anim_slide_out_from_left)
                    .replace(R.id.rel_layout_for_frag,
                            thirdFragment,
                            thirdFragment.getTag()).commit();

        }

        else if (id == R.id.nav_bills) {
            FourthFragment fourthFragment = new FourthFragment();
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.anim_slide_in_from_left,
                            R.anim.anim_slide_out_from_left)
                    .replace(R.id.rel_layout_for_frag,
                            fourthFragment,
                            fourthFragment.getTag()).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.END);
        return true;
    }
}
