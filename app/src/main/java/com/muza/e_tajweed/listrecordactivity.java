package com.muza.e_tajweed;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class listrecordactivity extends AppCompatActivity {

    ListView mListView;

    private String mFileName = "Default";

    String[] recordNames = {""};
    final int[] pics = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listrecordactivity);

        mListView = (ListView)findViewById(R.id.listview);

        MyAdapter myAdapter = new MyAdapter(listrecordactivity.this, recordNames, pics);
        mListView.setAdapter(myAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}
