package com.company.erde.fakeflick.Model.Photo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Erik on 28/08/2017.
 */

public class PhotoGalllery {

    @SerializedName("owner")
    private Owner owner;

    @SerializedName("title")
    private Owner title;

    public Owner getTitle() {
        return title;
    }

    public void setTitle(Owner title) {
        this.title = title;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

}
