package com.sparkmealplanner.spark_meal_planner;

import java.util.HashMap;

import org.json.JSONObject;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * The following class handles the HMTL elements of the search recipe page of
 * the app
 *
 */
public class RecipeSearchHandler implements Route {

	// form HTML stored in a variable
	private final String searchRecipeForm = "<div><form action=\"/displayrecipelist\" method=\"get\">Enter a recipe to search:"
			+ "<input type=\"text\" size=\"30\" placeholder=\" Type recipe to search here..\" name=\"recipetosearch\"><br><br>"
			+ "<button style=\"margin-left: 10px\">Search</button></li>";

	/**
	 * Handle method to create a form to collect recipe search term from the user
	 */

	public Object handle(Request request, Response response) throws Exception {

		// returns HTML elements
		return TagCreator.gethtmlHead("Search Recipe") + TagCreator.createBodyTitle("Search My Recipes Below")
				+ searchRecipeForm + addRecipeFromURLButton() + TagCreator.getFooter() + TagCreator.closeTag();
	}
	
	/**
	 * The following method adds a button to direct users to add recipe from an
	 * external url
	 * 
	 * @return HTML
	 */
	private String addRecipeFromURLButton() {

		StringBuilder sb = new StringBuilder();
		sb.append("<br><br>");
		// creating a button in HTML
		sb.append(TagCreator.createButton("addrecipe", "I would rather add a recipe on my own"));

		return sb.toString();
	}
}
