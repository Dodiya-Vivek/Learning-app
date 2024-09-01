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

public class MotionGraphicsFragment extends Fragment {

    private VideoView videoView;
    private TextView[] videos;

    // Array of URLs for videos
    private String[] videoUrls = {
            "https://youtu.be/dWMawjnDyvY?si=_LUSIkNw6P84XTom",
            "https://youtu.be/yYVLVSSDuIE?si=PKQ1gaY0dmvsQYyL",
            "https://youtu.be/-k3K5jM7Z24?si=Z23hP01FD1qYvydZ",
            "https://youtu.be/EzcbgtJHSpA?si=ILEUXuX6HdxqxZE7",
            "https://youtu.be/MvwdI3OXukI?si=UWZttmJFdL30hn63",
            "https://youtu.be/7bKks6HHH9s?si=0Yh4dh2k9Zj0vuGB",
            "https://youtu.be/qgX91IddR8A?si=x_B8OB2TxDC8IMcy",
            "https://youtu.be/c1-IIsfjRkY?si=8UpgrYihOtM-nOtW",
            "https://youtu.be/P7-vQ30vD98?si=8TlPy-ikNvrQZ6a2",
            "https://youtu.be/IZmdZPHBR34?si=chyPHKPj0H-3-EwV",
            "https://youtu.be/JCmAUHrncjo?si=HvNTkPlPSW_05YYR",
            "https://youtu.be/W_h1WBZI1Fo?si=ZY_TRW7fPfqDanwb",
            "https://youtu.be/VDVQrw7570Q?si=fWbti0GklvjlxJiV",
            "https://youtu.be/dwTAq6OdKX0?si=BS4_B8OLZxms_cDK",
            "https://youtu.be/Vg98Xk_hL1E?si=6OmlUB0fOdlnwlFh",
            "https://youtu.be/E-XAFUTmyzE?si=Pz0Q9AcxK0-9hGoN",
            "https://youtu.be/ipUElEARsqw?si=p0SWuN71O2UlfhuW",
            "https://youtu.be/379iWBKIDcQ?si=feC7gaj2xn1iFAyd",
            "https://youtu.be/8rM-d6GZ2fY?si=piSNTAWU-fYmwPcM",
            "https://youtu.be/IczIqYIMEzY?si=TiWeVsjXTp1MxOWn",
            "https://youtu.be/aJvn3FaabNI?si=14B_PlNB_iBB4ajl",
            "https://youtu.be/iZUfBJeZNnA?si=ZKbHko6rWSMO8CQI",
            "https://youtu.be/WBk_Fq3Mjj4?si=PW3MtcCHX6_Au7Go"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_motion_graphics, container, false);

        videoView = rootView.findViewById(R.id.video);

        String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.motion2;
        videoView.setVideoURI(Uri.parse(videoPath));
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // Restart the video
                videoView.start();
            }
        });

        // Initialize TextView array with IDs
        videos = new TextView[]{
                rootView.findViewById(R.id.intro),
                rootView.findViewById(R.id.video1),
                rootView.findViewById(R.id.video2),
                rootView.findViewById(R.id.video3),
                rootView.findViewById(R.id.video4),
                rootView.findViewById(R.id.video5),
                rootView.findViewById(R.id.video6),
                rootView.findViewById(R.id.video7),
                rootView.findViewById(R.id.video8),
                rootView.findViewById(R.id.video9),
                rootView.findViewById(R.id.video10),
                rootView.findViewById(R.id.video11),
                rootView.findViewById(R.id.video12),
                rootView.findViewById(R.id.video13),
                rootView.findViewById(R.id.video14),
                rootView.findViewById(R.id.video15),
                rootView.findViewById(R.id.video16),
                rootView.findViewById(R.id.video17),
                rootView.findViewById(R.id.video18),
                rootView.findViewById(R.id.video19),
                rootView.findViewById(R.id.video20),
                rootView.findViewById(R.id.video21),
                rootView.findViewById(R.id.video22)
                // Add more TextViews if needed
        };

        // Set OnClickListener for each TextView
        for (int i = 0; i < videos.length; i++) {
            final int index = i;
            videos[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    gotoUrl(videoUrls[index]);
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
