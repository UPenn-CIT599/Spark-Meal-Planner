package com.sparkmealplanner.spark_meal_planner;

import java.util.HashMap;
import java.util.Map.Entry;

import spark.Request;
import spark.Response;
import spark.Route;

public class RecipeListDisplayHandler implements Route {

	private String pageTitle = "Recipe Search List List";
	private String recipeToSearch;
	private String attributionHtml;
	private HashMap<String, String> recipeNameAndDishID;

	public RecipeListDisplayHandler() {
		recipeNameAndDishID = new HashMap<String, String>();
	}

	public Object handle(Request request, Response response) throws Exception {

		recipeToSearch = request.queryParams("recipetosearch");
		// System.out.println("Search term entered by the user :" + recipeToSearch);
		
		return TagCreator.gethtmlHead("Recipe List") 
				+TagCreator.createBodyTitle(pageTitle)
				+ searchRecipeWithAPI()
				+ addRecipeFromURL()
				+ TagCreator.getFooter() 
				+ TagCreator.closeTag();
	}

	private String addRecipeFromURL() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(TagCreator.createButton("addrecipe", "I have a url to add recipe from"));
		
		return sb.toString();
	}

	public String searchRecipeWithAPI() {
		// System.out.println("going through API handler: " + recipeToSearch);
		YummlyAPIHandler apiHandler = new YummlyAPIHandler();

		try {
			apiHandler.searchReceipe(recipeToSearch);
			attributionHtml = apiHandler.getSearchRecipeAttributionhtml();
			recipeNameAndDishID = apiHandler.getRecipeNameAndDishID();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StringBuilder sb = new StringBuilder();

		sb.append("<div><ul>");

		for (Entry<String, String> recipe : recipeNameAndDishID.entrySet()) {
			sb.append("<li>" + recipe.getKey()
					+ TagCreator.createButton("recipechosen", " Show Full Recipe", "recipeid", recipe.getValue())
					+ TagCreator.createButton("calendar", "Send to Calendar", "recipename",recipe.getKey(),"recipeid", recipe.getValue())					
					);
		}

		sb.append(attributionHtml);
		// System.out.println( attributionHtml);

		sb.append("</ul><br></div>");

		return sb.toString();
	}
}
