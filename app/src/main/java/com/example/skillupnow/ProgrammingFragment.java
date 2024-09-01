package com.example.skillupnow;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.fragment.app.Fragment;

public class ProgrammingFragment extends Fragment {

    private TextView text;

    TextView[] lectureTextViews = new TextView[7];
    String[] videoUrls = new String[7];

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_programming, container, false);

        // Initialize TextViews
        lectureTextViews[0] = rootView.findViewById(R.id.introduction);
        lectureTextViews[1] = rootView.findViewById(R.id.clanguage);
        lectureTextViews[2] = rootView.findViewById(R.id.cpp);
        lectureTextViews[3] = rootView.findViewById(R.id.java);
        lectureTextViews[4] = rootView.findViewById(R.id.html);
        lectureTextViews[5] = rootView.findViewById(R.id.javascript);
        lectureTextViews[6] = rootView.findViewById(R.id.python);

        // Set OnClickListener for each TextView
        for (int i = 0; i < lectureTextViews.length; i++) {
            final int index = i;
            lectureTextViews[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (videoUrls[index] != null && !videoUrls[index].isEmpty()) {
                        gotoUrl(videoUrls[index]);
                    }
                }
            });
        }

        // Set video URLs
        videoUrls[0] = "https://youtu.be/ToZSFHUJdHM?si=YNoU5c7PoRoeZnPK";
        videoUrls[1] = "https://youtu.be/irqbmMNs2Bo?si=f8V3468eIIDmNTG5";
        videoUrls[2] = "https://youtu.be/yGB9jhsEsr8?si=0CQjQlIqjs6q46yC";
        videoUrls[3] = "https://youtu.be/UmnCZ7-9yDY?si=O_gBLwDB58Mw5F-B";
        videoUrls[4] = "https://youtu.be/HcOc7P5BMi4?si=qluszOxV9T5pfah5";
        videoUrls[5] = "https://youtu.be/VlPiVmYuoqw?si=ww7V6q_YwUbJdPiF";
        videoUrls[6] = "https://youtu.be/ERCMXc8x7mc?si=Cz2OkDZ0wCNhLDtt";

        // Set up VideoView
        VideoView videoView = rootView.findViewById(R.id.video);
        MediaController mediaController = new MediaController(getActivity());
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse("android.resource://" + getActivity().getPackageName() + "/" + R.raw.coding));
        videoView.start();

        return rootView;
    }

    private void gotoUrl(String url) {
        Uri uri = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}
