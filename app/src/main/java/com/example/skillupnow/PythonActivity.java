package com.example.skillupnow;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PythonActivity extends AppCompatActivity {

    TextView[] lectures;
    ImageButton back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_python);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize TextView array with all lecture TextViews
        lectures = new TextView[]{
                findViewById(R.id.lec1),
                findViewById(R.id.lec2),
                findViewById(R.id.lec3),
                findViewById(R.id.lec4),
                findViewById(R.id.lec5),
                findViewById(R.id.lec6),
                findViewById(R.id.lec7),
                findViewById(R.id.lec8),
                findViewById(R.id.lec9)
                // Add more lecture TextViews here as needed
        };

        /*back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PythonActivity.this, SearchFragment.class);
                startActivity(intent);
            }
        });*/

        // Array of URLs corresponding to each lecture
        final String[] lectureUrls = new String[]{
                "https://youtu.be/t2_Q2BRzeEE?si=Tx5dni9Lx_IMuE0A",
                "https://youtu.be/lIId8IDP6TU?si=FXNdt2pEIY00fv1G",
                "https://youtu.be/qVyvmzFxF_o?si=5OuGkS2Ar7ztDVoR",
                "https://youtu.be/078tYSD7K8E?si=jS7b0FZwNc73I1qg",
                "https://youtu.be/S73thl0AyFU?si=-A7vfGz3prBUuQIq",
                "https://youtu.be/OvTH-7ESoRA?si=A_J0W4LFfmgGYJeS",
                "https://youtu.be/jU0cndZziO0?si=zDPasPFvF0t6DR_7",
                "https://youtu.be/HeW-D6KpDwY?si=_dwIVY56KRq2XPIB",
                "https://youtu.be/bAwmZVJeO5s?si=rVZqOFKX6tVFFpUY"
                // Add more URLs here as needed
        };

        // Set click listeners dynamically
        for (int i = 0; i < lectures.length; i++) {
            final int index = i;
            lectures[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gotoUrl(lectureUrls[index]);
                }
            });
        }
    }

    private void gotoUrl(String url) {
        Uri uri = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}
