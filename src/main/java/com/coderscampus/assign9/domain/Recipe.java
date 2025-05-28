package com.coderscampus.assign9.domain;

public class Recipe {
	private Integer cookingMinutes;

    private boolean dairyFree;

    private boolean glutenFree;

    private String instructions;

    private Double preparationMinutes;

    private Double pricePerServing;

    private Integer readyInMinutes;

    private Integer servings;

    private Double spoonacularScore;

    private String title;

    private boolean vegan;

    private boolean vegetarian;


    public Integer getCookingMinutes() {
        return cookingMinutes;
    }
    public void setCookingMinutes(Integer cookingMinutes) {
        this.cookingMinutes = cookingMinutes;
    }
    public boolean isDairyFree() {
        return dairyFree;
    }
    public void setDairyFree(boolean dairyFree) {
        this.dairyFree = dairyFree;
    }
    public boolean isGlutenFree() {
        return glutenFree;
    }
    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }
    public String getInstructions() {
        return instructions;
    }
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    public Double getPreparationMinutes() {
        return preparationMinutes;
    }
    public void setPreparationMinutes(Double preparationMinutes) {
        this.preparationMinutes = preparationMinutes;
    }
    public Double getPricePerServing() {
        return pricePerServing;
    }
    public void setPricePerServing(Double pricePerServing) {
        this.pricePerServing = pricePerServing;
    }
    public Integer getReadyInMinutes() {
        return readyInMinutes;
    }
    public void setReadyInMinutes(Integer readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }
    public Integer getServings() {
        return servings;
    }
    public void setServings(Integer servings) {
        this.servings = servings;
    }
    public Double getSpoonacularScore() {
        return spoonacularScore;
    }
    public void setSpoonacularScore(Double spoonacularScore) {
        this.spoonacularScore = spoonacularScore;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public boolean isVegan() {
        return vegan;
    }
    public void setVegan(boolean vegan) {
        this.vegan = vegan;
    }
    public boolean isVegetarian() {
        return vegetarian;
    }
    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }
    @Override
    public String toString() {
        return "Recipe [cookingMinutes=" + cookingMinutes + ", dairyFree=" + dairyFree + ", glutenFree=" + glutenFree
                + ", instructions=" + instructions + ", preparationMinutes=" + preparationMinutes + ", pricePerServing="
                + pricePerServing + ", readyInMinutes=" + readyInMinutes + ", servings=" + servings
                + ", spoonacularScore=" + spoonacularScore + ", title=" + title + ", vegan=" + vegan + ", vegetarian="
                + vegetarian + "]";
    }




}
