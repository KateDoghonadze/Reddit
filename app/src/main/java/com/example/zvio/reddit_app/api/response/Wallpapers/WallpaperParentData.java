package com.example.zvio.reddit_app.api.response.Wallpapers;

import java.util.ArrayList;

/**
 * Created by ZVIO on 10/28/2016.
 */

public class WallpaperParentData {
    String modhush;
    String after;
    String before;
    ArrayList<WallpaperChild> children;

    public WallpaperParentData(String modhush, String after, String before, ArrayList<WallpaperChild> children) {
        this.modhush = modhush;
        this.after = after;
        this.before = before;
        this.children = children;
    }

    public String getModhush() {
        return modhush;
    }

    public void setModhush(String modhush) {
        this.modhush = modhush;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public ArrayList<WallpaperChild> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<WallpaperChild> children) {
        this.children = children;
    }
}
