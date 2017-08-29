package com.company.erde.fakeflick.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.company.erde.fakeflick.API.Flickr;
import com.company.erde.fakeflick.API.GetFlickr;
import com.company.erde.fakeflick.Adapters.ImageAdapter;
import com.company.erde.fakeflick.Model.Photo.PhotoResponse;
import com.company.erde.fakeflick.Model.Photo.URL;
import com.company.erde.fakeflick.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoDisplay extends AppCompatActivity {

    private GetFlickr flickr;

    ImageView ivPhoto;
    TextView tvOwner;
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_display);
        int pos = getIntent().getIntExtra("position", 0);
        String urls = getIntent().getStringArrayListExtra("arraylist").get(pos);

        ivPhoto = (ImageView) findViewById(R.id.ivPhoto);
        tvOwner = (TextView) findViewById(R.id.tvOwner);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
    }

    public void setPhotos(String idPhoto){
        Call<PhotoResponse> photosCall = flickr.getPhoto( Flickr.KEY, idPhoto);
        photosCall.enqueue(new Callback<PhotoResponse>() {
            @Override
            public void onResponse(Call<PhotoResponse> call, Response<PhotoResponse> response) {
                //URL[] res = response.body();

            }

            @Override
            public void onFailure(Call<PhotoResponse> call, Throwable t) {
                Toast.makeText(PhotoDisplay.this,"Sorry, can't get the photos.",Toast.LENGTH_LONG).show();
            }
        });
    }


}
