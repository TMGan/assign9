package com.coderscampus.assign9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

import com.coderscampus.assign9.domain.Recipe;

@Service
public class FileService {
	private List<Recipe> recipes = new ArrayList<>();

	public void loadRecipes() throws IOException {
		recipes.clear();
		try (Reader reader = new FileReader("recipes.txt")) {
			Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreSurroundingSpaces(true)
					.withEscape('\\').withTrim().withQuote('"').parse(reader);

			int rowCount = 0;
			for (CSVRecord record : records) {
				rowCount++;
				if (record.size() != 12) {
					System.err.println("Skipping row " + rowCount + ": Expected 12 columns, found " + record.size());
					continue;
				}

				Recipe recipe = new Recipe();
				try {
					recipe.setCookingMinutes(record.get("Cooking Minutes").isEmpty() ? 0
							: Integer.parseInt(record.get("Cooking Minutes")));
					recipe.setDairyFree(record.get("Dairy Free").isEmpty() ? false
							: Boolean.parseBoolean(record.get("Dairy Free")));
					String glutenFreeValue = record.get("Gluten Free").trim();
					recipe.setGlutenFree("true".equalsIgnoreCase(glutenFreeValue));
					recipe.setInstructions(record.get("Instructions") != null ? record.get("Instructions") : "");
					recipe.setPreparationMinutes(record.get("Preparation Minutes").isEmpty() ? 0.0
							: Double.parseDouble(record.get("Preparation Minutes")));
					recipe.setPricePerServing(record.get("Price Per Serving").isEmpty() ? 0.0
							: Double.parseDouble(record.get("Price Per Serving")));
					recipe.setReadyInMinutes(record.get("Ready In Minutes").isEmpty() ? 0
							: Integer.parseInt(record.get("Ready In Minutes")));
					recipe.setServings(record.get("Servings").isEmpty() ? 0 : Integer.parseInt(record.get("Servings")));
					recipe.setSpoonacularScore(record.get("Spoonacular Score").isEmpty() ? 0.0
							: Double.parseDouble(record.get("Spoonacular Score")));
					recipe.setTitle(record.get("Title") != null ? record.get("Title") : "");
					recipe.setVegan(record.get("Vegan").isEmpty() ? false : Boolean.parseBoolean(record.get("Vegan")));
					recipe.setVegetarian(record.get("Vegetarian").isEmpty() ? false
							: Boolean.parseBoolean(record.get("Vegetarian")));
					recipes.add(recipe);
					if (recipe.isGlutenFree()) {
						System.out.println("Loaded gluten-free recipe: " + recipe.getTitle());
					}
				} catch (NumberFormatException e) {
					System.err.println("Error parsing numbers in row " + rowCount + ": " + e.getMessage());
					continue;
				}
			}
			System.out.println("Loaded " + recipes.size() + " recipes");
		}
	}

	public List<Recipe> getRecipes() {
		if (recipes.isEmpty()) {
			try {
				loadRecipes();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return recipes;
	}

	public List<String> readFile(String filename) throws IOException {
		return Files.readAllLines(Paths.get(filename));
	}

}
