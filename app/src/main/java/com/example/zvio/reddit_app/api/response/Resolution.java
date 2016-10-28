package com.example.zvio.reddit_app.api.response;

/**
 * Created by ZVIO on 10/28/2016.
 */

public class Resolution {
    Source source;

    public Resolution(Source source) {
        this.source = source;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}
