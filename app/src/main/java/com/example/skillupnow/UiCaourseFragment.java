package com.example.skillupnow;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;

public class UiCaourseFragment extends Fragment {

    private TextView text;
    private TextView[] topics;
    private VideoView videoView;

    // Array of URLs for each topic
    private String[] topicUrls = {
            "https://youtu.be/c8TYIuIhlto?si=uwxcg39bL3F8iS6y", // Introduction
            "https://youtu.be/FxZFKSgpeBc?si=SMpkdkopV1eh7Ixh", // Get Started
            "https://youtu.be/-mbYAj5hvLs?si=dRORZQXA6Jl9UTp", // Web Design
            "https://youtu.be/UuJzb2iju6Q?si=Tr2IEAh3CTMV648n", // Icon
            "https://youtu.be/G6Sa2NDeRYk?si=8-EjEHqHD0HsZ20c", // Game
            "https://youtu.be/M0JRk9LPOq4?si=NEGNvSxhFTAXJena", // Modern
            "https://youtu.be/FxZFKSgpeBc?si=6-9Z4HwgC-7BgSN9", // UI
            "https://youtu.be/7eFdYMl63KM?si=HJq5ZLNXXcTBM6i6", // Tips
            "https://youtu.be/0-elxjeIgRo?si=tnUA8qARFXEIW20h", // Tips2
            "https://youtu.be/1gBqXHCS4l8?si=2mzGsxM4Mra3e7Vr", // Web
            "https://youtu.be/lYAk5ebCg3g?si=oSlHOpZM-uPyA-wS"  // Web2
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_ui_caourse, container, false);

        videoView = rootView.findViewById(R.id.video);

        String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.video;
        videoView.setVideoURI(Uri.parse(videoPath));
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // Restart the video
                videoView.start();
            }
        });

        text = rootView.findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        // Initialize TextView array with IDs
        topics = new TextView[]{
                rootView.findViewById(R.id.intro),
                rootView.findViewById(R.id.getstarted),
                rootView.findViewById(R.id.webdesign),
                rootView.findViewById(R.id.icon),
                rootView.findViewById(R.id.game),
                rootView.findViewById(R.id.morden),
                rootView.findViewById(R.id.ui),
                rootView.findViewById(R.id.tips),
                rootView.findViewById(R.id.tips2),
                rootView.findViewById(R.id.web),
                rootView.findViewById(R.id.web2)
        };

        // Set OnClickListener for each topic TextView
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
