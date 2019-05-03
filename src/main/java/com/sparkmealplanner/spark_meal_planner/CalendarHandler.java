package com.sparkmealplanner.spark_meal_planner;

import java.util.HashMap;
import java.util.Map.Entry;
import org.json.JSONObject;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * The following class handles the calendar display page and related HTML or
 * java elements
 *
 */
public class CalendarHandler implements Route {

	// instance variable to be used in the handler class
	static Calendar calendar = new Calendar();
	static HashMap<String, Dish> calendarHashMap = calendar.getCalendar();
	JSONObject json = null;
	HashMap<String, String> calendarToDisplayHashMap = calendar.getCalendarToDisplay();
	Dish dish = null;
	private String recipeToAdd;
	private String recipeIDToAdd;
	String dayAndMealSelected;

	/**
	 * The static getter method to be used in the grocery list class
	 * 
	 * @return the calendarHashMap
	 */
	public static HashMap<String, Dish> getCalendarHashMap() {
		return calendarHashMap;
	}

	/**
	 * Method handler to implement the route class
	 */
	public Object handle(Request request, Response response) throws Exception {

		// if the url was directed to "/addtocalendar"
		if ("/addtocalendar".equals(request.pathInfo())) {

			// if the recipe name parameter is not empty, the value is stored in a variable
			if (request.queryParams("recipename") != null) {
				recipeToAdd = request.queryParams("recipename");
			}

			// if the recipe id parameter is not empty, the value is stored in a variable
			if (request.queryParams("recipeid") != null) {
				recipeIDToAdd = request.queryParams("recipeid");

				// creating a JSON object to create a new dish to be stored in the calendar
				// hashmap
				json = YummlyAPIHandler.getRecipe(recipeIDToAdd);
			}

			try {
				// using dishreader class, create a dish from JSON derived
				DishReader dr = new DishReader(json);
				dish = dr.getDishCreated();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// if the url was directed to "/addtocalendar"
		if ("/addmanualrecipetocalendar".equals(request.pathInfo())) {

			// if the recipe name parameter is not empty, the value is stored in a variable
			if (request.queryParams("recipename") != null) {
				recipeToAdd = request.queryParams("recipename");
			}
			// a dish object is created and stored
			dish = ManualRecipeInputHandler.getManDish();
		}

		// if the url directs to "/selectameal"
		if ("/selectameal".equals(request.pathInfo())) {

			// if calendar option (day+meal) parameter is not empty, the value is stored in
			// a variable
			if (request.queryParams("calendaroption") != null) {
				dayAndMealSelected = request.queryParams("calendaroption");

				// the variable is added to the HashMaps
				calendarHashMap.put(dayAndMealSelected, dish);
				calendarToDisplayHashMap.put(dayAndMealSelected, recipeToAdd);
			}
		}

		// if the user pressed the remove button, the following url path is reached
		if ("/removefromcalendar".equals(request.pathInfo())) {

			// parameter value is stored below if it is not empty
			if (request.queryParams("calendaroption") != null) {
				dayAndMealSelected = request.queryParams("calendaroption");

				// variable value is used to update the HashMaps below
				calendarHashMap.put(dayAndMealSelected, null);
				calendarToDisplayHashMap.put(dayAndMealSelected, "");
			}
		}

		// returns various HTML parts
		return TagCreator.gethtmlHead("Meal Planner Calendar") + TagCreator.createBodyTitle("Calendar")
				+ displayCalendar() + displayRecipeSelected() + displayAddToCalendarOptions()
				+ displayRemoveFromCalendarOptions() + TagCreator.createPrintThisButton() + displayGoToGroceryListButton()+ TagCreator.getFooter()
				+ TagCreator.closeTag();
	}

	public String displayGoToGroceryListButton() {
		return TagCreator.createButton("grocerylist", "Show Grocery List");
	}
	/**
	 * The following method creates the calendar to be displayed in HTML
	 * 
	 * @return calendar calendar to display
	 */
	private String displayCalendar() {
		// get stored HashMaps
		calendarHashMap = calendar.getCalendar();
		calendarToDisplayHashMap = calendar.getCalendarToDisplay();

		// string builder object used for ease of modification
		StringBuilder sb = new StringBuilder();
		sb.append("<p>");

		// creating an html table
		sb.append("<table id=\"calendar\">");

		// creating an html table row
		sb.append("<tr>");
		sb.append("<th>Meal</th>");

		// adding days as headings
		for (String day : Calendar.getDaysOfTheWeek()) {
			sb.append("<th>" + day + "</th>");
		}
		sb.append("</tr>");

		// adding meals
		for (String meal : Calendar.getMeals()) {
			sb.append("<tr><th>" + meal + "</th>");

			for (String day : Calendar.getDaysOfTheWeek()) {
				String aTag = "";

				if (calendarHashMap.get(day + " " + meal) != null) {
					// get the dish object from the HashMap and get dishID from it
					Dish d = calendarHashMap.get(day + " " + meal);
					String dishID = calendarHashMap.get(day + " " + meal).getDishID();

					// if the recipe is manually inputed
					if (d.getDishID().equals("manual")) {

						// direct to the user inputed recipe URL
						aTag = "<a href=" + d.getCookingStepsURL() + " target = \"_blank\">";
					} else {
						// direct the user to the display recipe page
						aTag = "<a href=/recipechosen?recipeid=" + dishID + "target = \"_blank\">";
					}
				} else {
					// direct the user to the calendar page (for calendar meals that were not added
					// dishes to)
					aTag = "<a href=/addtocalendar>";
				}

				// add the links to each table data element
				sb.append("<td>" + aTag + calendarToDisplayHashMap.get(day + " " + meal) + "</td>");
			}
			sb.append("</tr>");
		}

		sb.append("</table>");
		sb.append("</p>");

		return sb.toString();
	}

	/**
	 * The following method shows the calendar display options for adding a recipe
	 * 
	 * @return
	 */
	private String displayAddToCalendarOptions() {

		// string builder object used for ease of modification
		StringBuilder sb = new StringBuilder();

		// creating an HTML form
		sb.append("<p><form action=\"/selectameal\"method=\"get\">");
		sb.append("<select id=\"dayandmeal\" name=\"calendaroption\">\"");

		// adding selection drop-downs
		sb.append("<option value=\"\" selected=\"selected\" >Select a Calendar Option</option>");

		for (Entry<String, String> item : calendarToDisplayHashMap.entrySet()) {
			sb.append("<option value=\"" + item.getKey() + "\" >" + item.getKey() + "</option>");
		}
		sb.append("</select>");

		// adding the add button
		sb.append("<button style=\"margin-left: 10px\" type=\"submit\">Add</button></form></p>");

		return sb.toString();
	}

	/**
	 * The following method shows the calendar display options for removing a recipe
	 * 
	 * @return
	 */

	private String displayRemoveFromCalendarOptions() {
		StringBuilder sb = new StringBuilder();

		// creating an HTML form
		sb.append("<p><form action=\"/removefromcalendar\"method=\"get\">");
		sb.append("<select id=\"dayandmeal\" name=\"calendaroption\">\"");

		// adding selection drop-downs
		sb.append("<option value=\"\" selected=\"selected\" >Select a Calendar Option</option>");

		for (Entry<String, String> item : calendarToDisplayHashMap.entrySet()) {
			sb.append("<option value=\"" + item.getKey() + "\" >" + item.getKey() + "</option>");
		}
		sb.append("</select>");

		// adding the add button
		sb.append("<button style=\"margin-left: 10px\" type=\"submit\">Remove</button></form></p>");

		return sb.toString();
	}

	/**
	 * The following method shows the label area where the currently selected recipe
	 * is displayed for the user
	 * 
	 * @return
	 */
	private String displayRecipeSelected() {
		if (recipeToAdd == null) {
			recipeToAdd = "";
		}

		// creating a label for the user to see which recipe was selected
		return "<p><label> Recipe Selected: " + recipeToAdd + "</label></p>";
	}

}