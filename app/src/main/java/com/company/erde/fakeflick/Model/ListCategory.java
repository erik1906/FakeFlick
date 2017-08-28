package com.company.erde.fakeflick.Model;

import android.graphics.drawable.Drawable;

/**
 * Created by Erik on 27/08/2017.
 */

public class ListCategory {
    int imageURL;
    String categoryName;


    public ListCategory(int imageURL, String categoryName) {
        this.imageURL = imageURL;
        this.categoryName = categoryName;
    }

    public int getImageURL() {
        return imageURL;
    }

    public void setImageURL(int imageURL) {
        this.imageURL = imageURL;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
