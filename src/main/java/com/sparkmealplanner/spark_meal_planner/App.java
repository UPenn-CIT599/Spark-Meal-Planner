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
}
