package com.sparkmealplanner.spark_meal_planner;

import java.util.HashMap;

import org.json.JSONObject;

import spark.Request;
import spark.Response;
import spark.Route;

public class RecipeSearchHandler implements Route {

	private final String searchRecipeForm = "<div><form action=\"/displayrecipelist\" method=\"get\">Enter a recipe to search:"
			+ "<input type=\"text\" name=\"recipetosearch\"><br><br>"
			+ "<button style=\"margin-left: 10px\">Search</button></li>";

	/**
	 * Handle method to create a form to collect recipe search term
	 */
	public Object handle(Request request, Response response) throws Exception {
		
		return TagCreator.gethtmlHead("Search Recipe")
				+ "<body><h3>Search My Recipes Below</h3>" 
				+ searchRecipeForm
				+ TagCreator.getFooter()
				+ "</body></html>";
		}
}
