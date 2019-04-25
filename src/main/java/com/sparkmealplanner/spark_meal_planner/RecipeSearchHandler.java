package com.sparkmealplanner.spark_meal_planner;

import java.util.HashMap;

import org.json.JSONObject;

import spark.Request;
import spark.Response;
import spark.Route;

public class RecipeSearchHandler implements Route {

	String recipeToSearch;
	HashMap<String, String> recipeNameAndDishID;
	String recipeID;

	private final String htmlHead = "<html><head><title>Search Recipe</title></head>";
	private final String searchRecipeForm = "<div><form method=\"post\">Search recipes:"
			+ "<input type=\"text\" name=\"recipenametosearch\">"
			+ "<button style=\"margin-left: 10px\" type=\"submit\">Search</button>" + "</form></div>";

	/**
	 * Handle method to
	 */
	public Object handle(Request request, Response response) throws Exception {

		// if the url is directed to "/searchrecipe", an yummly API handler object is
		// created
		if ("/searchrecipe".equals(request.pathInfo())) {

			// find the user inputed recipe name to search
			recipeToSearch = request.queryParams("recipenametosearch");
			this.recipeToSearch = recipeToSearch;
		}

		// if the url is directed to "/displayrecipes", an yummly API handler object is
		// created
		if ("/displayrecipes".equals(request.pathInfo())) {

		}

		return htmlHead + "<body><h3>Search Your Recipes Below</h3>" 
				+ searchRecipeForm 
				+ searchrecipefromAPI()
				+"<br>"
				+ "<button><a href=\"/\">Go back to your list</a></button></body></html>";
	}

	public String displayRecipeInfo() {
		
		
		return null;
	}

	public String searchrecipefromAPI() {
		
		StringBuilder sb = new StringBuilder();

		//create a new div with unordered lists
		sb.append("<div><ul>");

		for (String recipe : recipeNameAndDishID.keySet()) {
			
			//add a line with recipe name and two buttons: "Add a meal plan" and "View Recipe Details"
			sb.append("<li>" + recipe 
					+ "<button style=\"margin-left: 10px\" onclick=\"location.href='/createmealplan'\">Add to Meal Plan</button>"
					+ "<button style=\"margin-left: 10px\" onclick=\"location.href='/displayrecipes'\">View Recipe Details</button>"
					+ "</li>");
		}

		sb.append("</ul></div>");

		return sb.toString() 
				+ "<br>"
				+"<button><a href=\"/searchrecipe\">Search a new recipe instead</a></button>";
	}
}
