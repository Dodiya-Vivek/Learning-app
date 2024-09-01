package com.example.skillupnow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SqlActivity extends AppCompatActivity {

    TextView[] lectures = new TextView[10];
    String[] urls = new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);

        // Initialize TextViews array
        lectures[0] = findViewById(R.id.lec1);
        lectures[1] = findViewById(R.id.lec2);
        lectures[2] = findViewById(R.id.lec3);
        lectures[3] = findViewById(R.id.lec4);
        lectures[4] = findViewById(R.id.lec5);
        lectures[5] = findViewById(R.id.lec6);
        lectures[6] = findViewById(R.id.lec7);
        lectures[7] = findViewById(R.id.lec8);
        lectures[8] = findViewById(R.id.lec9);
        lectures[9] = findViewById(R.id.lec10);

        // Initialize URLs array
        urls[0] = "https://youtu.be/3TLe71EkPjE?si=YXn-QbX2sa2pR24n";
        urls[1] = "https://youtu.be/s2EGAzcdK1c?si=BN1o2hzdj8-RZ3Th";
        urls[2] = ""; // No URL provided
        urls[3] = "https://youtu.be/BjfqKK24Ruk?si=ovitlkqixKEpVvzg";
        urls[4] = "https://youtu.be/05j8ZFWYkMU?si=Pi5HgI6j8CQld9Xg";
        urls[5] = "https://youtu.be/lCW0kDR89dI?si=0H-KDhpSwfYa7qKR";
        urls[6] = "https://youtu.be/XdWx8sBg04g?si=GTA812Iw_RRpnmbW";
        urls[7] = "https://youtu.be/OXL7Q4TK8fI?si=tGib47YgmE9HKyrJ";
        urls[8] = "https://youtu.be/UoMnodDXo4A?si=-wgxxuKZw4p7JVQ_";
        urls[9] = "https://youtu.be/hL6FcahafIU?si=8UZp6cpLUL5jkOv1";

        // Set click listeners for each lecture TextView
        for (int i = 0; i < lectures.length; i++) {
            final int index = i;
            lectures[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!urls[index].isEmpty()) {
                        gotoUrl(urls[index]);
                    }
                }
            });
        }
    }

    private void gotoUrl(String url) {
        Uri uri = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}
