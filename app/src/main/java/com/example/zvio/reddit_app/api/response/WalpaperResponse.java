package com.example.zvio.reddit_app.api.response;

/**
 * Created by ZVIO on 10/28/2016.
 */

public class WalpaperResponse {
    String kind;
    ParentData data;

    public WalpaperResponse(String kind, ParentData data) {
        this.kind = kind;
        this.data = data;
    }

    public ParentData getData() {
        return data;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setData(ParentData data) {
        this.data = data;
    }
}
