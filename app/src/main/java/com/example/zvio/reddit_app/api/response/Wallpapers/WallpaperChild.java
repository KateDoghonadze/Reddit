package com.example.zvio.reddit_app.api.response.Wallpapers;

/**
 * Created by ZVIO on 10/28/2016.
 */

public class WallpaperChild {
    String kind;
    WallpaperChildData data;

    public WallpaperChild(String kind, WallpaperChildData data) {
        this.kind = kind;
        this.data = data;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public WallpaperChildData getData() {
        return data;
    }

    public void setData(WallpaperChildData data) {
        this.data = data;
    }
}
