package com.sparkmealplanner.spark_meal_planner;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

public class DishTest {

	@Test
	/**
	 * The following method tests the get dish name method based on the dish ID,
	 * when an API is used.
	 */
	public void testGetDishName() {

		// initialize an empt JSON object
		JSONObject recipeJSON = null;

		// create a JSON object from Yummly API Handler class
		try {
			recipeJSON = YummlyAPIHandler.getRecipe("Honey-Bun-Cake-1536635");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// initialize a dish object
		DishReader d = null;
		try {
			d = new DishReader(recipeJSON);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// create a dish object
		Dish dish = d.getDishCreated();
		String expected = "Honey Bun Cake";
		String result = dish.getDishName();
		// System.out.println(result);
		assertEquals(expected, result);
	}
}
