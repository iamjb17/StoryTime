package com.example.jessie.storytime.Model;

/**
 * Created by Jessie on 7/9/2017.
 */

public class Page {

    // Instance variables
    private int imageId;
    private int textId;
    private Choice mChoice1;
    private Choice mChoice2;
    private boolean isFinalPage = false;

    // Custom constructor
    public Page(int imageId, int textId){
        this.imageId = imageId;
        this.textId = textId;
        this.isFinalPage = true;
    }

    // Custom constructor
    public Page(int imageId, int textId, Choice mChoice1, Choice mChoice2){
        this.imageId = imageId;
        this.textId = textId;
        this.mChoice1 = mChoice1;
        this.mChoice2 = mChoice2;
    }

    // getters and setters for our variables
    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public Choice getChoice1() {
        return mChoice1;
    }

    public void setChoice1(Choice choice1) {
        mChoice1 = choice1;
    }

    public Choice getChoice2() {
        return mChoice2;
    }

    public void setChoice2(Choice choice2) {
        mChoice2 = choice2;
    }

    public boolean isFinalPage() {
        return isFinalPage;
    }

    public void setFinalPage(boolean finalPage) {
        isFinalPage = finalPage;
    }
}
