package com.sparkmealplanner.spark_meal_planner;

import java.util.HashMap;
import java.util.Map.Entry;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * The following class handles the HMTL and java elements of the recipe list
 * display from search page of the app
 *
 */
public class RecipeListDisplayHandler implements Route {

	// instance variables
	private String pageTitle = "Recipe Search List List";
	private String recipeToSearch;
	private String attributionHtml;
	private HashMap<String, String> recipeNameAndDishID;

	/**
	 * The following constructor initializes a HashMap
	 */
	public RecipeListDisplayHandler() {
		recipeToSearch = "";
		attributionHtml = "";
		recipeNameAndDishID = new HashMap<String, String>();
	}

	/**
	 * The following method handles the HMTL and java elements of the recipe list
	 * display from search page of the app
	 */
	public Object handle(Request request, Response response) throws Exception {
		recipeNameAndDishID.clear();

		// storing the parameter from request in a variable
		recipeToSearch = request.queryParams("recipetosearch");

		// returning HTML
		return TagCreator.gethtmlHead("Recipe List") + TagCreator.createBodyTitle(pageTitle) + searchRecipeWithAPI()
				+ addRecipeFromURLButton() + TagCreator.getFooter() + TagCreator.closeTag();
	}

	/**
	 * The following method adds a button to direct users to add recipe from an
	 * external url
	 * 
	 * @return HTML
	 */
	private String addRecipeFromURLButton() {

		StringBuilder sb = new StringBuilder();

		// creating a button in HTML
		sb.append(TagCreator.createButton("addrecipe", "I have a url to add recipe from"));

		return sb.toString();
	}

	/**
	 * The following method searches the API and displays the result
	 * 
	 * @return HTML
	 */
	public String searchRecipeWithAPI() {

		// searching Yummly using the API handler and related attributes
		try {
			YummlyAPIHandler.searchReceipe(recipeToSearch);
			attributionHtml = YummlyAPIHandler.getSearchRecipeAttributionhtml();
			recipeNameAndDishID = YummlyAPIHandler.getRecipeNameAndDishID();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StringBuilder sb = new StringBuilder();

		// creating unordered list to add each recipe
		sb.append("<ul>");

		for (Entry<String, String> recipe : recipeNameAndDishID.entrySet()) {

			String aTag = "<a href=/recipechosen?recipeid=" + recipe.getValue() + ">";

			sb.append("<li>" + aTag + recipe.getKey() + "</a>"

			// each line has a button for adding the recipe to calendar
					+ TagCreator.createButton("addtocalendar", " Send to Calendar", "recipename", recipe.getKey(),
							"recipeid", recipe.getValue(), "recipesearched", recipeToSearch)
					+ "</li>");

		}

		// adding attribution HTML from yummly
		sb.append("<br><br>" + attributionHtml);

		sb.append("</ul><br>");

		return sb.toString();
	}
}
