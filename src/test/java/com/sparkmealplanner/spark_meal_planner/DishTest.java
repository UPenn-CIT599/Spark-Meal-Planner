package com.sparkmealplanner.spark_meal_planner;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

public class DishTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetDishName() {
	 YummlyAPIHandler api = new YummlyAPIHandler();
	 JSONObject recipeJSON = null;
	 try {
		recipeJSON = api.getRecipe("Honey-Bun-Cake-1536635");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 DishReader d = null;
	 try {
		d = new DishReader (recipeJSON);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 Dish dish = d.getDishCreated();
	 System.out.println(dish.getDishName());
	}

	@Test
	public void testGetIngredients() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCookingStepsURL() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCookingTimeInSeconds() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumOfPeopleToServe() {
		fail("Not yet implemented");
	}

	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

}
