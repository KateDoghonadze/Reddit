package com.example.zvio.reddit_app.api.response.Wallpapers;

import java.util.ArrayList;

/**
 * Created by ZVIO on 10/28/2016.
 */

public class Wallpaper {
    ArrayList<WallpaperSource> resolutions;
    WallpaperSource sourse;

    public Wallpaper(WallpaperSource sourse, ArrayList<WallpaperSource> resolutions) {
        this.sourse = sourse;
        this.resolutions = resolutions;
    }

    public ArrayList<WallpaperSource> getResolutions() {
        return resolutions;
    }

    public void setResolutions(ArrayList<WallpaperSource> resolutions) {
        this.resolutions = resolutions;
    }

    public WallpaperSource getSourse() {
        return sourse;
    }

    public void setSourse(WallpaperSource sourse) {
        this.sourse = sourse;
    }
}
