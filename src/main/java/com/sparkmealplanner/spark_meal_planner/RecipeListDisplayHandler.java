package com.sparkmealplanner.spark_meal_planner;

import java.util.HashMap;
import java.util.Map.Entry;

import spark.Request;
import spark.Response;
import spark.Route;

public class RecipeListDisplayHandler implements Route {

	private String recipeToSearch;
	private HashMap<String, String> recipeNameAndDishID;
	private final String htmlHead = "<html><head><title>Full Recipe</title></head>";

	public RecipeListDisplayHandler() {
		recipeNameAndDishID = new HashMap<String, String>();
	}

	public Object handle(Request request, Response response) throws Exception {
		
		if ("/displayrecipelist".equals(request.pathInfo())) {
			recipeToSearch= request.queryParams("recipetosearch");
			//System.out.println("Search term entered by the user :" + recipeToSearch);
		}		
		
		return htmlHead + "<body><div><h3>Recipe Search List List<h3></div>" + searchRecipeWithAPI()+"</body></html>";
	}

	public String searchRecipeWithAPI() {
		System.out.println("going through API handler: " + recipeToSearch);
		YummlyAPIHandler apiHandler = new YummlyAPIHandler();
		
		try {
			apiHandler.searchReceipe(recipeToSearch);
			recipeNameAndDishID = apiHandler.getRecipeNameAndDishID();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		for (Entry <String, String>  recipe : recipeNameAndDishID.entrySet()) {
//			System.out.println(recipe.getKey());
//		}

		StringBuilder sb = new StringBuilder();

		sb.append("<div><ul>");

		for (Entry <String, String>  recipe : recipeNameAndDishID.entrySet()) {
			sb.append("<li>" + recipe.getKey()
					+ "<button style=\"margin-left: 10px\" onclick=\"location.href='/recipechosen?id=" + recipe.getValue() + "'\">Show Full Recipe</button>"
					+ "<button style=\"margin-left: 10px\" onclick=\"location.href='/recipechosen?id=" + recipe.getValue() + "'\">Add to Calendar</button>");
		}

		sb.append("</ul></div>");

		return sb.toString();
	}
}
