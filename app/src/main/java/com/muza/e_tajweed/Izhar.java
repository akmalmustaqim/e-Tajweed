package com.muza.e_tajweed;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Izhar extends AppCompatActivity {

    private TextView textIzhar;
    private Button btnRecord;
    private ImageButton btnPlay;

    MediaPlayer mySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragizhar);

        textIzhar = (TextView)findViewById(R.id.txtDesc);

        textIzhar.setText("Izhar ialah membaca huruf Nun mati ( نْ) dan Tanwin ( ً ٍ ٌ  ) yang bertemu dengan huruf Izhar dengan bacaan jelas, terang, dan tanpa dengung ( tanpa harkat ).");

        btnPlay = (ImageButton)findViewById(R.id.btnPlay);
        btnRecord = (Button) findViewById(R.id.btnRecord);

        mySong = MediaPlayer.create(Izhar.this,R.raw.izhar);

        btnRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Izhar.this, recording.class);
                myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(myIntent);
            }
        });
    }

    public void playIT(View v) {
        mySong.start();
    }

    @Override
    public void onPause() {
        super.onPause();
        mySong.release();
    }
}
