/**
 * 
 */
package com.sparkmealplanner.spark_meal_planner;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * The following JUNIT tests will test whether the methods returns correct HTML
 * code.
 */
public class TagCreatorTest {

	/**
	 * Test method for
	 * {@link com.sparkmealplanner.spark_meal_planner.TagCreator#getFooter()}.
	 */
	@Test
	public void testGetFooter() {
		String result = TagCreator.getFooter();
		// System.out.println(result);
		String expected = "<div class=\"navbar\">" + "<a href=\"/\"> Home </a>"
				+ "<a href=\"/addtocalendar\"> Calendar </a>" + "<a href=\"/grocerylist\"> GroceryList </a>"
				+ "<a href=\"/searchrecipe\"> Search Recipes </a>"
				+ "<a href=\"/addnewrecipe\"> Add Recipes From URLs </a>"
				+ "<a href=\"/faqs\"> Frequently Asked Questions </a></div>";
		assertEquals(expected, result);

	}

	/**
	 * Test method for
	 * {@link com.sparkmealplanner.spark_meal_planner.TagCreator#createButton(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCreateButtonWithNoParameters() {
		String result = TagCreator.createButton("home", "Home");
		// System.out.println(result);
		String expected = "<button class=\"button\" type=\"button\" onclick=\"location.href='/home'\">Home</button>";		
		assertEquals(expected, result);

	}

	/**
	 * Test method for
	 * {@link com.sparkmealplanner.spark_meal_planner.TagCreator#createButton(java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCreateButtonWithOneParameters() {
		String result = TagCreator.createButton("location1", "Location 1", "Param1", "Param1Info");
//		System.out.println(result);
		String expected = "<button class=\"button\" type=\"button\" onclick=\"location.href='/location1?Param1=Param1Info'\">Location 1</button>";
		assertEquals(expected, result);
	}

	/**
	 * Test method for
	 * {@link com.sparkmealplanner.spark_meal_planner.TagCreator#createButton(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCreateButtonWithTwoParameters() {
		String result = TagCreator.createButton("location1", "Location 1", "Param1", "Param1Info", "Param2",
				"Param2Info");
//		System.out.println(result);
		String expected = "<button class=\"button\" type=\"button\" onclick=\"location.href='/location1?Param1=Param1Info&Param2=Param2Info'\">Location 1</button>";
		assertEquals(expected, result);
	}

	/**
	 * Test method for
	 * {@link com.sparkmealplanner.spark_meal_planner.TagCreator#createButton(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testCreateButtonWithThreeParameters() {
		String result = TagCreator.createButton("location1", "Location 1", "Param1", "Param1Info", "Param2",
				"Param2Info", "Param3", "Param3Info");
		// System.out.println(result);
		String expected = "<button class=\"button\" type=\"button\" onclick=\"location.href='/location1?Param1=Param1Info&Param2=Param2Info&Param3=Param3Info'\">Location 1</button>";
		
		assertEquals(expected, result);

	}

	/**
	 * Test method for
	 * {@link com.sparkmealplanner.spark_meal_planner.TagCreator#createBodyTitle(java.lang.String)}.
	 */
	@Test
	public void testCreateBodyTitle() {
		String result = TagCreator.createBodyTitle("Title");
//		System.out.println(result);
		String expected = "<body><br><br><h3>Title</h3>";
		assertEquals(expected, result);

	}

	/**
	 * Test method for
	 * {@link com.sparkmealplanner.spark_meal_planner.TagCreator#createAParagraph(java.lang.String)}.
	 */
	@Test
	public void testCreateAParagraph() {
		String result = TagCreator.createAParagraph("This is a paragraph");
//		System.out.println(result);
		String expected = "<p>This is a paragraph</p>";
		assertEquals(expected, result);
	}

	/**
	 * Test method for
	 * {@link com.sparkmealplanner.spark_meal_planner.TagCreator#createPrintThisButton()}.
	 */
	@Test
	public void testCreatePrintThisButton() {
		String result = TagCreator.createPrintThisButton();
		// System.out.println(result);
		String expected = "<button class=\"button\" onclick=\"window.print()\">Print This Page</button>";
		assertEquals(expected, result);

	}

	/**
	 * Test method for
	 * {@link com.sparkmealplanner.spark_meal_planner.TagCreator#closeTag()}.
	 */
	@Test
	public void testCloseTag() {
		String result = TagCreator.closeTag();
		// System.out.println(result);
		String expected = "</body></html>";
		assertEquals(expected, result);

	}

}
