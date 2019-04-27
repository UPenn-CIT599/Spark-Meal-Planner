package com.sparkmealplanner.spark_meal_planner;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Krishna
 *
 */
class YummlyAPIHandlerTest {

	/**
	 * Test method for {@link yummlyAPIHandler#searchReceipe()}. checks for 20 items
	 * in the recipe name and dish ID hashmap
	 */
	@Test
	void testSearchReceipe() {
		YummlyAPIHandler apihandler = new YummlyAPIHandler();
		try {
			apihandler.searchReceipe("cake");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int listSize = apihandler.getRecipeNameAndDishID().size();
		assertEquals(listSize, 20);
	}

	/**
	 * Test method for {@link yummlyAPIHandler#getDishID(java.lang.String)}.
	 * 
	 * @throws Exception checks for the correct dishID for a recipe name
	 */
	@Test
	void testGetDishID() throws Exception {
		YummlyAPIHandler apihandler = new YummlyAPIHandler();
		apihandler.searchReceipe("cake");
		System.out.println(apihandler.getRecipeNameAndDishID().toString());

		String dishID = apihandler.getDishID("Honey Bun Cake");
		assertEquals("Honey-Bun-Cake-1536635", dishID);
	}

}
