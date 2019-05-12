package com.sparkmealplanner.spark_meal_planner;

import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * The following class handles the HMTL and java elements of the full recipe
 * display of the app
 *
 */
public class RecipeDisplayHandler implements Route {

	// instance variables
	private String recipeID;
	JSONObject recipeJSON = null;
	static Dish dish = null;

	/**
	 * The following handler method returns the HTML elements of the display full
	 * recipe page of the app
	 */
	public Object handle(Request request, Response response) throws Exception {

		// storing the parameter in a variable
		recipeID = request.queryParams("recipeid");

		// returning html elements
		return HtmlWriter.gethtmlHead("Full Recipe") + HtmlWriter.createBodyTitle("Full Recipe")
				+ getFullRecipeWithAPI() + sendToCalendar() + HtmlWriter.getFooter() + HtmlWriter.closeTag();
	}

	/**
	 * The following method returns the HTML elements for the send to calendar
	 * button
	 * 
	 * @return HTML
	 */
	private String sendToCalendar() {
		return HtmlWriter.createButton("addtocalendar", "Send to Calendar", "recipename", dish.getDishName(),
				"recipeid", recipeID);
	}

	/**
	 * The following method returns the Dish object in a static manner, so another
	 * page can obtain it
	 * 
	 * @return the dish
	 */
	public static Dish getDishFromFullRecipeView() {
		return dish;
	}

	/**
	 * The following method returns the HTML elements necessary to get and display
	 * the full recipe from Yummly API
	 * 
	 * @return HTML
	 */
	private String getFullRecipeWithAPI() {

		// initialization of variables
		String recipeStepsURL = "";
		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

		try {

			// get JSON and recipe url using the YummlyAPIHandler class
			YummlyAPIHandler.getRecipe(recipeID);
			JSONObject recipeJSON = YummlyAPIHandler.getGetRecipeJSON(recipeID);
			JSONObject source = recipeJSON.getJSONObject("source");
			recipeStepsURL = (String) source.get("sourceRecipeUrl");

			// create a dish object using the dish reader class
			DishReader dr = new DishReader(YummlyAPIHandler.getGetRecipeJSON(recipeID));
			dish = dr.getDishCreated();

			// get dish ingredients to show
			ingredients = dish.getIngredients();

		} catch (JSONException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

		// creating StringBuilder for HTML elements
		StringBuilder sb = new StringBuilder();

		sb.append("<div>");

		// display recipe attributes in HTML
		sb.append("<p> Recipe Name: " + dish.getDishName() + "</p>");
		sb.append("<p> Recipe Serving Size: " + dish.getNumOfPeopleToServe() + "</p>");
		sb.append("<p> Cooking time in minutes: " + (int) dish.getCookingTimeInSeconds() / 60 + "</p>");
		sb.append("<p> Ingredients: </p>");

		// display recipe ingredients in HTML in an unordered list
		sb.append("<ul>");

		for (Ingredient ingredient : ingredients) {
			// System.out.println(ingredient.getIngredientLine());
			sb.append("<li>" + ingredient.getIngredientLine() + "</li>");
		}
		sb.append("</ul>");

		// display original recipe url HTML anchor tag
		sb.append("<p><a href=\"" + dish.getCookingStepsURL()
				+ "\"target=\"_blank\">Visit original recipe site </a></p>");
		sb.append("<p>" + dish.getAttribution() + "</p>");

		sb.append("</div>");

		return sb.toString();
	}
}
