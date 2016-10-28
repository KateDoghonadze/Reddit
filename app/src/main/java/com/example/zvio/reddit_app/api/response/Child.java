package com.example.zvio.reddit_app.api.response;

/**
 * Created by ZVIO on 10/28/2016.
 */

public class Child {
    String kind;
    ChildData data;

    public Child(String kind, ChildData data) {
        this.kind = kind;
        this.data = data;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public ChildData getData() {
        return data;
    }

    public void setData(ChildData data) {
        this.data = data;
    }
}
