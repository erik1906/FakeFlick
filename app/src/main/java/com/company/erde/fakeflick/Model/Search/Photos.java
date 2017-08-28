package com.company.erde.fakeflick.Model.Search;

/**
 * Created by Erik on 27/08/2017.
 */

public class Photos {
    String page;
    PhotoInfo[] photo;

    public PhotoInfo[] getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoInfo[] photo) {
        this.photo = photo;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
