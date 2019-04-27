package com.sparkmealplanner.spark_meal_planner;

import java.util.HashMap;
import java.util.Map.Entry;

import org.json.JSONObject;

import spark.Request;
import spark.Response;
import spark.Route;

public class RecipeDisplayHandler implements Route {

	private String recipeID;
	JSONObject recipeJSON = null;
	
	public Object handle(Request request, Response response) throws Exception {
				
		recipeID = request.queryParams("id");
		
		//System.out.println("Search term entered by the user: " + recipeID);

		return TagCreator.gethtmlHead("Full Recipe") 
				+ "<body><div><h3>Full Recipe <h3></div>" 
				+ getFullRecipeWithAPI() 
				+ TagCreator.getFooter()
				+ "</body></html>";
	}

	
	public String getFullRecipeWithAPI() {
		
		//System.out.println("going through API handler: " + recipeID);
		
		YummlyAPIHandler apiHandler = new YummlyAPIHandler();
		Dish dish = null;
		String recipeStepsURL = "";

		try {
			
			apiHandler.getRecipe(recipeID);
			JSONObject recipeJSON = apiHandler.getGetRecipeJSON();
			JSONObject source = recipeJSON.getJSONObject("source");
			recipeStepsURL = (String) source.get("sourceRecipeUrl");
			
			DishReader dr = new DishReader (apiHandler.getGetRecipeJSON());
			dish = dr.getDishCreated();			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StringBuilder sb = new StringBuilder();

		sb.append("<div>");
		
		sb.append("<p> Recipe Name: " + dish.getDishName() + "</p>");
		sb.append("<p> Recipe Serving Size: " + dish.getNumOfPeopleToServe() + "</p>");
		sb.append("<p> Cooking time in minutes: " + dish.getCookingTimeInSeconds()/60 + "</p>");
		sb.append("<p><a href=\"" + dish.getCookingStepsURL() + "\">Visit original recipe site </a></p>");
		sb.append("<p>" + dish.getAttribution() + "</p>");
		
		sb.append("</div>");

		return sb.toString();
	}
}
