package com.example.jessie.storytime.Model;

/**
 * Created by Jessie on 7/9/2017.
 */

public class Choice {

    // Instance variable
    private int textId;
    private int nextPage;

    // Custom constructor
    public Choice(int textId, int nextPage){
        this.textId = textId;
        this.nextPage = nextPage;
    }

    // Getters and setters
    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
}
