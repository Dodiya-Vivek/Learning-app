package com.example.skillupnow.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skillupnow.ModelClass.PdfModel;
import com.example.skillupnow.PdfViewerActivity;
import com.example.skillupnow.R;

import java.util.ArrayList;

public class PdfAdapter extends RecyclerView.Adapter<PdfAdapter.MyViewHolder> {

    private ArrayList<PdfModel> dataModels;
    private Context context;

    public PdfAdapter(ArrayList<PdfModel> dataModels, Context context) {
        this.dataModels = dataModels;
        this.context = context;
    }

    @NonNull
    @Override
    public PdfAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pdf_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PdfAdapter.MyViewHolder holder, int position) {
        PdfModel model = dataModels.get(position);
        holder.name.setText(model.getName());
        holder.image.setImageResource(model.getImage());
    }

    @Override
    public int getItemCount() {
        return dataModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);

            // Set the click listener for the entire item view
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                PdfModel model = dataModels.get(position);

                // Handle the item click event, for example, show a toast
                Toast.makeText(context, "Clicked: " + model.getName(), Toast.LENGTH_SHORT).show();

                // Here you can add code to handle the click event, such as opening a new activity or fragment
                 Intent intent = new Intent(context, PdfViewerActivity.class);
                 intent.putExtra("PDF_URL", model.getPdfUrl());
                 context.startActivity(intent);
            }
        }
    }
}
