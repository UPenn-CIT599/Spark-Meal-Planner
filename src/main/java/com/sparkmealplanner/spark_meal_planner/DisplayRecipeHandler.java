package com.sparkmealplanner.spark_meal_planner;

import spark.Request;
import spark.Response;
import spark.Route;

public class DisplayRecipeHandler implements Route {

	private final String htmlHead = "<html><head><title>Full Recipe</title></head>";
	public Object handle(Request request, Response response) throws Exception {
		return htmlHead + "<body><h3>Grocery List</h3>"+
	"<button><a href=\"/\">Go back to your list</a></button></body></html>";
	}
}
