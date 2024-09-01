package com.example.skillupnow;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class JavaActivity extends AppCompatActivity {

    TextView[] lectures;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_java);
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
                findViewById(R.id.lec9),
                findViewById(R.id.lec10),
                // Add more lecture TextViews here as needed
        };

        // Array of URLs corresponding to each lecture
        final String[] lectureUrls = new String[]{
                "https://youtu.be/yRpLlJmRo2w?si=DCsowiHSJ43KShwg",
                "https://youtu.be/LusTv0RlnSU?si=m7sFZy36eVy6bl42",
                "https://youtu.be/I5srDu75h_M?si=loTdeGt_JmmQEHua",
                "https://youtu.be/0r1SfRoLuzU?si=ngvyv7Jyupn5E5Er",
                "https://youtu.be/GjHNGM7KN3w?si=V4pODqTYIfKQSjnx",
                "https://youtu.be/Dr4PpNa7AYo?si=W41lugAs_HVVh8He",
                "https://youtu.be/qcSz4ef9UHA?si=Kq6clpVgMFm8UEPZ",
                "https://youtu.be/pFPZ83mgH00?si=SwSYYp0TDyhpoER0",
                "https://youtu.be/bQssdSrSGNE?si=5Wkwl-864pT4JWeY",
                "https://youtu.be/NTHVTY6w2Co?si=mkT8ERUqbFONGm5c",
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
