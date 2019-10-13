package com.example.myapplication;

public class Notes {
    private String title;
    private String descreption;
    private String dayOfWek;
    private int priorety;

    public Notes() {
    }

    public Notes(String title, String descreption, String dayOfWek, int priorety) {
        this.title = title;
        this.descreption = descreption;
        this.dayOfWek = dayOfWek;
        this.priorety = priorety;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public String getDayOfWek() {
        return dayOfWek;
    }

    public void setDayOfWek(String dayOfWek) {
        this.dayOfWek = dayOfWek;
    }

    public int getPriorety() {
        return priorety;
    }

    public void setPriorety(int priorety) {
        this.priorety = priorety;
    }
}
