package com.example.loginn;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import com.codemybrainsout.ratingdialog.RatingDialog;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.openNavDrawer,
                R.string.closeNavDrawer
        );
        navigationView.bringToFront();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        if(savedInstanceState == null){
            navigationView.setCheckedItem(R.id.nav_home);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
            //Intent intent = new Intent(this,HomeFragment.class);
            //startActivity(intent);
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {




            case R.id.nav_home:
            {
                //Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                //Intent intent = new Intent(this,HomeFragment.class);
                //startActivity(intent);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();
                break;

            }
            case R.id.nav_profile:
            {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ProfileFragment()).commit();
                break;
            }
            case R.id.nav_contact:
            {
                //Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                //Intent intent = new Intent(this,ContactActivity.class);
                //startActivity(intent);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ContactFragment()).commit();
                break;
            }
            case R.id.nav_about:
            {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new About_AppFragment()).commit();
                break;
            }
            case R.id.nav_privacy:
            {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new PrivacyFragment()).commit();
                break;
            }
            case R.id.nav_setting:
            {
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new PrivacyFragment()).commit();
//                break;

                final RatingDialog ratingDialog = new RatingDialog.Builder(this)
                        .threshold(3)
                        .onRatingBarFormSumbit(new RatingDialog.Builder.RatingDialogFormListener() {
                            @Override
                            public void onFormSubmitted(String feedback) {

                            }
                        }).build();

                ratingDialog.show();
                break;
            }



            case R.id.nav_logout:
            {
                //Intent intent = new Intent(MainActivity.this,HomeActivity.class);
               // Intent intent = new Intent(this,MainActivity.class);
               // startActivity(intent);
                mAuth = FirebaseAuth.getInstance();
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                finish();





                break;
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }

//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//
//    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}