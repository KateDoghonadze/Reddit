package com.example.zvio.reddit_app.api.Service;

import com.example.zvio.reddit_app.api.response.Wallpapers.WallpaperResponse;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by QETO on 10/30/2016.
 */

public class RedditApi {

    public static IRetrofitService retrofitService;

    public RedditApi() {
        if (retrofitService == null) retrofitService = new RetrofitClient().getService();
    }

    public void getGifJson(Callback<WallpaperResponse> callback) {
        Call<WallpaperResponse> call = retrofitService.getGifJson();
        call.enqueue(callback);
    }

}