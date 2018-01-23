package com.muza.e_tajweed;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;

import static com.muza.e_tajweed.R.id.editRecordName;

public class recording extends AppCompatActivity {

    private TextView mRecordLabel;
    private ImageButton mRecordBtn,btnRecord;
    private Button btnPlay, btnSubmit;

    private EditText editRecordName;

    private MediaRecorder mRecorder;

    private String mFileName = "Default";

    private static final String LOG_TAG = "Record_log";

    private StorageReference mStorage;

    private ProgressDialog mProgress;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording2);

        btnPlay = (Button)findViewById(R.id.btnPlay);
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnRecord = (ImageButton) findViewById(R.id.btnRecord);
        editRecordName = (EditText)findViewById(R.id.editRecordName);

        mProgress = new ProgressDialog(this);

        mRecordBtn = (ImageButton) findViewById(R.id.btnRecord);
        mRecordLabel = (TextView) findViewById(R.id.lblRecord);

        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        //mFileName += "/" + editRecordName.getText().toString() +".3gp";
        mFileName += "/temporary_audio.3gp";
        //mFileName += editRecordName.getText().toString();

        mStorage = FirebaseStorage.getInstance().getReference();




        mRecordBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){

                    startRecording();

                    mRecordLabel.setText("Recording started...");
                }
                else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {

                    stopRecording();
                    mRecordLabel.setText("Recording stopped...");
                }

                return false;
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = new MediaPlayer();
                try {

                    mediaPlayer.setDataSource(mFileName);
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mediaPlayer.start();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadAudio();
            }
        });


    }

    private void startRecording() {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

        mRecorder.start();
    }

    private void stopRecording() {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;

    }

    private void uploadAudio() {

        mProgress.setMessage("Uploading...");
        mProgress.show();

        StorageReference filepath = mStorage.child("Audio").child(editRecordName.getText().toString());

        Uri uri = Uri.fromFile(new File(mFileName));

        filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                mProgress.dismiss();

                mRecordLabel.setText("Uploading Finished");
            }
        });

        //download
        StorageReference down = mStorage.child("Audio").child(editRecordName.getText().toString());
        try {
            File localFile  = new File(Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOWNLOADS), down.getName()+".3gp");
            localFile .createNewFile();
            filepath.getFile(localFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
