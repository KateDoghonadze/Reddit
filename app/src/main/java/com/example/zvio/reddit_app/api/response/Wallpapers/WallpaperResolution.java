package com.example.zvio.reddit_app.api.response.Wallpapers;

/**
 * Created by ZVIO on 10/28/2016.
 */

public class WallpaperResolution {
    WallpaperSource source;

    public WallpaperResolution(WallpaperSource source) {
        this.source = source;
    }

    public WallpaperSource getSource() {
        return source;
    }

    public void setSource(WallpaperSource source) {
        this.source = source;
    }
}
