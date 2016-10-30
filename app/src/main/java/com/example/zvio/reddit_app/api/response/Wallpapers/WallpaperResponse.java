package com.example.zvio.reddit_app.api.response.Wallpapers;

/**
 * Created by QETO on 10/30/2016.
 */

public class WallpaperResponse {


    String kind;
    WallpaperParentData data;

    public WallpaperResponse(String kind, WallpaperParentData data) {
        this.kind = kind;
        this.data = data;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public WallpaperParentData getData() {
        return data;
    }

    public void setData(WallpaperParentData data) {
        this.data = data;
    }
}