package com.sparkmealplanner.spark_meal_planner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import spark.Request;
import spark.Response;
import spark.Route;

public class GroceryListHandler implements Route {

	private ArrayList<Dish> listOfDish;
	private HashMap<String, ArrayList<Ingredient>> groceryList;
	private String dishName;
	private ArrayList<Ingredient> listOfIngredients;

	public GroceryListHandler() {
		HashMap<String, Dish> calendarHashMap = CalendarHandler.getCalendarHashMap();
		// loop through the HashMap and create an arrayliList of Dish objects.

	}

	public Object handle(Request request, Response response) throws Exception {
		return TagCreator.gethtmlHead("Grocery List") + "<body><h3>Grocery List</h3>" + displayGroceryList()
				+ "<button><a href=\"/\">Go back to your list</a></button></body></html>" + TagCreator.getFooter();
	}

	public String displayGroceryList() {

		GroceryList grocery = new GroceryList(listOfDish);
		groceryList = grocery.getGroceryListFromListOfDishes();

//		//call the list of dish names
//		Calendar calendar = new Calendar();
//		ArrayList<Dish> listOfDish = new ArrayList<Dish>();
//		ArrayList<String> listOfDishNames = new ArrayList<String>();
////		listOfDishNames = calendar.getCalendar().get(key);

		StringBuilder sb = new StringBuilder();

		sb.append("<div><ul>");

		for (Entry<String, ArrayList<Ingredient>> groceryItems : groceryList.entrySet()) {
			dishName = groceryItems.getKey();
			listOfIngredients = groceryItems.getValue();
			sb.append("<ul><li>" + "<p><b>" + "Dish Name: " + dishName + "</b><p>" + "</li></ul>");
			for (Ingredient eachIngredient : listOfIngredients) {
				sb.append("<ol><li>" + eachIngredient + "<button style=\"margin-left: 10px\" onclick=\""
						+ listOfIngredients.remove(eachIngredient) + "'\">Remove from shopping list</button>"
						+ "</li></ol>");
			}
		}

		return sb.toString();

	}
}
