package com.example.skillupnow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SkipPage2 extends AppCompatActivity {

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip_page2);

        button = findViewById(R.id.skip);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SkipPage2.this,GetStartedPage.class);
                startActivity(intent);
            }
        });
    }
}