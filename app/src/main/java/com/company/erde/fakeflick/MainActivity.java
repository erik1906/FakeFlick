package com.company.erde.fakeflick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.company.erde.fakeflick.Adapters.CustomAdapter;
import com.company.erde.fakeflick.Model.ListCategory;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvCategory = (ListView) findViewById(R.id.lvCategory);

        ArrayList<ListCategory> data = new ArrayList<>();

        data.add(new ListCategory(R.drawable.ic_flower , "Nature"));
        data.add(new ListCategory(R.drawable.selfie , "Selfie"));
        data.add(new ListCategory(R.drawable.moon , "Night"));
        data.add(new ListCategory(R.drawable.ic_artistic_brush , "Art"));


        ArrayAdapter<ListCategory> adapter = new CustomAdapter(data, this);

        lvCategory.setAdapter(adapter);



    }
}
