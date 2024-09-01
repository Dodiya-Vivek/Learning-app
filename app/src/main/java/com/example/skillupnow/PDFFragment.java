package com.example.skillupnow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.skillupnow.Adapters.PdfAdapter;
import com.example.skillupnow.ModelClass.PdfModel;

import java.util.ArrayList;

public class PDFFragment extends Fragment {

    private RecyclerView recyclerView;
    private PdfAdapter adapter;
    private ArrayList<PdfModel> pdfList;
    private ImageView pdfTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_p_d_f, container, false);


        recyclerView = rootView.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Sample data
        pdfList = new ArrayList<>();
        pdfList.add(new PdfModel(R.drawable.java_logo_vector_1, "Java Programming.pdf","https://www.tutorialspoint.com/java/java_tutorial.pdf"));
        pdfList.add(new PdfModel(R.drawable.html_svgrepo_com, "HTML Programming.pdf","https://www.tutorialspoint.com/html/html_tutorial.pdf"));
        pdfList.add(new PdfModel(R.drawable.python_svgrepo_com, "Python Programming.pdf","https://www.tutorialspoint.com/python/python_tutorial.pdf"));
        pdfList.add(new PdfModel(R.drawable.cpp3_svgrepo_com, "C++ Programming.pdf","https://www.tutorialspoint.com/cplusplus/cpp_tutorial.pdf"));
        pdfList.add(new PdfModel(R.drawable.jb_kotlin_svgrepo_com, "Kotlin Programming.pdf","https://www.tutorialspoint.com/kotlin/kotlin_tutorial.pdf"));
        pdfList.add(new PdfModel(R.drawable.javascript_svgrepo_com, "Javascript Programming.pdf","https://www.tutorialspoint.com/javascript/javascript_tutorial.pdf"));

        adapter = new PdfAdapter(pdfList, getContext());
        recyclerView.setAdapter(adapter);

        // Find TextView
       /* pdfTextView = rootView.findViewById(R.id.pdf);

        // Set OnClickListener for TextView
        pdfTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewpdf();
            }
        });

        return rootView;
    }

    private void viewpdf() {
        // Add the link of the PDF
        String pdfUrl = "https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(pdfUrl));*/

        // Start activity
        /*startActivity(intent);*/
        return rootView;
    }
}
