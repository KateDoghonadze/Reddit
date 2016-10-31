package com.example.zvio.reddit_app.ui.components;

import com.example.zvio.reddit_app.api.response.Wallpapers.Wallpaper;
import com.example.zvio.reddit_app.api.response.Wallpapers.WallpaperSource;

/**
 * Created by QETO on 10/30/2016.
 */

public interface RecyclerItemClickListener {
    void onItemClick(WallpaperSource source);
}
