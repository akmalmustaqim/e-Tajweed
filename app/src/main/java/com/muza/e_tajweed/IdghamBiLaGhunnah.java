package com.muza.e_tajweed;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class IdghamBiLaGhunnah extends AppCompatActivity {

    private TextView txtIdghamBiLaGhunnah;

    MediaPlayer mySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idgham_bi_la_ghunnah);

        txtIdghamBiLaGhunnah = (TextView)findViewById(R.id.txtDesc);

        txtIdghamBiLaGhunnah.setText("Idgham Bi La Ghunnah ialah memasukkan huruf Nun mati ( نْ) dan Tanwin ( ً ٍ ٌ  ) ke dalam hurufnya tanpa disertai dengan dengung.");

        mySong = MediaPlayer.create(IdghamBiLaGhunnah.this,R.raw.idghambilaghunnah);
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
