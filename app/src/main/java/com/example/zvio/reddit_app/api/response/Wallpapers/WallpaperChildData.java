package com.example.zvio.reddit_app.api.response.Wallpapers;

/**
 * Created by ZVIO on 10/28/2016.
 */

public class WallpaperChildData {
    WallpaperPreview preview;
    String title;
    String url;

    public WallpaperChildData(WallpaperPreview preview, String title, String url) {
        this.preview = preview;
        this.title = title;
        this.url = url;
    }

    public WallpaperPreview getPreview() {
        return preview;
    }

    public void setPreview(WallpaperPreview preview) {
        this.preview = preview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
