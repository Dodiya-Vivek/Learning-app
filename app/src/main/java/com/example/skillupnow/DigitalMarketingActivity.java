package com.example.skillupnow;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DigitalMarketingActivity extends AppCompatActivity {

    TextView[] lectures;

    // Array of URLs for lectures
    String[] lectureUrls = {
            "https://youtu.be/kvE8RJu8Vts?si=UbEh19o9wGGw6Qi1",
            "https://youtu.be/06d-h6LpBo8?si=ysmlAkPTWVULHOST",
            "https://youtu.be/PVAR-hONRFQ?si=FUtgugGVOsSCHpu1",
            "https://youtu.be/RzCWNFKkb1Q?si=O28HDpdI0yvCVnvh",
            "https://youtu.be/L6N9WnpU9Jc?si=D6FfjlvPV9U-N7rB",
            "https://youtu.be/-8h4SBv9EMg?si=p5XIYDgQGYmy8j50",
            "https://youtu.be/ImrOh6dxILo?si=Y12uklwFP3H1o4AI",
            "https://youtu.be/HRsPMaMQFpk?si=JbXE4ZvGk9YiEpUx",
            "https://youtu.be/WPqiU6HSBsU?si=qv_aD1EF4YFETKc6",
            "https://youtu.be/y1Vqk_8bUOk?si=4CSRkWSKsE07tw7d"
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_marketing);

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
