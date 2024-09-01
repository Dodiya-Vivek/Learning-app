package com.example.skillupnow;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ExcelActivity extends AppCompatActivity {

    TextView[] lectures;
    ImageButton back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excel);

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
                findViewById(R.id.lec9),
                findViewById(R.id.lec10),
                // Add more lecture TextViews here as needed
        };

        /*back = findViewById(R.id.tool);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExcelActivity.this,CalFragment.class);
                startActivity(intent);
            }
        });*/

        // Array of URLs corresponding to each lecture
        final String[] lectureUrls = new String[]{
                "https://youtu.be/16fZZXexZuE?si=632dakYqOVkZGNxW",
                "https://youtu.be/dt8g0uAy0cE?si=szd9WnZZrTicDvDJ",
                "https://youtu.be/dyl91P37P1Y?si=vjQwhliNUhKWgjUN",
                "https://youtu.be/Qb5AqDIlkog?si=tMj490zbrsuLZlr3",
                "https://youtu.be/z-1BJw6iebg?si=_8PFWbmu8HuNgOem",
                "https://youtu.be/xZa8XWty_4o?si=Xa2_wFamdpb2Pmic",
                "https://youtu.be/XWztQ4YeULw?si=j_VIjLi3Pp3RxL3L",
                "https://youtu.be/DD7W8L2c8xA?si=jP6OmJhNVuj5xY4G",
                "https://youtu.be/GjJc99lWcvM?si=Ude_ee9LKDMqbXZL",
                "https://youtu.be/MczRtqZRYKk?si=zADPhRMSGfBVcNwb"
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
