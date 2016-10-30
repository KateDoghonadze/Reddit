package com.example.zvio.reddit_app.api.response.Wallpapers;

import java.util.ArrayList;

/**
 * Created by ZVIO on 10/28/2016.
 */

public class WallpaperPreview {
    ArrayList<Wallpaper> images;

    public WallpaperPreview(ArrayList<Wallpaper> wallpapers) {
        this.images = wallpapers;
    }

    public ArrayList<Wallpaper> getWallpapers() {
        return images;
    }

    public void setWallpapers(ArrayList<Wallpaper> wallpapers) {
        this.images = wallpapers;
    }
}
