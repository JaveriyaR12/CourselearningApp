package com.example.course_learning;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ArtsBaseAdapter extends BaseAdapter {
    Context context;
    String listArts[];
    int listImages[];
    LayoutInflater inflater;
    public ArtsBaseAdapter(Context ctx, String[] SoftwareList,int[] images){
        this.context = ctx;
        this.listArts = SoftwareList;
        this.listImages = images;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return listArts.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_softwarelistview,null);
        TextView txtView = (TextView) convertView.findViewById(R.id.textview1);
        ImageView SoftwareImg = (ImageView) convertView.findViewById(R.id.image1);
        txtView.setText((listArts[position]));
        SoftwareImg.setImageResource(listImages[position]);
        return convertView;
    }
}
