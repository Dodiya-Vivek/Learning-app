package com.example.skillupnow;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.fragment.app.Fragment;

public class Programming3 extends Fragment {

    private TextView text;
    private TextView[] topics;
    private VideoView videoView;

    // Array of URLs for programming topics
    private String[] topicUrls = {
            "https://youtu.be/ToZSFHUJdHM?si=YNoU5c7PoRoeZnPK", // Introduction
            "https://youtu.be/irqbmMNs2Bo?si=f8V3468eIIDmNTG5", // C Language
            "https://youtu.be/yGB9jhsEsr8?si=0CQjQlIqjs6q46yC", // C++
            "https://youtu.be/UmnCZ7-9yDY?si=O_gBLwDB58Mw5F-B", // Java
            "https://youtu.be/HcOc7P5BMi4?si=qluszOxV9T5pfah5", // HTML
            "https://youtu.be/VlPiVmYuoqw?si=ww7V6q_YwUbJdPiF", // JavaScript
            "https://youtu.be/ERCMXc8x7mc?si=Cz2OkDZ0wCNhLDtt"  // Python
    };

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_programming3, container, false);

        videoView = rootView.findViewById(R.id.video);
        String videoPath = "android.resource://" + requireActivity().getPackageName() + "/" + R.raw.coding;
        videoView.setVideoURI(Uri.parse(videoPath));
        videoView.start();

        /*text = rootView.findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Do something when text is clicked
            }
        });*/

        // Initialize TextView array with IDs
        topics = new TextView[]{
                rootView.findViewById(R.id.introduction),
                rootView.findViewById(R.id.clanguage),
                rootView.findViewById(R.id.cpp),
                rootView.findViewById(R.id.java),
                rootView.findViewById(R.id.html),
                rootView.findViewById(R.id.javascript),
                rootView.findViewById(R.id.python)
        };

        // Set OnClickListener for each TextView
        for (int i = 0; i < topics.length; i++) {
            final int index = i;
            topics[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gotoUrl(topicUrls[index]);
                }
            });
        }

        return rootView;
    }

    private void gotoUrl(String url) {
        Uri uri = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}
