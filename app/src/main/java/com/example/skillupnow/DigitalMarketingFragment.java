package com.example.skillupnow;

import android.annotation.SuppressLint;
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

public class DigitalMarketingFragment extends Fragment {


    private TextView text;

    private TextView intro,video1,video2,video3,video4,video5,video6,video7,video8,video9,video10,video11,video12,video13,video14,video15,video16,video17,video18,video19;
    VideoView videoView;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_digital_marketing, container, false);

        videoView = rootView.findViewById(R.id.video);

        String videoPath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.digital_marketing;
        videoView.setVideoURI(Uri.parse(videoPath));

        VideoView videoView = rootView.findViewById(R.id.video);

        String videopath = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.digital_marketing;
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

        intro = rootView.findViewById(R.id.intro);
        intro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/3Tqd5x01o6w?si=sAVJjijH5T7HjNJD");
            }
        });

        video1 = rootView.findViewById(R.id.video1);
        video1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/-XDuoU18uyU?si=CiuotVGLG5XDeN20");
            }
        });

        video2 = rootView.findViewById(R.id.video2);
        video2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/9OioSZ6OhU8?si=Sz4L5TWu-z0IIoJS");
            }
        });

        video3 = rootView.findViewById(R.id.video3);
        video3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/ZiofSsam4WY?si=c617hAX0JLqrdXBn");
            }
        });

        video4 = rootView.findViewById(R.id.video4);
        video4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/xhAVmZ4_SIk?si=FjtK6-_MyOwmOglV");
            }
        });

        video5 = rootView.findViewById(R.id.video5);
        video5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/G1jzPJqe4sY?si=MbvWOIGN_QCE23cV");
            }
        });

        video6 = rootView.findViewById(R.id.video6);
        video6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/hY9vfWbTruI?si=XvMl29jUdMX47cfg");
            }
        });

        video7 = rootView.findViewById(R.id.video7);
        video7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/1xioCMOO9bQ?si=Hg2uBBhMEcCOWP14");
            }
        });

        video8 = rootView.findViewById(R.id.video8);
        video8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/1xioCMOO9bQ?si=Hg2uBBhMEcCOWP14");
            }
        });

        video9 = rootView.findViewById(R.id.video9);
        video9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/n_fiwS6KIW8?si=fQmVBbg5kdJj9rwG");
            }
        });

        video10 = rootView.findViewById(R.id.video10);
        video10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/n_fiwS6KIW8?si=EDhxdmqnWz0U4rfW");
            }
        });

        video11 = rootView.findViewById(R.id.video11);
        video11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/d4kggfpSiIU?si=-5hfsdlEnrxX9t9C");
            }
        });

        video12 = rootView.findViewById(R.id.video12);
        video12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/btA3iqdp1rQ?si=Hkz9fQ22ilveoB-s");
            }
        });

        video13 = rootView.findViewById(R.id.video13);
        video13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/S_cmgzmXtTA?si=INrbGi9jNnZG7I2N");
            }
        });

        video14 = rootView.findViewById(R.id.video14);
        video14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/XRB2OyqxxJU?si=cpJCWt0JQ39BDF8N");
            }
        });

        video15 = rootView.findViewById(R.id.video15);
        video15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/sGp1YtgtE64?si=R5sVxZiWbg0gKACK");
            }
        });

        video16 = rootView.findViewById(R.id.video16);
        video16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/11uCpKF32gw?si=QbmAXmuqjQ6qUvz_");
            }
        });

        video17 = rootView.findViewById(R.id.video17);
        video17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/TEzNmlIlT_o?si=-9towZJ3xO-ggT7L");
            }
        });

        video18 = rootView.findViewById(R.id.video18);
        video18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/ZMGdAC6jBdo?si=VIpeojn5cxbFzFBi");
            }
        });

        video19 = rootView.findViewById(R.id.video19);
        video19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://youtu.be/HryY_J1ii68?si=TRKR8jA9NGtvJU0d");
            }
        });

        return rootView;
    }
    private void gotoUrl(String s) {

        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}