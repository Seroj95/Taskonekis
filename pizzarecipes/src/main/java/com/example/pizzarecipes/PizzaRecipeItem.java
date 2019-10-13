package com.example.pizzarecipes;

public class PizzaRecipeItem {
    private int imageResource;
    private String title;
    private String decreption;
    private String reception;

    public PizzaRecipeItem(int imageResource, String title, String decreption, String reception) {
        this.imageResource = imageResource;
        this.title = title;
        this.decreption = decreption;
        this.reception = reception;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDecreption() {
        return decreption;
    }

    public void setDecreption(String decreption) {
        this.decreption = decreption;
    }

    public String getReception() {
        return reception;
    }

    public void setReception(String reception) {
        this.reception = reception;
    }
}
