package com.example.skillupnow;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PdfViewerActivity extends AppCompatActivity {

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);

        Intent intent = getIntent();
        String pdfUrl = intent.getStringExtra("PDF_URL");

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PdfViewerActivity.this,HomeFragment.class);
                startActivity(intent);
            }
        });

        if (pdfUrl != null) {
            Intent viewIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(pdfUrl));
            startActivity(viewIntent);
        }
    }
}
