package com.sparkmealplanner.spark_meal_planner;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * The following class creates the Dish object based on JSON object received
 * from the API
 *
 */
public class DishReader {
	// instance variables
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

	/**
	 * The following constructor takes in the JSON object and reads the dishes. This
	 * constructor is used in the searched recipes to create a dish
	 * 
	 * @param recipeJSON
	 * @throws Exception
	 */
	public DishReader(JSONObject recipeJSON) throws JSONException {
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
	 * @return Dish object
	 * @throws JSONException
	 */
	public Dish readDishFromJSON() throws JSONException {

		// key "name" stores the name of the recipe in the the JSON object
		recipeName = recipeJSON.getString("name");

		// key "id" stores the name of the recipe in the the JSON object
		recipeID = recipeJSON.getString("id");

		// key "numberOfServings" stores the number of servingin the the JSON object
		numberOfServings = recipeJSON.getInt("numberOfServings");

		// key "totalTimeInSeconds" stores the total time
		totalTimeInSeconds = recipeJSON.getInt("totalTimeInSeconds");

		// key "ingredientLines" stores the ingredients in the the JSONArray
		ingredientList = new ArrayList<Ingredient>();
		JSONArray ingredients = recipeJSON.getJSONArray("ingredientLines");

		for (int i = 0; i < ingredients.length(); i++) {
			Ingredient item = new Ingredient((String) ingredients.get(i));

			// adding to the ingredient list
			ingredientList.add(item);
		}

		// JSON object "source" stores information on the original source of the recipe
		JSONObject source = recipeJSON.getJSONObject("source");
		recipeStepsURL = (String) source.get("sourceRecipeUrl");

		// JSON object "attribution" stores the information on attribution required by
		// Yummly
		getRecipeAttributionhtml = (String) recipeJSON.getJSONObject("attribution").get("html");

		// creating a new dish object
		dishCreated = new Dish(recipeID, recipeName, ingredientList, recipeStepsURL, totalTimeInSeconds,
				numberOfServings);

		// setting the attribution seperately since it's optional
		dishCreated.setAttribution(getRecipeAttributionhtml);

		return dishCreated;
	}
}
