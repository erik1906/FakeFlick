package com.company.erde.fakeflick.Model.Photo;

import java.io.Serializable;

/**
 * Created by Erik on 28/08/2017.
 */

public class Owner implements Serializable{
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
