package com.example.skillupnow;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SearchFragment extends Fragment {

    ImageView[] images = new ImageView[10];
    Toolbar tool;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        // Initialize image views
        images[0] = rootView.findViewById(R.id.image);
        images[1] = rootView.findViewById(R.id.image2);
        images[2] = rootView.findViewById(R.id.image3);
        images[3] = rootView.findViewById(R.id.image4);
        images[4] = rootView.findViewById(R.id.image5);
        images[5] = rootView.findViewById(R.id.image6);
        images[6] = rootView.findViewById(R.id.image7);
        images[7] = rootView.findViewById(R.id.image8);
        images[8] = rootView.findViewById(R.id.image9);
        images[9] = rootView.findViewById(R.id.image10);

        // Set click listeners for image views
        for (int i = 0; i < images.length; i++) {
            final int index = i;
            images[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = getImageUrl(index);
                    if (url != null && !url.isEmpty()) {
                        gotoUrl(url);
                    }
                }
            });
        }

        //back to activity
        tool = rootView.findViewById(R.id.tool);
        tool.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FragmentActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

    private String getImageUrl(int index) {
        switch (index) {
            case 0:
                return "https://youtu.be/3Tqd5x01o6w?si=sAVJjijH5T7HjNJD";
            case 1:
                return "https://youtu.be/IvlaCyFmJWk?si=pTF9mCm3a8KSf_Cu";
            case 2:
                return null; // No URL provided for image3
            case 3:
                return "https://youtu.be/UmnCZ7-9yDY?si=O_gBLwDB58Mw5F-B";
            case 4:
                return "https://youtu.be/9zkboH6PIjE?si=u6jbojpDLtRE3DOF";
            case 5:
                return "https://youtu.be/HcOc7P5BMi4?si=DLtkGwSDdvX7Q94M";
            case 6:
                return "https://youtu.be/qvQie2QP5Vg?si=mdDZjyN9Sd5d-i_G";
            case 7:
                return "https://youtu.be/gVDdOucyZrk?si=Sy0uHuWa6cGOTegb";
            case 8:
                return "https://youtu.be/ERCMXc8x7mc?si=pDnThv2SjCaZ5sZJ";
            case 9:
                return "https://youtu.be/3RTqLQ1MaQU?si=x-enrPvh6IE9j9Xv";
            default:
                return null;
        }
    }

    private void gotoUrl(String url) {
        Uri uri = Uri.parse(url);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}
