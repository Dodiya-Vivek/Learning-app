package com.example.skillupnow;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.skillupnow.ChatBot.ChatBotActivity;
import com.example.skillupnow.Quiz.QuizActivity;

public class HomeFragment extends Fragment {

    TextView text4,text2;
    ImageView imageView, image6, image7, imageView2,imagebutton;
    FragmentActivity fragmentActivity;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);


        fragmentActivity = (FragmentActivity) getActivity();

        TextView textView = rootView.findViewById(R.id.text2);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QuizActivity.class);
                startActivity(intent);
            }
        });

        if (fragmentActivity == null) {
            Log.e("HomeFragment", "MainActivity is null");
            return rootView;
        }


        imageView = rootView.findViewById(R.id.image4);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentActivity.navigateToUiCaourseFragment();
            }
        });

        image6 = rootView.findViewById(R.id.image6);
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentActivity.navigateToDigitalFragment();
            }
        });

        image7 = rootView.findViewById(R.id.image7);
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                fragmentActivity.navigateToMotionGraphicsFragment();
            }
        });

       /* imageView2 = rootView.findViewById(R.id.imageView2);
        Log.d("TAG_vv", "onCreateView: ");
        if (imageView2 == null) {
            Log.e("HomeFragment", "imageView2 is null");
        } else {
            // Set click listener for imageView2
            imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (fragmentActivity != null) {
                        fragmentActivity.navigateToProgramming3();
                    } else {
                        Log.e("HomeFragment", "MainActivity is null");
                    }
                }
            });
        }*/

        imageView2 = rootView.findViewById(R.id.imageView2);
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (fragmentActivity != null) {
                        fragmentActivity.navigateToProgramming3();
                    } else {
                        Log.e("HomeFragment", "MainActivity is null");
                    }
                }
            });
        } else {
            Log.e("HomeFragment", "imageView2 is null");
        }

        //see all click
        text4 = rootView.findViewById(R.id.text4);
        text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentActivity.navigateToSearchFragment();
            }
        });

        imagebutton = rootView.findViewById(R.id.imagebutton);
        imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChatBotActivity.class);
                startActivity(intent);
            }
        });

        /*imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentActivity.navigateToCalFragment();
            }
        });*/

        return rootView;
    }
}
