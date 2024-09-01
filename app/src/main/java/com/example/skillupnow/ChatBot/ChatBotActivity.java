package com.example.skillupnow.ChatBot;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.skillupnow.R;

public class ChatBotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);

        EditText textInputEditText = findViewById(R.id.textInputLayout);
        ImageView button = findViewById(R.id.button);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        TextView textView = findViewById(R.id.textView2);
        TextView txt = findViewById(R.id.textView3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GeminiPro model = new GeminiPro();
                String query = textInputEditText.getText().toString();

                // Show the progress bar
                progressBar.setVisibility(View.VISIBLE);

                textView.setText("");
                textInputEditText.setText("");
                txt.setText("");

                model.getResponce(query, new ResponceCallback() {
                    @Override
                    public void onResponse(String response) {
                        txt.setText(response);
                        textView.setText(query);
                        progressBar.setVisibility(View.GONE);
                        textView.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onError(String throwable) {
                        Toast.makeText(ChatBotActivity.this, "Error: " + throwable, Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                    }
                });
            }
        });
    }
}
