package com.sparkmealplanner.spark_meal_planner;

import static org.junit.Assert.assertEquals;

import org.json.JSONObject;
import org.junit.Test;

/**
 * @author Krishna
 *
 */
public class YummlyAPIHandlerTest {
	
	

	/**
	 * Test method for {@link yummlyAPIHandler#searchReceipe()}. checks for 20 items
	 * in the recipe name and dish ID hashmap
	 */
	@Test
	public void testSearchReceipe() {
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
	public void testGetDishID() throws Exception {
		YummlyAPIHandler apihandler = new YummlyAPIHandler();
		apihandler.searchReceipe("cake");
		System.out.println(apihandler.getRecipeNameAndDishID().toString());

		String dishID = apihandler.getDishID("Honey Bun Cake");
		assertEquals("Honey-Bun-Cake-1536635", dishID);
	}
	
	@Test
	public void testGetJSON() {
		JSONObject j = null;
		try {
			j = YummlyAPIHandler.getRecipe("Creamy-Apple-Cider-Vinaigrette-2651359");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(j.toString());
	}

}
