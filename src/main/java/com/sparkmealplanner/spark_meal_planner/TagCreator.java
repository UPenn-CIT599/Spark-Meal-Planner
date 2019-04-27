package com.sparkmealplanner.spark_meal_planner;

public class TagCreator {

	private static final String GoToHome = "<br><br><a href=\"/\">Home </a>";
	private static final String GoToCalendar = "<a href=\"/calendar\">| Calendar </a>";
	private static final String GoToGroceryList = "<a href=\"/grocerylist\">| GroceryList </a>";
	private static final String GoToSearchRecipe = "<a href=\"/searchrecipe\">| Search Recipes </a>";

	//the following method creates the head tag for HTML based on the user title
	public static String gethtmlHead(String titleText) {
		return "<html><head><title>"+titleText +"</title></head>";
	}
	
	public static String getFooter() {
		return GoToHome
				+ GoToCalendar
				+ GoToGroceryList
				+ GoToSearchRecipe;
	}
}
