package com.example.zvio.reddit_app.api.response;

import java.util.ArrayList;

/**
 * Created by ZVIO on 10/28/2016.
 */

public class Image {
    ArrayList<Resolution> resolutions;
    Source sourse;

    public Image(Source sourse, ArrayList<Resolution> resolutions) {
        this.sourse = sourse;
        this.resolutions = resolutions;
    }

    public ArrayList<Resolution> getResolutions() {
        return resolutions;
    }

    public void setResolutions(ArrayList<Resolution> resolutions) {
        this.resolutions = resolutions;
    }

    public Source getSourse() {
        return sourse;
    }

    public void setSourse(Source sourse) {
        this.sourse = sourse;
    }
}
