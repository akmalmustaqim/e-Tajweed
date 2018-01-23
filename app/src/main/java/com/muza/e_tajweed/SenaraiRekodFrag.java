package com.muza.e_tajweed;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by asus on 22/1/2018.
 */

public class SenaraiRekodFrag extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View myview = inflater.inflate(R.layout.fragsenarairekod,container,false);
        return myview;
    }
}
