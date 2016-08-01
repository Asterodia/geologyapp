package com.example.asterodia.navtest;

import java.util.ArrayList;

/**
 * Created by Asterodia on 30/07/2016.
 */
public class RockParent {
    private String mTitle;
    private Rock mChild;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Rock getChild() {
        return mChild;
    }

    public void setChild(Rock child) {
        mChild = child;
    }
}
