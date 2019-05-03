package com.sparkmealplanner.spark_meal_planner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import spark.Request;
import spark.Response;
import spark.Route;

public class GroceryListHandler implements Route {
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
		
		//storing the parameter from request in a variable
		
		if ("/removeFromGroceryList".equals(request.pathInfo())) {
			removeItemId = Integer.valueOf(request.queryParams("Id"));
			dishName = request.queryParams("Dish");
			removefromGroceryList(dishName, removeItemId);
		}

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
		grocery = new GroceryList(glh.listOfDish);
		groceryList = grocery.getGroceryListFromListOfDishes();

		StringBuilder sb = new StringBuilder();

		sb.append("<div><ul style=\\\"list-style-type:disc;\\\">");

		for (Entry<String, ArrayList<Ingredient>> groceryItems : groceryList.entrySet()) {
			
			dishName = groceryItems.getKey();
			listOfIngredients = groceryItems.getValue();
			
			sb.append( "<p><b>" + "Dish Name: " + dishName + "</b><p>");
			
			int Id=0;
			
			for (Ingredient eachIngredient : listOfIngredients) {

				if(eachIngredient!=null) {
					
					sb.append("<li>" + eachIngredient.getIngredientLine() 
//					+"<button style=\"margin-left: 10px\" type=\"submit\">Remove</button>"
//					+"<button style=\"margin-left: 10px\" onclick=\"location.href='/removeItem?name" + "'\"type=\\\"submit\\\">Remove</button>" 
					+ "        "
					+ TagCreator.createButton("removeFromGroceryList", "Remove", "Dish",dishName,"Id", String.valueOf(Id))
					+ "</li>"
					
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
