package com.company.erde.fakeflick.Model.Photo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Erik on 28/08/2017.
 */

public class Title implements Serializable{
    @SerializedName("_content")
    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
