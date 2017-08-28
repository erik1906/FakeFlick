package com.company.erde.fakeflick.Model.Search;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Erik on 27/08/2017.
 */

public class PhotosRes implements Serializable{
    @SerializedName("photos")
    private Photos photos;

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }
}
