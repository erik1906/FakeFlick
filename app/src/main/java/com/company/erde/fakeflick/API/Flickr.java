package com.company.erde.fakeflick.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Erik on 27/08/2017.
 */

public class Flickr {
    public static final String KEY = "053a35e8dfb292c3b17399a0bf611566";
    private static final String KEY_PRIVATE = "b2188cccf4bcaedc";

    private static final String BASE_URL = "https://api.flickr.com/services/rest/";

    private static Retrofit retrofit = null;

    public static Retrofit getApi() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
