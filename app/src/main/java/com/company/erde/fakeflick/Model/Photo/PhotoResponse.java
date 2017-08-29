package com.company.erde.fakeflick.Model.Photo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Erik on 28/08/2017.
 */

public class PhotoResponse implements Serializable {
    @SerializedName("photo")
    PhotoGalllery galllery;
    String stat;

    public PhotoGalllery getGalllery() {
        return galllery;
    }

    public void setGalllery(PhotoGalllery galllery) {
        this.galllery = galllery;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
