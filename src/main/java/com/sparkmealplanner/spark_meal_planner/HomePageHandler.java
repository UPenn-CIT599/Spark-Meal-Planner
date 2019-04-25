package com.sparkmealplanner.spark_meal_planner;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * This class handles the home page of the app
 *
 */
public class HomePageHandler implements Route {

	private final String htmlHead = "<html><head><title>Meal Planner Home Page</title></head>";

	public Object handle(Request request, Response response) throws Exception {
		return htmlHead + "<body style=\"background-color:lightgrey;\">"
				+"<h4>Welcome To Our Meal Planner</h4>"
				+"<p>This app is designed to make your meal planner easy!</p>"
				+"<p>Please select one of the following options to start:</p>"
				+"<button><a href=\"/searchrecipe\"> Search Recipe</a></button><br>"
				+"<button><a href=\"/retrievemealplan\"> Open Saved Meal Plan</a></button>"	
				+"</body></html>";
	}
}
