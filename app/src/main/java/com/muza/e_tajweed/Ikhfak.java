package com.muza.e_tajweed;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Ikhfak extends AppCompatActivity {

    private TextView txtIkhfak;

    private MediaPlayer mySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikhfak);

        txtIkhfak = (TextView)findViewById(R.id.txtDesc);

        txtIkhfak.setText("Ikhfa' bermaksud 'sembunyi'. Ia terjadi apabila huruf Nun mati ( نْ) dan Tanwin ( ً ٍ ٌ  ) bertemu dengan huruf Ikhfa' dengan menyembunyikan sebutan nun sakinah di antara sebutan izhar dan idgham; tanpa sabdu berserta dengung pada huruf yang pertama.");

        mySong = MediaPlayer.create(Ikhfak.this,R.raw.ikhfak);
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
