package com.company.erde.fakeflick.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.company.erde.fakeflick.API.Flickr;
import com.company.erde.fakeflick.API.GetFlickr;
import com.company.erde.fakeflick.Adapters.ImageAdapter;
import com.company.erde.fakeflick.Model.Photo.PhotoResponse;
import com.company.erde.fakeflick.Model.Photo.URL;
import com.company.erde.fakeflick.Model.Search.PhotoInfo;
import com.company.erde.fakeflick.Model.Search.PhotosRes;
import com.company.erde.fakeflick.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryActivity extends AppCompatActivity {

    private GetFlickr flickr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);



        flickr = Flickr.getApi().create(GetFlickr.class);
        getPhotos(getIntent().getStringExtra("searchParam"));

    }

    public void getPhotos(String searchParam){
        Call<PhotosRes> photosCall = flickr.getSearch( Flickr.KEY, searchParam);
        photosCall.enqueue(new Callback<PhotosRes>() {
            @Override
            public void onResponse(Call<PhotosRes> call, Response<PhotosRes> response) {
                PhotoInfo[] res = response.body().getPhotos().getPhoto();
                final ArrayList<URL> urls = new ArrayList<>();
                for(int i =0; i<12;i++) {
                    URL url = new URL();
                    url.setFarm(res[i].getFarm());
                    url.setServer(res[i].getServer());
                    url.setId( res[i].getId());
                    url.setSecret( res[i].getSecret());
                    url.setPath("https://farm"+url.getFarm()+".staticflickr.com/"+url.getServer()+"/"+url.getId()+"_"+url.getSecret());
                    urls.add(url);
                }

                GridView gridview = (GridView) findViewById(R.id.gvGallery);
                gridview.setAdapter(new ImageAdapter(GalleryActivity.this, urls));
                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View v,
                                            int position, long id) {
                        Toast.makeText(GalleryActivity.this, "" + position,
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(GalleryActivity.this, PhotoDisplay.class);
                        intent.putExtra("id", urls.get(position).getId());
                        intent.putExtra("path", urls.get(position).getPath());
                        startActivity(intent);
                    }
                });
            }

            @Override
            public void onFailure(Call<PhotosRes> call, Throwable t) {
                Toast.makeText(GalleryActivity.this,"Sorry, can't get the photos.",Toast.LENGTH_LONG).show();
            }
        });
    }

}
