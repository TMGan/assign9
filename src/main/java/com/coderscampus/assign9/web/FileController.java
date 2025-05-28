package com.coderscampus.assign9.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.assign9.domain.Recipe;
import com.coderscampus.assign9.service.FileService;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("")
    public List<String> readFile() throws IOException {
        return fileService.readFile("recipes.txt");
    }



    @GetMapping("/gluten-free")
    public List<Recipe> glutenFree() {
        System.out.println("Gluten-free recipes: ");
        List<Recipe> glutenFreeRecipes = fileService.getRecipes().stream()
                .filter(recipe -> Boolean.TRUE.equals(recipe.isGlutenFree()))
                .collect(Collectors.toList());
        System.out.println("Gluten-free recipes returned: " + glutenFreeRecipes.size());
        return glutenFreeRecipes;

    }
    @GetMapping("/vegan")
    public List<Recipe> vegan() {
        List<Recipe> veganRecipes = fileService.getRecipes().stream()
                .filter(recipe -> Boolean.TRUE.equals(recipe.isVegan()))
                .collect(Collectors.toList());
        System.out.println("Vegan recipes returned: " + veganRecipes.size());
        return veganRecipes;
    }
    @GetMapping("/vegetarian")
    public List<Recipe> vegetarian() {
        List<Recipe> vegetarianRecipes = fileService.getRecipes().stream()
                .filter(recipe -> Boolean.TRUE.equals(recipe.isVegetarian()))
                .collect(Collectors.toList());
        System.out.println("Vegetarian recipes returned: " + vegetarianRecipes.size());
        return vegetarianRecipes;
    }

    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> veganAndGlutenFree() {
        List<Recipe> veganAndGlutenFreeRecipes = fileService.getRecipes().stream()
                .filter(recipe -> Boolean.TRUE.equals(recipe.isVegan()) && Boolean.TRUE.equals(recipe.isGlutenFree()))
                .collect(Collectors.toList());
        System.out.println("Vegan and gluten-free recipes returned: " + veganAndGlutenFreeRecipes.size());
        return veganAndGlutenFreeRecipes;
    }
    @GetMapping("/all-recipes")
    public List<Recipe> allRecipes() {
        List<Recipe> allRecipes = fileService.getRecipes();
        System.out.println("All recipes returned: " + allRecipes.size());
        return allRecipes;
    }
}
