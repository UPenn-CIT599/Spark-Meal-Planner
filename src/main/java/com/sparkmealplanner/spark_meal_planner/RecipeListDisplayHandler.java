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
//					+ "<button style=\"margin-left: 10px\" onclick=\"location.href='/recipechosen?id="
//					+ recipe.getValue()
//					+ "'\">Show Full Recipe</button>" 
					+ TagCreator.createButton("recipechosen", " Show Full Recipe", "recipeid", recipe.getValue())
					+ TagCreator.createButton("calendar", "Send to Calendar", "recipename",recipe.getKey(),"recipeid", recipe.getValue())
					
					
//					+ "<form action=\"/calendar\"method=\"get\">"
//					+ "<select id=\"dayandmeal\" name=\"calendar_day_and_meal\">"
//					+ "<option value=\"\" selected=\"selected\" >Select a Calendar Option</option>"
//					+ "<option value=\"monday_breakfast\" >Monday Breakfast</option>"
//					+ "<option value=\"monday_lunch\" >Monday Lunch</option>"
//					+ "<option value=\"monday_snack\" >Monday Snack</option>"
//					+ "<option value=\"monday_dinner\" >Monday Dinner</option>"
//					+ "<option value=\"tuesday_breakfast\" >Tuesday Breakfast</option>"
//					+ "<option value=\"tuesday_lunch\" >Tuesday Lunch</option>"
//					+ "<option value=\"tuesday_snack\" >Tuesday Snack</option>"
//					+ "<option value=\"tuesday_dinner\" >Tuesday Dinner</option>"
//					+ "<option value=\"wednesday_breakfast\" >Wednesday Breakfast</option>"
//					+ "<option value=\"wednesday_lunch\" >Wednesday Lunch</option>"
//					+ "<option value=\"wednesday_snack\" >Wednesday Snack</option>"
//					+ "<option value=\"wednesday_dinner\" >Wednesday Dinner</option>"
//					+ "<option value=\"thursday_breakfast\" >Thursday Breakfast</option>"
//					+ "<option value=\"thursday_lunch\" >Thursday Lunch</option>"
//					+ "<option value=\"thursday_snack\" >Thursday Snack</option>"
//					+ "<option value=\"thursday_dinner\" >Thursday Dinner</option>"
//					+ "<option value=\"friday_breakfast\" >Friday Breakfast</option>"
//					+ "<option value=\"friday_lunch\" >Friday Lunch</option>"
//					+ "<option value=\"friday_snack\" >Friday Snack</option>"
//					+ "<option value=\"friday_dinner\" >Friday Dinner</option>"
//					+ "<option value=\"saturday_breakfast\" >Saturday Breakfast</option>"
//					+ "<option value=\"saturday_lunch\" >Saturday Lunch</option>"
//					+ "<option value=\"saturday_snack\" >Saturday Snack</option>"
//					+ "<option value=\"saturday_dinner\" >Saturday Dinner</option>"
//					+ "<option value=\"sunday_breakfast\" >Sunday Breakfast</option>"
//					+ "<option value=\"sunday_lunch\" >Sunday Lunch</option>"
//					+ "<option value=\"sunday_snack\" >Sunday Snack</option>"
//					+ "<option value=\"sunday_dinner\" >Sunday Dinner</option>" 
//					+ "</select>" 
//					+ "<button style=\"margin-left: 10px\" type=\"submit\">Add</button></form></li>"
					);
		}

		sb.append(attributionHtml);
		// System.out.println( attributionHtml);

		sb.append("</ul><br></div>");

		return sb.toString();
	}
}
