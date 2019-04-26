package com.sparkmealplanner.spark_meal_planner;

import java.util.HashMap;

import spark.Request;
import spark.Response;
import spark.Route;

public class RecipeDisplayHandler implements Route {

	private String recipeToSearch = RecipeSearchHandler.getRecipeToSearch();
	private HashMap<String, String> recipeNameAndDishID;
//	private String recipeID;
	private final String htmlHead = "<html><head><title>Full Recipe</title></head>";

	public RecipeDisplayHandler() {
		recipeNameAndDishID = new HashMap<String, String>();
	}

	public Object handle(Request request, Response response) throws Exception {
		System.out.println(recipeToSearch);
		return htmlHead + "<body><div><h3>Recipe Search List List<h3></div>" + searchRecipeWithAPI()+"</body></html>";
	}

	public String searchRecipeWithAPI() {
//		YummlyAPIHandler apiHandler = new YummlyAPIHandler(recipeToSearch);
		try {
//			recipeNameAndDishID = apiHandler.searchReceipe();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		recipeNameAndDishID.put("1", "Cake1");
		recipeNameAndDishID.put("2", "Cake2");

		StringBuilder sb = new StringBuilder();

		sb.append("<div><ul>");

		for (String recipe : recipeNameAndDishID.keySet()) {
			sb.append("<li>" + recipe
					+ "<button style=\"margin-left: 10px\" onclick=\"location.href='/\\"
					+ "'\">DONE</button></li>");
		}

		sb.append("</ul></div>");

		return sb.toString();
	}
}
