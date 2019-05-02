package com.sparkmealplanner.spark_meal_planner;

import java.util.HashMap;
import java.util.Map.Entry;

import org.json.JSONObject;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * The following class handles the calendar display page and related HTML or java elements
 *
 */
public class CalendarHandler implements Route {
	
	//create a new calendar and related instance variables
	static Calendar calendar = new Calendar();
	static HashMap<String, Dish> calendarHashMap = calendar.getCalendar();
	JSONObject json = null;
	/**
	 * @return the calendarHashMap
	 */
	public static HashMap<String, Dish> getCalendarHashMap() {
		return calendarHashMap;
	}

	HashMap<String, String> calendarToDisplayHashMap = calendar.getCalendarToDisplay();
	Dish dish = null;
	
	//instance variable to be used in the handler class
	private String recipeToAdd;
	private String recipeIDToAdd;
	String dayAndMealSelected;
	
	/**
	 * Method handler to implement the route class
	 */
	public Object handle(Request request, Response response) throws Exception {
		
		//if the url was directed to "/calendar"
		if ("/addtocalendar".equals(request.pathInfo())) {
			
			//if the recipe name parameter is not empty, the value is stored in a variable
			if(request.queryParams("recipename")!=null) {
				recipeToAdd = request.queryParams("recipename");			
			}

			//if the recipe id parameter is not empty, the value is stored in a variable
			if(request.queryParams("recipeid")!=null) {
				recipeIDToAdd = request.queryParams("recipeid");
					json = YummlyAPIHandler.getRecipe(recipeIDToAdd);				
					//System.out.println(json.toString());				
			}
			
			//creating a JSON object to create a new dish to be stored in the calendar hashmap
			
		//	System.out.println(recipeJSON.toString());
			
			try {
				
				//using dishreader class, create a dish from JSON derived
				DishReader dr = new DishReader(json);
				dish = dr.getDishCreated();
				//System.out.println("dish URL: " + dish.getCookingStepsURL());
			}
			catch(Exception e){
				e.printStackTrace();
				//TODO add the block here
			}
	
			//if calendar option (day+meal) parameter is not empty, the value is stored in a variable
			if(request.queryParams("calendaroption")!=null) {
				dayAndMealSelected = request.queryParams("calendaroption");
				
				//the variable is added to the hashmaps
				calendarHashMap.put(dayAndMealSelected, dish);
				calendarToDisplayHashMap.put(dayAndMealSelected, recipeToAdd);
			}
		}
		
		//if the user pressed the remove button, the following url path is reached
		if ("/removefromcalendar".equals(request.pathInfo())) {					
			
			//parameter value is stored below if it is not empty
			if(request.queryParams("calendaroption")!=null) {
				dayAndMealSelected = request.queryParams("calendaroption");
				
				//variable value is used to update the HashMaps below
				calendarHashMap.put(dayAndMealSelected, null);
				calendarToDisplayHashMap.put(dayAndMealSelected, "-");
			}
		}
		
		//returns various html parts
		return TagCreator.gethtmlHead("Meal Planner Calendar")
				+ TagCreator.createBodyTitle("Calendar")
				+ displayCalendar() 
				+ displayRecipeSelected()
				+ displayAddToCalendarOptions()
				+ displayRemoveFromCalendarOptions()
				+ TagCreator.createPrintThisButton()
				+ TagCreator.getFooter()
				+ TagCreator.closeTag();
	}

	/**
	 * The following method creates the calendar to be displayed in html
	 * @return calendar to display
	 */
	private String displayCalendar() {
		calendarHashMap = calendar.getCalendar();
		calendarToDisplayHashMap = calendar.getCalendarToDisplay();
		
		//string builder object used for ease of modification
		StringBuilder sb = new StringBuilder();
		sb.append("<p>");
		
		//creating an html table
		sb.append("<table>");
		
		//creating an html table row
		sb.append("<tr>");
		sb.append("<th>Meal</th>");

		//adding days
		for (String day : Calendar.getDaysOfTheWeek()) {
			sb.append("<th>" + day + "</th>");
		}
		sb.append("</tr>");

		//adding meals
		for (String meal : Calendar.getMeals()) {
			sb.append("<tr><th>" + meal + "</th>");
			
			
			//adding assigned dish name from the hashmap
			//calendar		
			for (String day : Calendar.getDaysOfTheWeek()) {
				String aTag = "";
				
				if (calendarHashMap.get(day +" " +  meal) != null){
					Dish d = calendarHashMap.get(day +" " +  meal);
				//	System.out.println(d.toString());
					String dishID = calendarHashMap.get(day +" " +  meal).getDishID();
				//	System.out.println(dishID);
					aTag = "<a href=/recipechosen?recipeid=" +  dishID + ">";	
				}
				else {
					aTag = "<a href=/addtocalendar>";
				}
										
				//System.out.println(day +" " +  meal + ":" + aTag);
				sb.append("<th>" + aTag + calendarToDisplayHashMap.get(day +" " +  meal) + "</th>");
			}
			sb.append("</tr>");
		}
		
		sb.append("</table>");
		sb.append("</p>");


		return sb.toString();
	}
	
	/**
	 * The following method shows the calendar display options for adding a recipe
	 * @return
	 */
	private String displayAddToCalendarOptions() {
		//string builder object used for ease of modification
		StringBuilder sb = new StringBuilder ();
		
		//creating an HTML form
		sb.append("<p><form action=\"/addtocalendar\"method=\"get\">");
		sb.append("<select id=\"dayandmeal\" name=\"calendaroption\">\"");
		
		//adding selection drop-downs
		sb.append("<option value=\"\" selected=\"selected\" >Select a Calendar Option</option>");
	
		for (Entry <String, String> item : calendarToDisplayHashMap.entrySet()) {
			sb.append("<option value=\""+ item.getKey() + "\" >"+ item.getKey() + "</option>");
		}
		sb.append("</select>");
		
		//adding the add button
		sb.append("<button style=\"margin-left: 10px\" type=\"submit\">Add</button></form></p>");
		
		return  sb.toString();			
	}
	
	/**
	 * The following method shows the calendar display options for removing a recipe
	 * @return
	 */

	private String displayRemoveFromCalendarOptions() {
		StringBuilder sb = new StringBuilder ();
		
		//creating an HTML form
		sb.append("<p><form action=\"/removefromcalendar\"method=\"get\">");
		sb.append("<select id=\"dayandmeal\" name=\"calendaroption\">\"");
		
		//adding selection drop-downs
		sb.append("<option value=\"\" selected=\"selected\" >Select a Calendar Option</option>");
	
		for (Entry <String, String> item : calendarToDisplayHashMap.entrySet()) {
			sb.append("<option value=\""+ item.getKey() + "\" >"+ item.getKey() + "</option>");
		}
		sb.append("</select>");
		
		//adding the add button
		sb.append("<button style=\"margin-left: 10px\" type=\"submit\">Remove</button></form></p>");
		
		return  sb.toString();			
	}
	
	/**
	 * The following method shows the label area where the currently selected recipe is displayed for the user
	 * @return
	 */
	private String displayRecipeSelected() {
		if(recipeToAdd == null) {
			recipeToAdd = "-";
		}
		return "<p><label> Recipe Selected: " 
				+ recipeToAdd 
				+ "</label></p>";
	}
	
}
