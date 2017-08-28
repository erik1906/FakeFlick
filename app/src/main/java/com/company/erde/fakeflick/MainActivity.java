package com.company.erde.fakeflick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.company.erde.fakeflick.API.Flickr;
import com.company.erde.fakeflick.API.GetFlickr;
import com.company.erde.fakeflick.Adapters.CustomAdapter;
import com.company.erde.fakeflick.Model.ListCategory;
import com.company.erde.fakeflick.Model.Search.PhotoInfo;
import com.company.erde.fakeflick.Model.Search.PhotosRes;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private GetFlickr flickr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvCategory = (ListView) findViewById(R.id.lvCategory);

        ArrayList<ListCategory> data = new ArrayList<>();

        data.add(new ListCategory(R.drawable.ic_flower, "Nature"));
        data.add(new ListCategory(R.drawable.selfie, "Selfie"));
        data.add(new ListCategory(R.drawable.moon, "Night"));
        data.add(new ListCategory(R.drawable.ic_artistic_brush, "Art"));


        ArrayAdapter<ListCategory> adapter = new CustomAdapter(data, this);

        lvCategory.setAdapter(adapter);

        flickr = Flickr.getApi().create(GetFlickr.class);
        getPhotos("night");

    }

    public void getPhotos(String searchParam){
        Call<PhotosRes> photosCall = flickr.getSearch( Flickr.KEY, searchParam);
        photosCall.enqueue(new Callback<PhotosRes>() {
            @Override
            public void onResponse(Call<PhotosRes> call, Response<PhotosRes> response) {
                PhotoInfo[] res = response.body().getPhotos().getPhoto();
                String id = res[1].getId();
                String owner = res[1].getOwner();
                Log.d("response",id+" "+owner);

            }

            @Override
            public void onFailure(Call<PhotosRes> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Sorry, can't get the city weather.",Toast.LENGTH_LONG).show();
            }
        });
    }
}
