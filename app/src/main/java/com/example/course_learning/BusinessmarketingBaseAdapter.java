package com.example.course_learning;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BusinessmarketingBaseAdapter extends BaseAdapter {

    Context context;
    String listBusiness[];
    int listImages[];
    LayoutInflater inflater;
    public BusinessmarketingBaseAdapter(Context ctx, String[] BusinessList,int[] images){
        this.context = ctx;
        this.listBusiness = BusinessList;
        this.listImages = images;
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return listBusiness.length;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.activity_businessmarketinglistview,null);
        TextView txtView = (TextView) convertView.findViewById(R.id.textview1);
        ImageView SoftwareImg = (ImageView) convertView.findViewById(R.id.image1);
        txtView.setText((listBusiness[position]));
        SoftwareImg.setImageResource(listImages[position]);
        return convertView;
    }
}
