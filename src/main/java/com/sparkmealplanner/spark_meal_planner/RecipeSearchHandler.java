package com.sparkmealplanner.spark_meal_planner;

import java.util.HashMap;

import org.json.JSONObject;

import spark.Request;
import spark.Response;
import spark.Route;

public class RecipeSearchHandler implements Route {

	private final String htmlHead = "<html><head><title>Search Recipe</title></head>";

	private final String searchRecipeForm = "<div><form action=\"/displayrecipelist\" method=\"get\">Enter a recipe to search:"
			+ "<input type=\"text\" name=\"recipetosearch\">" 
			+ "<br>"
			+ "\"<button style=\"margin-left: 10px\" onclick=\"location.href='/taskdone?id=\">DONE</button></li>\"";

	/**
	 * Handle method to create a form to collect recipe search term
	 */
	public Object handle(Request request, Response response) throws Exception {

		return htmlHead + "<body><h3>Search My Recipes Below</h3>" + searchRecipeForm + "<br>"
				+ "<button><a href=\"/\">Go back to your list</a></button></body></html>";
	}
}
