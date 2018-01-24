package com.muza.e_tajweed;

import android.support.v4.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.io.File;

/**
 * Created by asus on 22/1/2018.
 */

public class SenaraiRekodFrag extends Fragment {

    File file;

    ListView listView;

    String default_file_name = "default";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View myview = inflater.inflate(R.layout.fragsenarairekod,container,false);
        return myview;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String directory = Environment.getExternalStorageDirectory().getPath();

        file = new File( directory, "AudioRecorder/"+ default_file_name );
        if (!file.exists()) {
            file.mkdirs();
        }

        File list[] = file.listFiles();

        listView = (ListView) view.findViewById(R.id.fragment_player_list);


    }

}
