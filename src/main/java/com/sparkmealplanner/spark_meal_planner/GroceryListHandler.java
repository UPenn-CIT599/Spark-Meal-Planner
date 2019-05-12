package com.sparkmealplanner.spark_meal_planner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * This class handles the Grocery List page of this app
 *
 */
public class GroceryListHandler implements Route {
	// instance variables
	private HashMap<String, Dish> calendarHashMap;
	private int removeItemId;
	private ArrayList<Dish> listOfDish;
	private HashMap<String, ArrayList<Ingredient>> groceryList;
	private String dishName;
	private ArrayList<Ingredient> listOfIngredients;
	private GroceryList grocery;

	/**
	 * The constructor initiate the dish list from the calendar
	 */
	public GroceryListHandler() {
		calendarHashMap = new HashMap<String, Dish>();
		listOfDish = new ArrayList<Dish>();
		groceryList = new HashMap<String, ArrayList<Ingredient>>();
		listOfIngredients = new ArrayList<Ingredient>();
	}

	/**
	 * Method to handle grocery list page
	 */
	public Object handle(Request request, Response response) throws Exception {

		calendarHashMap = CalendarHandler.getCalendarHashMap();
		listOfDish.clear();// clears the list before each request

		// loop through the HashMap and create an arrayliList of Dish objects.
		for (Entry<String, Dish> mealsCalendar : calendarHashMap.entrySet()) {
			if (mealsCalendar.getValue() != null) {
				Dish dishOnCalendar = mealsCalendar.getValue();
				listOfDish.add(dishOnCalendar);
			}
		}

		// storing the parameter from request in a variable
		if ("/removeFromGroceryList".equals(request.pathInfo())) {
			removeItemId = Integer.valueOf(request.queryParams("Id"));
			dishName = request.queryParams("Dish");

			// removes an item from the grocery list
			removefromGroceryList(dishName, removeItemId);
		}

		return HtmlWriter.gethtmlHead("Grocery List") + HtmlWriter.createBodyTitle("Grocery List")
				+ displayGroceryList() + HtmlWriter.createPrintThisButton()
				+ HtmlWriter.createButton("calendar", "Go Back To Calendar") + HtmlWriter.getFooter()
				+ HtmlWriter.closeTag();
	}

	/**
	 * The method is to display grocery list after item is selected to calendar
	 * 
	 * @return groceryList
	 */
	public String displayGroceryList() {
		// create a new grocery list object every time a request is made
		grocery = new GroceryList(listOfDish);
		// get a new list of dish from the calendar every time the request is made
		groceryList = grocery.getGroceryListFromListOfDishes();
		StringBuilder sb = new StringBuilder();

		sb.append("<div><ul style=\"list-style-type:disc;\">");// unordered list

		for (Entry<String, ArrayList<Ingredient>> groceryItems : groceryList.entrySet()) {

			dishName = groceryItems.getKey();
			listOfIngredients = groceryItems.getValue();

			sb.append("<p><b>" + "Dish Name: " + dishName + "</b><p>");

			int Id = 0;

			for (Ingredient eachIngredient : listOfIngredients) {

				if (eachIngredient != null) {

					sb.append("<li>" + eachIngredient.getIngredientLine() + "        " + HtmlWriter.createButton(
							"removeFromGroceryList", "Remove", "Dish", dishName, "Id", String.valueOf(Id)) + "</li>"

					);
				}
				Id++;
			}

		}

		sb.append("<div><br></ul>");

		return sb.toString();

	}

	/**
	 * The method is to display grocery list after item is removed from grocery list
	 */
	public void removefromGroceryList(String dishName, int removeItemId) {
		grocery.removeIngredientsFromGroceryList(groceryList, dishName, removeItemId);
	}

}
