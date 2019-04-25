package com.sparkmealplanner.spark_meal_planner;

import spark.Request;
import spark.Response;
import spark.Route;

public class CalendarHandler implements Route {

	private final String htmlHead = "<html><head><title>Meal Planner Calendar</title></head>";
	public Object handle(Request request, Response response) throws Exception {
		return htmlHead + "<body><h3>Meal Planner Calendar</h3>"+
	"<button><a href=\"/todo\">Go back to your list</a></button></body></html>";
	}
}
