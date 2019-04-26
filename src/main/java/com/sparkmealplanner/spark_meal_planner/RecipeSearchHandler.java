package com.sparkmealplanner.spark_meal_planner;

import java.util.HashMap;

import org.json.JSONObject;

import spark.Request;
import spark.Response;
import spark.Route;

public class RecipeSearchHandler implements Route {

	private static String recipeToSearch;

	private final String htmlHead = "<html><head><title>Search Recipe</title></head>";

	private final String searchRecipeForm = "<div><form action=\"/displayrecipelist\" method=\"post\">Enter a recipe to search:"
			+ "<input type=\"text\" name=\"recipetosearch\">"
			+ "<button style=\"margin-left: 10px\" type=\"submit\">Search</button>" + "</form></div>";

	/**
	 * Handle method to
	 */
	public Object handle(Request request, Response response) throws Exception {

		// if the url is directed to "/searchrecipe" the search recipe entered by user gets saved

			// find the user inputed recipe name to search
			recipeToSearch = request.queryParams("recipetosearch");
			System.out.println(recipeToSearch);

//		 if the url is directed to "/displayrecipes", an yummly API handler object is
//		 created

		return htmlHead + "<body><h3>Search Your Recipes Below</h3>" + searchRecipeForm + "<br>"
				+ "<button><a href=\"/\">Go back to your list</a></button></body></html>";
	}

	/**
	 * Getter method
	 * @return the recipeToSearch
	 */
	public static String getRecipeToSearch() {
		return recipeToSearch;
	}
	
	
}
