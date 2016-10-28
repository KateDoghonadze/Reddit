package com.example.zvio.reddit_app.api.response;

/**
 * Created by ZVIO on 10/28/2016.
 */

public class ChildData {
    Preview preview;
    String title;
    String url;

    public ChildData(Preview preview, String title, String url) {
        this.preview = preview;
        this.title = title;
        this.url = url;
    }

    public Preview getPreview() {
        return preview;
    }

    public void setPreview(Preview preview) {
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
