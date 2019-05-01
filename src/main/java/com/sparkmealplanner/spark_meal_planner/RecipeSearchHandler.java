package com.sparkmealplanner.spark_meal_planner;

import java.util.HashMap;

import org.json.JSONObject;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 *The following class handles the HMTL elements of the search recipe page of the app
 *
 */
public class RecipeSearchHandler implements Route {

	//form HTML stored in a variable
	private final String searchRecipeForm = "<div><form action=\"/displayrecipelist\" method=\"get\">Enter a recipe to search:"
			+ "<input type=\"text\" name=\"recipetosearch\"><br><br>"
			+ "<button style=\"margin-left: 10px\">Search</button></li>";

	/**
	 * Handle method to create a form to collect recipe search term from the user
	 */
	
	public Object handle(Request request, Response response) throws Exception {
		
		//returns HTML elements
		return TagCreator.gethtmlHead("Search Recipe")
				+TagCreator.createBodyTitle("Search My Recipes Below")
				+ searchRecipeForm
				+ TagCreator.getFooter()
				+TagCreator.closeTag();
		}
}
