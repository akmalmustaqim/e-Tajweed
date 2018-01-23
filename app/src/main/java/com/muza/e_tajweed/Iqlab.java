package com.muza.e_tajweed;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Iqlab extends AppCompatActivity {

    private TextView txtIqlab;

    MediaPlayer mySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iqlab);

        txtIqlab = (TextView)findViewById(R.id.txtDesc);
        txtIqlab.setText("Iqlab ialah apabila huruf Nun mati ( نْ) dan Tanwin ( ً ٍ ٌ  ) bertemu huruf Baa( ب ). Bacaannya akan menjadikan huruf Nun mati ( نْ) dan Tanwin ( ً ٍ ٌ  ) menjadi seperti huruf Mim mati ( مْ ), kadar panjang bacaan ialah 2 harkat.");
        mySong = MediaPlayer.create(Iqlab.this,R.raw.iqlab);
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
