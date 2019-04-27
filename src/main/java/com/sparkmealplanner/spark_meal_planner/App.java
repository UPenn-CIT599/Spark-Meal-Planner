package com.sparkmealplanner.spark_meal_planner;

import static spark.Spark.get;
import static spark.Spark.port;


/**
 * This class contains the main method and can be program can be run from this
 * class
 *
 */
public class App {
	public static void main(String[] args) {
		MealPlanner mp = new MealPlanner();
		mp.run();
		
		//Vineela the following is already in the meal planner class where the app logic is contained.

//		CalendarHandler calendarHandler = new CalendarHandler();
//		HomePageHandler homePageHandler = new HomePageHandler();
//		port(8080);
//		get("/",homePageHandler);
//		get("/Calendar", calendarHandler);
	}
}
