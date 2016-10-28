package com.example.zvio.reddit_app.api.response;

import java.util.ArrayList;

/**
 * Created by ZVIO on 10/28/2016.
 */

public class ParentData {
    String modhush;
    String after;
    String before;
    ArrayList<Child> children;

    public ParentData(String modhush, String after, String before, ArrayList<Child> children) {
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

    public ArrayList<Child> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Child> children) {
        this.children = children;
    }
}
