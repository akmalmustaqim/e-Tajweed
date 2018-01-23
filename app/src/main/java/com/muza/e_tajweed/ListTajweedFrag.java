package com.muza.e_tajweed;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by asus on 22/1/2018.
 */

public class ListTajweedFrag extends Fragment {

    public ImageButton btnIzhar, btnIkhfa,btnIdgham, btnIqlab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View myview = inflater.inflate(R.layout.fraglistajweed,container,false);

        //content

         btnIzhar = (ImageButton) myview.findViewById(R.id.btnIzhar);
         btnIdgham = (ImageButton) myview.findViewById(R.id.btnIdgham);
         btnIkhfa = (ImageButton) myview.findViewById(R.id.btnikhfa);
         btnIqlab = (ImageButton) myview.findViewById(R.id.btnIqlab);

        btnIzhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ListTajweedFrag.this.getActivity(), Izhar.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(myIntent);
            }
        });

        btnIdgham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ListTajweedFrag.this.getActivity(), IdghamBiGhunnah.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(myIntent);
            }
        });

        btnIkhfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ListTajweedFrag.this.getActivity(), Ikhfak.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(myIntent);
            }
        });

        btnIqlab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ListTajweedFrag.this.getActivity(), Iqlab.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(myIntent);
            }
        });

        return myview;

    }
}
