package com.sparkmealplanner.spark_meal_planner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class contains the grocery list and related methods and properties.
 * grocery list contains list of ingredients, along with their quantities by
 * each dish
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
		getGroceryListFromListOfDishes();
	}

	/**
	 * The following method loops through the ArrayList of dishes for the week and
	 * creates a HashMap that holds the dish names and maps to their ingredients
	 */
	private void getGroceryListFromListOfDishes() {

		groceryList = new HashMap<String, ArrayList<Ingredient>>();

		for (Dish dish : listOfDish) {
			dishName = dish.getDishName();
			listOfIngredients = dish.getIngredients();
			groceryList.put(dishName, listOfIngredients);
		}
	}

	/**
	 * 
	 * Given a grocery list, the following method removed an item based on the
	 * item's index number
	 * 
	 * @param groceryList grocery list to modify 
	 * @param DishNameToChange dish name for the ingredient change
	 * @param indexOfTheItemToBeRemoved index of the item to be removed
	 */
	public void removeIngredientsFromGroceryList(HashMap<String, ArrayList<Ingredient>> groceryList,
			String DishNameToChange, String ingredientLine) {

		// setting the list of ingredients
		listOfIngredients = groceryList.get(DishNameToChange);

	}

	/**
	 * The following method displays the final grocery list, along with an index
	 * starting with 1 1. Apples 2. Bananas
	 */
	public void displayGroceryList() {
		/*
		 * we will utilize GUI for displaying
		 */
	}

}
