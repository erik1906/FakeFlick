package com.company.erde.fakeflick.API;

import com.company.erde.fakeflick.Model.Photo.PhotoResponse;
import com.company.erde.fakeflick.Model.Search.PhotosRes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Erik on 27/08/2017.
 */

public interface GetFlickr {

    @GET("?method=flickr.photos.search&format=json&nojsoncallback=1")
    Call<PhotosRes> getSearch (@Query("api_key") String key, @Query("tags") String search );

   @GET("?method=flickr.photos.getInfo&format=json&nojsoncallback=1")
    Call<PhotoResponse> getPhoto (@Query("api_key") String key, @Query("photo_id") String photoId );


}
