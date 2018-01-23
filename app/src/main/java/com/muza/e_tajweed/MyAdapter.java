package com.muza.e_tajweed;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by asus on 23/1/2018.
 */

public class MyAdapter extends ArrayAdapter<String> {

    String[] names;
    int[] pics;
    Context mContext;

    public MyAdapter(Context context, String[] recordNames, int[] pics) {
        super(context, R.layout.listview_item);
        this.names = recordNames;
        this.pics = pics;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) mContext.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listview_item, parent, false);
            mViewHolder.mPics = (ImageView) convertView.findViewById(R.id.imageView);
            mViewHolder.mName = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder)convertView.getTag();
        }
            mViewHolder.mPics.setImageResource(pics[position]);
            mViewHolder.mName.setText(names[position]);

        return convertView;
    }

    static class ViewHolder {
        ImageView mPics;
        TextView mName;
    }
}
