package com.example.zvio.reddit_app.api.response;

import java.util.ArrayList;

/**
 * Created by ZVIO on 10/28/2016.
 */

public class Preview {
    ArrayList<Image> images;

    public Preview(ArrayList<Image> images) {
        this.images = images;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }
}
