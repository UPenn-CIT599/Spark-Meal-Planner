package com.sparkmealplanner.spark_meal_planner;

import spark.Request;
import spark.Response;
import spark.Route;

public class GroceryListHandler implements Route {

	public Object handle(Request request, Response response) throws Exception {
		return TagCreator.gethtmlHead("Grocery List") 
				+ "<body><h3>Grocery List</h3>"+
				"<button><a href=\"/\">Go back to your list</a></button></body></html>"
				+TagCreator.getFooter()
				+TagCreator.closeTag();
	}
}
