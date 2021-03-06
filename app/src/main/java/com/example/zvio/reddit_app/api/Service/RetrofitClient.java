package com.example.zvio.reddit_app.api.Service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by QETO on 10/30/2016.
 */

public class RetrofitClient {
    private static final String BASE_URL = "https://www.reddit.com/";
    private IRetrofitService service;

    public RetrofitClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        OkHttpClient client = httpClient.build();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = restAdapter.create(IRetrofitService.class);
    }


    public IRetrofitService getService() {
        return service;
    }

}
