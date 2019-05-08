package com.sparkmealplanner.spark_meal_planner;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * This class handles the home page of the app
 *
 */
public class HomePageHandler implements Route {

	/**
	 * The following handler method returns the HTML elements of the home page of
	 * the app
	 */
	public Object handle(Request request, Response response) throws Exception {
		return HtmlWriter.gethtmlHead("Meal Planner Home Page")
				+ HtmlWriter.createBodyTitle("Welcome To Our Meal Planner")
				+ HtmlWriter.createAParagraph("This app is designed to make your meal plans easy!") + "<br>"
	//			+ HtmlWriter.createAParagraph("Get started now!")
				+ HtmlWriter.createButton("searchrecipe", "Create a Meal Plan now!") + HtmlWriter.getFooter()
				+ HtmlWriter.closeTag();
	}

}
