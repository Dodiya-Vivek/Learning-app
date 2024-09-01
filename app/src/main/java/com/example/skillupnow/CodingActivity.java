package com.example.skillupnow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CodingActivity extends AppCompatActivity {

    private TextView introduction, clanguage, java, html, javascript, cpp, python;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coding);

        introduction = findViewById(R.id.introduction);
        introduction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/ToZSFHUJdHM?si=YNoU5c7PoRoeZnPK");
            }
        });

        clanguage = findViewById(R.id.clanguage);
        clanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/irqbmMNs2Bo?si=f8V3468eIIDmNTG5");
            }
        });

        cpp = findViewById(R.id.cpp);
        cpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/yGB9jhsEsr8?si=0CQjQlIqjs6q46yC");
            }
        });

        java = findViewById(R.id.java);
        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/UmnCZ7-9yDY?si=O_gBLwDB58Mw5F-B");
            }
        });

        html = findViewById(R.id.html);
        html.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/HcOc7P5BMi4?si=qluszOxV9T5pfah5");
            }
        });

        javascript = findViewById(R.id.javascript);
        javascript.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/VlPiVmYuoqw?si=ww7V6q_YwUbJdPiF");
            }
        });

        python = findViewById(R.id.python);
        python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/ERCMXc8x7mc?si=Cz2OkDZ0wCNhLDtt");
            }
        });
    }
    private void gotoUrl(String url) {
        Uri uri = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}