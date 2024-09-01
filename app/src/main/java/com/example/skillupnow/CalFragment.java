package com.example.skillupnow;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class CalFragment extends Fragment {

    ImageView imagebutton4, imagebutton6, imagebutton7;

    TextView python, java, excel, sql, javascript, digital, powerbi, aws, react, sap, c, photoshop;

    TextView development,marketing,finance,IT,search,design,lifestyle;

    String[] courseList = {"java", "python", "html", "c language", "cpp", "javascript", "php", "css", "dart", "node js", "digital marketing", "photoshop", "c#", "react", "excel"};


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_cal, container, false);


        python = rootView.findViewById(R.id.python);
        java = rootView.findViewById(R.id.java);
        excel = rootView.findViewById(R.id.excel);
        sql = rootView.findViewById(R.id.sql);
        javascript = rootView.findViewById(R.id.javascript);
        development = rootView.findViewById(R.id.development);
        marketing = rootView.findViewById(R.id.marketing);
        finance = rootView.findViewById(R.id.finance);
        IT = rootView.findViewById(R.id.IT);
        search = rootView.findViewById(R.id.search);
        design = rootView.findViewById(R.id.design);
        lifestyle = rootView.findViewById(R.id.lifestyle);
        /*digital = rootView.findViewById(R.id.digital);
        powerbi = rootView.findViewById(R.id.powerbi);
        aws = rootView.findViewById(R.id.aws);
        react = rootView.findViewById(R.id.react);
        sap = rootView.findViewById(R.id.sap);
        c = rootView.findViewById(R.id.c);
        photoshop = rootView.findViewById(R.id.photoshop);*/
        /*imagebutton4 = rootView.findViewById(R.id.imagebutton4);
        imagebutton6 = rootView.findViewById(R.id.imagebutton6);
        imagebutton7 = rootView.findViewById(R.id.imagebutton7);*/

       /* imagebutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomeFragment.class);
                startActivity(intent);
            }
        });

        imagebutton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button2 click
                // Example: Start an activity
                startActivity(new Intent(getActivity(), HomeFragment.class));
            }
        });

        imagebutton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProfileFragment.class);
                startActivity(intent);
            }
        });*/

        AutoCompleteTextView autoCompleteTextView = rootView.findViewById(R.id.search);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, courseList);

        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setThreshold(1);

        excel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),ExcelActivity.class);
                startActivity(intent);
            }
        });


        python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),PythonActivity.class);
                startActivity(intent);
            }
        });

        java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), JavaActivity.class);
                startActivity(intent);
            }
        });

        excel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ExcelActivity.class);
                startActivity(intent);
            }
        });

        sql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SqlActivity.class);
                startActivity(intent);
            }
        });


        development.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),PythonActivity.class);
                startActivity(intent);
            }
        });

        marketing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),JavaActivity.class);
                startActivity(intent);
            }
        });

        finance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),UiActivity.class);
                startActivity(intent);
            }
        });

        IT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),DigitalMarketingActivity.class);
                startActivity(intent);
            }
        });

        design.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),MGActivity.class);
                startActivity(intent);
            }
        });

        lifestyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),CodingActivity.class);
                startActivity(intent);
            }
        });






        // Set item click listener
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item
                String selectedItem = (String) parent.getItemAtPosition(position);

                // Perform navigation or action based on the selected item
                handleSelectedItem(selectedItem);
            }
        });


        return rootView;
    }

    private void handleSelectedItem(String selectedItem) {
        // Depending on the selected item, perform different actions
        switch (selectedItem.toLowerCase()) {
            case "java":
                startActivity(new Intent(getActivity(), JavaActivity.class));
                break;
            case "python":
                startActivity(new Intent(getActivity(), PythonActivity.class));
                break;
            case "excel":
                startActivity(new Intent(getActivity(), ExcelActivity.class));
                break;
            // Add more cases for other items as needed
            default:
                // Handle default case or unknown items
                break;
        }
    }

}
