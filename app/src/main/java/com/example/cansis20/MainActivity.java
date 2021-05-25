package com.example.cansis20;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import javax.security.auth.login.LoginException;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private Toolbar toolbar;
    private HomeFragment homeFragment;
    private TimeTableFragment timeTableFragment;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this,LoginPage.class));
            return;
        }


        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("CANSIS");
        setSupportActionBar(toolbar);

        timeTableFragment = new TimeTableFragment();
        homeFragment = new HomeFragment();
        if(savedInstanceState == null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_area, homeFragment);
            fragmentTransaction.commit();
        }












        bottomNavigationView = (BottomNavigationView) findViewById(R.id.botton_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId()) {
                    case R.id.website:

                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://canaraengineering.in"));
                        startActivity(intent);
                        return true;

                    case R.id.facebook:

                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/CanaraEngineeringCollege"));
                        startActivity(intent);
                        return true;
                    case R.id.youtube:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UC2DmUU0b59V5CKAJKfA0qsw"));
                        startActivity(intent);
                        return true;


                    case R.id.instagram:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/cecmangalore/"));
                        //intent = new Intent(MainActivity.this,ForgetPassword.class);
                        startActivity(intent);
                        return true;
                    case R.id.twitter:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/cecmangalore"));
                        startActivity(intent);
                        return true;

                    default:
                        return true;

                }
            }
        });


    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.tool_bar,menu);
//        return true;
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater  menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.tool_bar,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.home){

            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_area, homeFragment);
            fragmentTransaction.commit();


        }
        else if(item.getItemId()==R.id.contactus){
            startActivity(new Intent(this,ContactUs.class));
        }
        else if(item.getItemId()==R.id.signout){
            SharedPrefManager.getInstance(this).logout();
            finish();
            startActivity(new Intent(this,WelcomePage.class));
        }

        return true;
    }
}
