package com.company.erde.fakeflick.Adapters;

/**
 * Created by Erik on 28/08/2017.
 */

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.company.erde.fakeflick.Model.Photo.URL;
import com.company.erde.fakeflick.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<URL> url;

    public ImageAdapter(Context c, ArrayList<URL> urlSend) {
        mContext = c;
        url=urlSend;

    }

    public int getCount() {
        return url.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(1, 1, 1, 1);
        } else {
            imageView = (ImageView) convertView;
        }

        //Picasso.with(this.mContext).load("http://www.flickr.com/photos/143021864@N05/36045079324").into(imageView);

        String urls = url.get(position).getPath()+"_q.jpg";

        Log.d("url", urls);



        Picasso.with(this.mContext).load(urls)
               .into(imageView);


        return imageView;
    }

}