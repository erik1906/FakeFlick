package com.company.erde.fakeflick.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.erde.fakeflick.Model.ListCategory;
import com.company.erde.fakeflick.R;

import java.util.ArrayList;

/**
 * Created by Erik on 27/08/2017.
 */


public class CustomAdapter extends ArrayAdapter<ListCategory> {


    public CustomAdapter(ArrayList<ListCategory> data, Context context) {
        super(context, R.layout.list_category, data);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.list_category,parent,false);

        ListCategory category = (ListCategory) getItem(position);

        TextView tvCategory = (TextView) view.findViewById(R.id.tvCategory);
        tvCategory.setText(category.getCategoryName());

        ImageView ivIcon =(ImageView) view.findViewById(R.id.ivIcon);
        ivIcon.setImageResource(category.getImageURL());




        return view;
    }
}
