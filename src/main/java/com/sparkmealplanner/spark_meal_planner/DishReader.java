package com.sparkmealplanner.spark_meal_planner;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * The following class creates the Dish object based on the file lines or the
 * JSON object received from the API
 *
 */
public class DishReader {
	private ArrayList<String> lines;
	// we can only use getRecipeJSON from the YummlyAPIHandler class
	private JSONObject recipeJSON;
	private ArrayList<Dish> listOfDishes;
	private Dish dishCreated;
	private String recipeName;
	private String recipeID;
	private int numberOfServings;
	private int totalTimeInSeconds;
	private ArrayList<Ingredient> ingredientList;
	private String recipeStepsURL;
	private String getRecipeAttributionhtml;

//	/**
//	 * The following constructor takes in the file lines and reads the dishes
//	 * 
//	 * @param lines lines
//	 */
//	public DishReader(ArrayList<String> lines) {
//		this.lines = lines;
//		readDishFromFileLines();
//	}

	/**
	 * The following constructor takes in the JSON object and reads the dishes
	 * 
	 * @param recipeJSON
	 * @throws Exception
	 */
	public DishReader(JSONObject recipeJSON) throws Exception {
		this.recipeJSON = recipeJSON;
		readDishFromJSON();
	}

	/**
	 * getter methods
	 * 
	 * @return the listOfDishes
	 */
	public ArrayList<Dish> getListOfDishes() {
		return listOfDishes;
	}

	/**
	 * getter methods
	 * 
	 * @return the dishCreated
	 */
	public Dish getDishCreated() {
		return dishCreated;
	}

	/**
	 * The following method reads the JSON object (getJSONObject from
	 * yummlyAPIHandler class) and returns a dish
	 * 
	 * @return
	 * @throws Exception
	 */
	public Dish readDishFromJSON() throws Exception {

		// key "name" stores the name of the recipe in the the JSON object
		recipeName = recipeJSON.getString("name");
		// System.out.println("Recipe Name: " + recipeName);

		// key "id" stores the name of the recipe in the the JSON object
		recipeID = recipeJSON.getString("id");

		// key "numberOfServings" stores the number of servingin the the JSON object
		numberOfServings = recipeJSON.getInt("numberOfServings");
		// System.out.println("Number of Servings: " + numberOfServings);

		// key "totalTimeInSeconds" stores the total time in the the JSON object
		totalTimeInSeconds = recipeJSON.getInt("totalTimeInSeconds");
		// System.out.println("Time in Seconds: " + totalTimeInSeconds);

		// key "ingredientLines" stores the ingredients in the the JSON object
		ingredientList = new ArrayList<Ingredient>();
		JSONArray ingredients = recipeJSON.getJSONArray("ingredientLines");
		for (int i = 0; i < ingredients.length(); i++) {
			Ingredient item = new Ingredient((String) ingredients.get(i));
			ingredientList.add(item);
		}

		// JSON object "source" stores information on the original source of the recipe
		JSONObject source = recipeJSON.getJSONObject("source");
		recipeStepsURL = (String) source.get("sourceRecipeUrl");
		// System.out.println("Find Recipe steps at: " + recipeStepsURL);

		getRecipeAttributionhtml = (String) recipeJSON.getJSONObject("attribution").get("html");

		dishCreated = new Dish(recipeID, recipeName, ingredientList, recipeStepsURL, totalTimeInSeconds,
				numberOfServings);
		dishCreated.setAttribution(getRecipeAttributionhtml);

		return dishCreated;
	}

//	/**
//	 * The following method reads the file lines and returns a list of dish objects
//	 * 
//	 * @return dish ArrayList
//	 */
//	public ArrayList<Dish> readDishFromFileLines() {
//		listOfDishes = new ArrayList<Dish>();
//
//		// TODO add code
//		return listOfDishes;
//	}
}
