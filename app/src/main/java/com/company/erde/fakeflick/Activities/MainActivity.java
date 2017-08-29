package com.company.erde.fakeflick.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.company.erde.fakeflick.Adapters.CustomAdapter;
import com.company.erde.fakeflick.Model.ListCategory;
import com.company.erde.fakeflick.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvCategory = (ListView) findViewById(R.id.lvCategory);

        final ArrayList<ListCategory> data = new ArrayList<>();

        data.add(new ListCategory(R.drawable.ic_flower, "Nature"));
        data.add(new ListCategory(R.drawable.selfie, "Selfie"));
        data.add(new ListCategory(R.drawable.moon, "Night"));
        data.add(new ListCategory(R.drawable.ic_artistic_brush, "Art"));


        ArrayAdapter<ListCategory> adapter = new CustomAdapter(data, this);

        lvCategory.setAdapter(adapter);

        lvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String dete = data.get(position).getCategoryName();
                Log.d("dete", dete);
                Intent intent = new Intent(MainActivity.this, GalleryActivity.class);
                intent.putExtra("searchParam", dete);
                startActivity(intent);
            }
        });

        //
        //getPhotos("night");

    }


}
