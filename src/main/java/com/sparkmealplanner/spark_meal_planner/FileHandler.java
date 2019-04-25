package com.sparkmealplanner.spark_meal_planner;

import spark.Request;
import spark.Response;
import spark.Route;

public class FileHandler implements Route {

	private final String htmlHead = "<html><head><title>To Do List By 591</title></head>";
	public Object handle(Request request, Response response) throws Exception {
		return htmlHead + "<body><h3>Good Job!!</h3>"+
	"<button><a href=\"/\">Go back to your list</a></button></body></html>";
	}
}
