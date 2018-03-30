package com.example.itachi.cds;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.itachi.cds.add_crime.add_crime_fragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView mTextMessage;
    FragmentManager fragmentManager;
    FloatingActionButton fab;
    private Handler mHandler = new Handler();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main_navigation_activity);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            fragmentManager =getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .replace(R.id.content,map_fragment.initalizeview(),"map_fragment")
                    .commit();

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);


            fab = (FloatingActionButton)findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            fab.hide();
                        }
                    }, 300);

                    fragmentManager.beginTransaction()
                            .replace(R.id.content, add_crime_fragment.initalizeview(),"addcrime_fragment")
                            .commit();
                }
            });


        }



        @Override
        public void onBackPressed() {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.main_menu, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if (id == R.id.sign_out_menu) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.navigation_home:
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fab.show();
                    }
                }, 300);

                fragmentManager.beginTransaction()
                        .replace(R.id.content,map_fragment.initalizeview(),"map_fragment")
                        .commit();
                break;

             case R.id.navigation_dashboard:

                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fab.hide();
                    }
                }, 300);

                fragmentManager.beginTransaction()
                        .replace(R.id.content,add_crime_fragment.initalizeview(),"addcrime_fragment")
                        .commit();
                 break;

            case R.id.navigation_notifications:

                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        fab.hide();
                    }
                }, 300);

                fragmentManager.beginTransaction()
                        .replace(R.id.content,profile_fragment.initalizeview(),"profile_fragment")
                        .commit();
                break;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
