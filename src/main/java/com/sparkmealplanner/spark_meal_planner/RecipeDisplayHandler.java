package com.sparkmealplanner.spark_meal_planner;

import java.util.HashMap;
import java.util.Map.Entry;

import org.json.JSONObject;

import spark.Request;
import spark.Response;
import spark.Route;

public class RecipeDisplayHandler implements Route {

	private String recipeID;
	private final String htmlHead = "<html><head><title>Full Recipe</title></head>";
	JSONObject recipeJSON = null;
	
	public Object handle(Request request, Response response) throws Exception {
		recipeID = request.queryParams("id");
		System.out.println("Search term entered by the user :" + recipeID);
		return htmlHead + "<body><div><h3>Full Recipe <h3></div>" + getFullRecipeWithAPI() +  "</body></html>";
	}

	
	public String getFullRecipeWithAPI() {
		System.out.println("going through API handler: " + recipeID);
		YummlyAPIHandler apiHandler = new YummlyAPIHandler();
		Dish dish = null;

		try {
			apiHandler.getRecipe(recipeID);
			DishReader dr = new DishReader (apiHandler.getGetRecipeJSON());
			dish = dr.getDishCreated();
			System.out.println(dish.getDishName());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		

		StringBuilder sb = new StringBuilder();

		sb.append("<div><ul>");
		sb.append("<li>" + recipeJSON + "<li>" + dish.getCookingTimeInSeconds() + "<li>");
		sb.append("</ul></div>");

		return sb.toString();
	}
}
