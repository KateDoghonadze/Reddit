package com.example.zvio.reddit_app.api.Service;

import com.example.zvio.reddit_app.api.response.Wallpapers.WallpaperResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by QETO on 10/30/2016.
 */

public interface IRetrofitService {
    String BASE = "r/";

    @GET(BASE + "wallpapers/.json")
    Call<WallpaperResponse> getGifJson();

}
