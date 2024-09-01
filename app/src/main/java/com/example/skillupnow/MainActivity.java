package com.example.skillupnow;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Timer timer;


    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE); // show the progress bar
        progressBar.setRotation(50); // set the progress to 50%
        ObjectAnimator animator = ObjectAnimator.ofFloat(progressBar, "rotation", 0f, 360f);
        animator.setDuration(1000); // set duration to 1 second
        animator.setRepeatCount(ObjectAnimator.INFINITE); // repeat animation indefinitely
        animator.start(); // start animation

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginPage.class);
                startActivity(intent);
            }
        } ,2000);
        //Intent intent = new Intent(MainActivity.this, SkipPage.class);
        //startActivity(intent);




    }
}