package com.example.asterodia.navtest;

import java.util.ArrayList;

/**
 * Created by Alex on 17/07/2016.
 *
 * Location name parent class
 */
public class LocationParent {
    private String mTitle;
    private Location mChild;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Location getChild() {
        return mChild;
    }

    public void setChild(Location child) {
        mChild = child;
    }
}
