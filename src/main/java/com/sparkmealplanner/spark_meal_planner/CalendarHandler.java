package com.sparkmealplanner.spark_meal_planner;

import java.util.HashMap;
import java.util.Map.Entry;

import spark.Request;
import spark.Response;
import spark.Route;

public class CalendarHandler implements Route {
	Calendar calendar = new Calendar();
	HashMap<String, String> calendarHashMap = new HashMap<String, String>();
	private String CalendarDisplayHTML;
	private String recipeToAdd;
	String dayAndMealSelected;

	public void displayCalendar() {
		calendarHashMap = calendar.getCalendar();
		
		StringBuilder sb = new StringBuilder();
		sb.append("<p>");
		sb.append("<table>");
		sb.append("<tr>");
		sb.append("<th>Meal</th>");

		for (String day : Calendar.getDaysOfTheWeek()) {
			sb.append("<th>" + day + "</th>");
		}
		sb.append("</tr>");

		for (String meal : Calendar.getMeals()) {
			sb.append("<tr><th>" + meal + "</th>");
			for (String day : Calendar.getDaysOfTheWeek()) {
				sb.append("<th>" + calendarHashMap.get(day +" " +  meal) + "</th>");
			}
			sb.append("</tr>");
		}
		
		sb.append("</table>");
		sb.append("</p>");


		CalendarDisplayHTML = sb.toString();
	}

	public String displayCalendarOptions() {
		StringBuilder sb = new StringBuilder ();
		
		sb.append("<p><form action=\"/calendar\"method=\"get\">");
		sb.append("<select id=\"dayandmeal\" name=\"calendaroption\">\"");
		
		sb.append("<option value=\"\" selected=\"selected\" >Select a Calendar Option</option>");
	
		for (Entry <String, String> item : calendarHashMap.entrySet()) {
			sb.append("<option value=\""+ item.getKey() + "\" >"+ item.getKey() + "</option>");
		}
		sb.append("</select>");
		sb.append("<button style=\"margin-left: 10px\" type=\"submit\">Add</button></form></p>");
		
//		+ "<button style=\"margin-left: 10px\" type=\"submit\">Add</button></form></li>";

		//System.out.println(sb);
		return  sb.toString();			
	}
	
	public String displayRecipeSelected() {
		if(recipeToAdd == null) {
			recipeToAdd = "Not Picked Yet";
		}
		return "<p><label> Recipe Selected: " 
				+ recipeToAdd 
				+ "</label></p>";
	}
	
	
	public Object handle(Request request, Response response) throws Exception {
		
		if(request.queryParams("recipename")!=null) {
			recipeToAdd = request.queryParams("recipename");			
		}
		
		if(request.queryParams("calendaroption")!=null) {
			dayAndMealSelected = request.queryParams("calendaroption");
			calendarHashMap.put(dayAndMealSelected, recipeToAdd);
		}
		else {
			dayAndMealSelected = "No day and meal has been selected";
		}

		displayCalendar();
		
		return TagCreator.gethtmlHead("Meal Planner Calendar")
				+ TagCreator.createBodyTitle("Calendar")
				+ CalendarDisplayHTML
				+ displayRecipeSelected()
				+ displayCalendarOptions()
				+ TagCreator.createPrintThisButton()
				+ TagCreator.getFooter()
				+ TagCreator.closeTag();
	}
}
