package com.sparkmealplanner.spark_meal_planner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GroceryListTest {

	static ArrayList<Dish> listOfDish;
	static HashMap<String, ArrayList<Ingredient>> groceryList;
	static GroceryList gList;
	static ArrayList<String> groceryListDishLines;
	static ArrayList<String> groceryListDish1Lines;
	static ArrayList<String> groceryListDish2Lines;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		// @Before
		// public void setUp() throws Exception {

		// set ingredients for dish1
		Ingredient ingredient1 = new Ingredient("3 pounds of apples");
		Ingredient ingredient2 = new Ingredient("1 cup of water");
		Ingredient ingredient3 = new Ingredient("1 1/2 cups of sugar");
		Ingredient ingredient4 = new Ingredient("juice of 1 lemon");
		// set ingredients for dish2
		Ingredient ingredient5 = new Ingredient("1 box of butter cake mix");
		Ingredient ingredient6 = new Ingredient("2 cups sugar");
		Ingredient ingredient7 = new Ingredient("16 oz cantainer sour cream");
		Ingredient ingredient8 = new Ingredient("14 oz bag sweetened coconut");
		Ingredient ingredient9 = new Ingredient("12 oz container cool whip, thawed");

		// set ingredients for dish1
		ArrayList<Ingredient> dish1Ingredients = new ArrayList<Ingredient>(
				Arrays.asList(new Ingredient[] { ingredient1, ingredient2, ingredient3, ingredient4 }));
		// set ingredients for dish1
		ArrayList<Ingredient> dish2Ingredients = new ArrayList<Ingredient>(
				Arrays.asList(new Ingredient[] { ingredient5, ingredient6, ingredient7, ingredient8, ingredient9 }));

		// set dish1
		Dish dish1 = new Dish("Apple Jellies", dish1Ingredients, "http://www.lottieanddoof.com/2008/10/apple-jellies/",
				105, 4);
		// set dish2
		Dish dish2 = new Dish("Coconut Cake", dish2Ingredients,
				"https://www.plainchicken.com/2019/04/coconut-cake.html", 40, 11);

		// add dish1 and dish2 to the list of dishes
		listOfDish = new ArrayList<Dish>(Arrays.asList(new Dish[] { dish1, dish2 }));

		// Create a new GroceryList object
		gList = new GroceryList(listOfDish);

		// add dishes to grocery list
		groceryList = gList.getGroceryListFromListOfDishes();

	}

	/**
	 * The test is to test if both dishes are added the dish list
	 */
	@Test
	public void testAllDishesAddtoDishList() {

		assertEquals(2, listOfDish.size());
	}

	/**
	 * Two tests to test GetGroceryListFromListOfDishes This is part 1: to test out
	 * HashMap GroceryList key Key is the dish name
	 */
	@Test
	public void testGetGroceryListFromListOfDishes_TestGroceryListKey() {

		// test if both dishes are added to grocery list
		assertEquals(2, groceryList.size());

		// add dish names in the grocery list to an ArrayList to test
		ArrayList<String> dishNames = new ArrayList<String>();
		for (String dishName : groceryList.keySet()) {
			dishNames.add(dishName);
		}
		// test if both dishes are in grocery list
		// test HashMap key
		assertEquals("Apple Jellies", dishNames.get(0));
		assertEquals("Coconut Cake", dishNames.get(1));
	}

	/**
	 * The method is to read the Ingredient ArrayList in groceryList hashmap, to
	 * return a String ArrayList for testing
	 * 
	 * @param dishInGroceryList
	 * @return groceryListDishLines
	 */
	public ArrayList<String> getGroceryListString(String dishInGroceryList) {

		// get groceryList for dish "Apple Jellies"
		groceryListDishLines = new ArrayList<String>();
		// loop through the dish select and return the name of each grocery item
		// (Ingredient line)
		for (Ingredient ingredientLines : groceryList.get(dishInGroceryList)) {
			groceryListDishLines.add(ingredientLines.getIngredientLine());
		}

		return groceryListDishLines;

	}

	/**
	 * Two tests to test GetGroceryListFromListOfDishes This is part 2: to test out
	 * HashMap GroceryList Value Value is the ingredients ArrayList
	 */
	@Test
	public void testGetGroceryListFromListOfDishes_TestGroceryListValue() {

		groceryListDish1Lines = getGroceryListString("Apple Jellies");
		groceryListDish2Lines = getGroceryListString("Coconut Cake");

		// test HashMap Value of Dish 1
		assertEquals(Arrays.asList("3 pounds of apples", "1 cup of water", "1 1/2 cups of sugar", "juice of 1 lemon"),
				groceryListDish1Lines);

		// test HashMap Value of Dish 2
		assertEquals(Arrays.asList("1 box of butter cake mix", "2 cups sugar", "16 oz cantainer sour cream",
				"14 oz bag sweetened coconut", "12 oz container cool whip, thawed"), groceryListDish2Lines);
	}

}
