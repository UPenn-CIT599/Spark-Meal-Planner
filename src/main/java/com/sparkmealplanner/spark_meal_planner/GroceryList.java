package com.sparkmealplanner.spark_meal_planner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * This class contains the grocery list and related methods and properties.
 * grocery list contains list of ingredient (included in the ingredient lines)
 * by each dish
 */
public class GroceryList {

	// instance variables
	private String dishName;
	private ArrayList<Dish> listOfDish;
	private ArrayList<Ingredient> listOfIngredients;
	private HashMap<String, ArrayList<Ingredient>> groceryList;

	/**
	 * 
	 * The following constructor creates a grocery list item
	 * 
	 * @param listOfDish dish list
	 */
	public GroceryList(ArrayList<Dish> listOfDish) {
		this.listOfDish = listOfDish;
	}

	/**
	 * Adding the default constructor.
	 */
	public GroceryList() {

	}

	/**
	 * The following method loops through the ArrayList of dishes for the week and
	 * creates a HashMap that holds the dish names and maps to their ingredients
	 * 
	 * @return groceryListHashMap
	 */
	public HashMap<String, ArrayList<Ingredient>> getGroceryListFromListOfDishes() {

		groceryList = new HashMap<String, ArrayList<Ingredient>>();

		for (Dish dish : listOfDish) {
			// getting dish information and storing in a HashMap
			dishName = dish.getDishName();
			listOfIngredients = dish.getIngredients();
			groceryList.put(dishName, listOfIngredients);
		}

		return groceryList;
	}

	/**
	 * 
	 * Given a grocery list, the following method removes an item based on the
	 * ingredient line
	 * 
	 * @param groceryList      grocery list to modify
	 * @param DishNameToChange dish name for the ingredient change
	 * @param ingredientLine   ingredient that need to be removed from grocery list
	 */
	public void removeIngredientsFromGroceryList(HashMap<String, ArrayList<Ingredient>> groceryList,
			String DishNameToChange, int ingredientId) {

		// loop through hashmap to find the dish to change and the item in the arraylist
		for (Entry<String, ArrayList<Ingredient>> groceryItems : groceryList.entrySet()) {

			// when the dish name in hashmap is the same as the dish we want to change
			if (DishNameToChange.equals(groceryItems.getKey())) {

				// setting the list of ingredients
				listOfIngredients = groceryList.get(DishNameToChange);

				// loop through the ingredients list to remove unwanted item
				for (int i = 0; i < listOfIngredients.size(); i++) {
					if (ingredientId == i) {
						listOfIngredients.remove(ingredientId);
					}
				}
			}
		}
	}

}
