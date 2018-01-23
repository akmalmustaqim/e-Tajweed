package com.muza.e_tajweed;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class IdghamBiGhunnah extends AppCompatActivity {

    private TextView txtIdghamBiGhunnah;

    MediaPlayer mySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idgham_bi_ghunnah);

        txtIdghamBiGhunnah = (TextView)findViewById(R.id.txtDesc);
        txtIdghamBiGhunnah.setText("Ghunnah beerti dengung. Idgham Bi Ghunnah ialah huruf Nun mati ( نْ) dan Tanwin ( ً ٍ ٌ  ) bertemu dengan hurufnya disertai dengan bacaan dengung (2 harakat)");

        mySong = MediaPlayer.create(IdghamBiGhunnah.this,R.raw.idghambighunnah);
    }

    public void playIT(View v){
        mySong.start();
    }

    @Override
    protected void onPause(){
        super.onPause();
        mySong.release();
    }
}
