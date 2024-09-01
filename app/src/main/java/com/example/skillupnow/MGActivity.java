package com.example.skillupnow;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MGActivity extends AppCompatActivity {

    TextView[] lectures;

    // Array of URLs for lectures
    String[] lectureUrls = {
            "https://youtu.be/9ZHfUf35GbA?si=sOGoGcHyvvdfJhGR",
            "https://youtu.be/pS30fWwfYMs?si=GvYJFcYGPS2uIwPE",
            "https://youtu.be/8XWBgvT5kfg?si=ep4f_ugybH3b6VnR",
            "https://youtu.be/PhB5q_4x79I?si=20kC5U4LoUA3S664",
            "https://youtu.be/XPQxoAgTRtM?si=GNj2QgVGTbmyeYQa",
            "https://youtu.be/NU-vq7xAND4?si=fUtqKs72m_hSAOX8",
            "https://youtu.be/K2qw6SpIEw8?si=aTONB0lTZC41VOy6",
            "https://youtu.be/_4jBSxW2ClQ?si=yWB0VMhfp2ghKzwg",
            "https://youtu.be/0AE_BtrAcRI?si=gz7PQiHF7bUpwF7t",
            "https://youtu.be/7ra4RW5V2y0?si=rTxqkNuK6sWXwoYO"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mgactivity);

        // Initialize TextView array with IDs
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
                findViewById(R.id.lec10)
        };

        // Set OnClickListener for each TextView
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
