package com.example.skillupnow;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UiActivity extends AppCompatActivity {

    TextView[] lectures;

    // Array of URLs for lectures
    String[] lectureUrls = {
            "https://youtu.be/Y40J_DomBu4?si=JJMmytDRg1EUdbde",
            "https://youtu.be/cEt0bpMvAzM?si=J97Y-odTBHn5pZDf",
            "https://youtu.be/VRaveCBjxWQ?si=0oCAAM2olDFMRGzx",
            "https://youtu.be/iTztYyt2taw?si=l-YilJ_-NuzmvvKu",
            "https://youtu.be/7Ba7hI1yAqc?si=j58FiMRTXRiLEiLj",
            "https://youtu.be/A43tl50RWDQ?si=e-hEniocuE0Jfsi1",
            "https://youtu.be/64Jqj-5kI-4?si=n7SjiwgzzABLkF2x",
            "https://youtu.be/rtHptMWCGPc?si=yHIn8ns5cypR8r-1",
            "https://youtu.be/k1XM_FEQSLA?si=nnzuOem1EeruahFF",
            "https://youtu.be/FcB6tNXj7bk?si=E0wu-2dInBtJmLqq"
    };

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

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
