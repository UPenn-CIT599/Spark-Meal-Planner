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

	/**
	 * The constructor initiate the dish list from the calendar
	 */
	public GroceryListHandler() {
		HashMap<String, Dish> calendarHashMap = CalendarHandler.getCalendarHashMap();
		listOfDish = new ArrayList<Dish>();
		// loop through the HashMap and create an arrayliList of Dish objects.
		for (Entry<String, Dish> mealsCalendar : calendarHashMap.entrySet()) {
			Dish dishOnCalendar = mealsCalendar.getValue();
			if (dishOnCalendar != null) {
				listOfDish.add(dishOnCalendar);
			}
		}
	}

	public Object handle(Request request, Response response) throws Exception {

		return TagCreator.gethtmlHead("Grocery List") + TagCreator.createBodyTitle("Grocery List")
				+ displayGroceryList() + TagCreator.createPrintThisButton() + TagCreator.getFooter()
				+ TagCreator.closeTag();
	}

	/**
	 * The method is to display grocery list after item is selected to calendar
	 * 
	 * @return groceryList
	 */
	public String displayGroceryList() {

		GroceryListHandler glh = new GroceryListHandler();
		GroceryList grocery = new GroceryList(glh.listOfDish);
		groceryList = grocery.getGroceryListFromListOfDishes();

		StringBuilder sb = new StringBuilder();

		sb.append("<div><ul\">");

		for (Entry<String, ArrayList<Ingredient>> groceryItems : groceryList.entrySet()) {
			
			dishName = groceryItems.getKey();
			listOfIngredients = groceryItems.getValue();
			
			sb.append("<li>" + "<p><b>" + "Dish Name: " + dishName + "</b><p>" + "</li>");
			
			for (Ingredient eachIngredient : listOfIngredients) {

				sb.append("<li>" + eachIngredient.getIngredientLine() 
						+"<button style=\"margin-left: 10px\" type=\"submit\">Remove</button>"
						+ "</li>"
						);

				// sb.append("<ol><li>" + eachIngredient
				// + "<button style=\"margin-left: 10px\" onclick=\""
				// + listOfIngredients.remove(eachIngredient)
				// + "'\">Remove from shopping list</button>"
				// + "</li></ol>");
			}

			// sb.append("<div></ul>");
		}

		sb.append("<div><br></ul>");

		return sb.toString();

	}
}