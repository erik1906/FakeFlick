package com.company.erde.fakeflick.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Erik on 27/08/2017.
 */

public class Flickr {
    private static final String KEY = "053a35e8dfb292c3b17399a0bf611566";
    private static final String KEY_PRIVATE = "b2188cccf4bcaedc";

    private static final String BASE_URL = "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=2358e9f96c8c7b9cf3cd0780b36ad845&tags=Night&format=json&nojsoncallback=1";

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
