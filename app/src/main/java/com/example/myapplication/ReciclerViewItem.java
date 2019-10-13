package com.example.myapplication;

public class ReciclerViewItem {
    private int imageViewRecourse;
    private String text1;
    private String text2;

    public ReciclerViewItem() {
    }

    public ReciclerViewItem(int imageViewRecourse, String text1, String text2) {
        this.imageViewRecourse = imageViewRecourse;
        this.text1 = text1;
        this.text2 = text2;
    }

    public int getImageViewRecourse() {
        return imageViewRecourse;
    }

    public void setImageViewRecourse(int imageViewRecourse) {
        this.imageViewRecourse = imageViewRecourse;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
}
