package com.sparkmealplanner.spark_meal_planner;

import java.util.HashMap;
import spark.Request;
import spark.Response;
import spark.Route;

public class CalendarHandler implements Route {
	HashMap<String, String> calendarToDisplay;
	private String CalendarDisplayHTML;
	private String recipeToAdd;
	String dayAndMealSelected;

	public void calendarDisplay(Calendar calendar) {
		HashMap<String, String> calendarToDisplay = new HashMap<String, String>();
		calendarToDisplay = calendar.getCalendar();
		StringBuilder sb = new StringBuilder();

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
				sb.append("<th>" + calendarToDisplay.get(day + meal) + "</th>");
			}
			sb.append("</tr>");
		}

		CalendarDisplayHTML = sb.toString();

		// sb.append("<tr>");
//    	sb.append("<th>Breakfast</th>");
//    	for (Entry <String, String> item : calendarToDisplay.entrySet()) {
//			sb.append("<th>"+ item.getKey() + "</th>");
//		}
//    	
//      	sb.append("</tr>");

//    	CalendarDisplayHTML = "<table>\r\n" + 
//	"  <tr>\r\n" + 
//	"    <th>Meal</th>\r\n" + 
//	"    <th>Sunday</th>\r\n" + 
//	"    <th>Monday</th> \r\n" + 
//	"    <th>Tuesday</th>\r\n" + 
//	"    <th>Wednesday</th>\r\n" + 
//	"    <th>Thursday</th>\r\n" + 
//	"    <th>Friday</th>\r\n" + 
//	"    <th>Saturday</th>\r\n" + 
//	"  </tr>\r\n" + 
//	"  <tr>\r\n" + 
//	"  	<th>Breakfast</th>\r\n" + 
//	"  	<td>" + calendarToDisplay.get("SundayBreakfast") +"</td>\r\n" + 
//	"  	<td>" + calendarToDisplay.get("MondayBreakfast") +"</td> \r\n" + 
//	"  	<td>" + calendarToDisplay.get("TuesdayBreakfast") +"</td>\r\n" + 
//	"  	<td>" + calendarToDisplay.get("WednesdayBreakfast")+ "</td>\r\n" + 
//	"  	<td>" + calendarToDisplay.get("ThursdayBreakfast") +"</td>\r\n" + 
//	"  	<td>" + calendarToDisplay.get("FridayBreakfast") +"</td>\r\n" + 
//	"  	<td>" + calendarToDisplay.get("SaturdayBreakfast") +"</td>\r\n" + 
//	"  </tr>\r\n" + 
//	"  <tr>\r\n" + 
//	"  	<th>Lunch</th>\r\n" + 
//	"  	<td>"+ calendarToDisplay.get("SundayLunch") +"</td>\r\n" + 
//	"  	<td>"+ calendarToDisplay.get("MondayLunch") +"</td> \r\n" + 
//	"  	<td>"+ calendarToDisplay.get("TuesdayLunch") +"</td>\r\n" + 
//	"  	<td>"+ calendarToDisplay.get("WednesdayLunch") +"</td>\r\n" + 
//	"  	<td>"+ calendarToDisplay.get("ThursdayLunch") +"</td>\r\n" + 
//	"  	<td>"+ calendarToDisplay.get("FridayLunch") +"</td>\r\n" + 
//	"  	<td>"+ calendarToDisplay.get("SaturdayLunch") +"</td>\r\n" + 
//	"  </tr>\r\n" + 
//	"  <tr>\r\n" + 
//	"  	<th>Snack</th>\r\n" + 
//	"  	<td>"+ calendarToDisplay.get("SundaySnack") +"</td>\r\n" + 
//	"  	<td>"+ calendarToDisplay.get("MondaySnack") +"</td> \r\n" + 
//	"  	<td>"+ calendarToDisplay.get("TuesdaySnack") +"</td>\r\n" + 
//	"  	<td>"+ calendarToDisplay.get("WednesdaySnack") +"</td>\r\n" + 
//	"  	<td>"+ calendarToDisplay.get("ThursdaySnack") +"</td>\r\n" + 
//	"  	<td>"+ calendarToDisplay.get("FridaySnack") +"</td>\r\n" + 
//	"  	<td>"+ calendarToDisplay.get("SaturdaySnack") +"</td>\r\n" + 
//	"  </tr>\r\n" + 
//	"  <tr>\r\n" + 
//	"  	<th>Dinner</th>\r\n" + 
//	"  	<td>"+ calendarToDisplay.get("MondayDinner") +"</td>\r\n" + 
//	"  	<td>"+ calendarToDisplay.get("TuesdayDinner") +"</td> \r\n" + 
//	"  	<td>"+ calendarToDisplay.get("WednesdayDinner") +"</td>\r\n" + 
//	"  	<td>"+ calendarToDisplay.get("ThursdayDinner") +"</td>\r\n" + 
//	"  	<td>"+ calendarToDisplay.get("FridayDinner") +"</td>\r\n" + 
//	"  	<td>"+ calendarToDisplay.get("SaturdayDinner") +"</td>\r\n" + 
//	"  	<td>"+ calendarToDisplay.get("TuesdayDinner") +"</td>\r\n" + 
//	"  </tr>\r\n" + 
//	"</table>\r\n";
	}

	public Object handle(Request request, Response response) throws Exception {
		if(request.queryParams("recipename")!=null) {
			recipeToAdd = request.queryParams("recipename");			
		}
		else {
			recipeToAdd = "Not Picked Yet";
		}
		System.out.println(recipeToAdd);
		if(request.queryParams("calendaroption")!=null) {
			dayAndMealSelected = request.queryParams("calendaroption");
			calendarToDisplay.put(dayAndMealSelected, recipeToAdd);
		}
		else {
			dayAndMealSelected = "No day and meal has been selected";
		}

		System.out.println(dayAndMealSelected);

		// System.out.println(recipeToAdd);
		Calendar c = new Calendar();
		calendarDisplay(c);
		return TagCreator.gethtmlHead("Meal Planner Calendar") +
				"<label> Recipe Selected: " + recipeToAdd + "</label>"+
//		"<div class=\"dropdown\">\r\n" + 
//		"<div class=\"dropdown-content\">\r\n" + 
//		"<p> Pick a day and Meal to add the recipe to</p>"+
//		"  <select>\r\n" + 
//		"<option value=\"\" selected=\"selected\" >Select a Calendar Day</option>"+
//		"  <option value=\"Sunday\">Sunday</option>\r\n" + 
//		"  <option value=\"Monday\">Monday</option>\r\n" + 
//		"  <option value=\"Tuesday\">Tuesday</option>\r\n" + 
//		"  <option value=\"Wednesday\">Wednesday</option>\r\n" +
//		"  <option value=\"Thursday\">Thursday</option>\r\n" + 
//		"  <option value=\"Friday\">Friday</option>\r\n" + 
//		"  <option value=\"Saturday\">Saturday</option>\r\n" + 
//		"  </select>" +
//		"  </div>\r\n" + 
//		"</div>" +
//		"<div class=\"dropdown-content\">\r\n" + 
//		"  <select>\r\n" + 
//		"<option value=\"\" selected=\"selected\" >Select a Calendar Meal</option>"+
//		"  <option value=\"Breakfast\">Breakfast</option>\r\n" + 
//		"  <option value=\"Lunch\">Lunch</option>\r\n" + 
//		"  <option value=\"Snack\">Snack</option>\r\n" + 
//		"  <option value=\"Dinner\">Dinner</option>\r\n" +
//		"  </select>" +
//		"  </div>\r\n" + 
//		"</div>" +
		// "<button>Submit</button>\r\n"+

				"<form action=\"/calendar\"method=\"get\">"
				+ "<select id=\"dayandmeal\" name=\"calendaroption\">"
				+ "<option value=\"\" selected=\"selected\" >Select a Calendar Option</option>"
				+ "<option value=\"MondayBreakfast\" >Monday Breakfast</option>"
				+ "<option value=\"monday_lunch\" >Monday Lunch</option>"
				+ "<option value=\"monday_snack\" >Monday Snack</option>"
				+ "<option value=\"monday_dinner\" >Monday Dinner</option>"
				+ "<option value=\"tuesday_breakfast\" >Tuesday Breakfast</option>"
				+ "<option value=\"tuesday_lunch\" >Tuesday Lunch</option>"
				+ "<option value=\"tuesday_snack\" >Tuesday Snack</option>"
				+ "<option value=\"tuesday_dinner\" >Tuesday Dinner</option>"
				+ "<option value=\"wednesday_breakfast\" >Wednesday Breakfast</option>"
				+ "<option value=\"wednesday_lunch\" >Wednesday Lunch</option>"
				+ "<option value=\"wednesday_snack\" >Wednesday Snack</option>"
				+ "<option value=\"wednesday_dinner\" >Wednesday Dinner</option>"
				+ "<option value=\"thursday_breakfast\" >Thursday Breakfast</option>"
				+ "<option value=\"thursday_lunch\" >Thursday Lunch</option>"
				+ "<option value=\"thursday_snack\" >Thursday Snack</option>"
				+ "<option value=\"thursday_dinner\" >Thursday Dinner</option>"
				+ "<option value=\"friday_breakfast\" >Friday Breakfast</option>"
				+ "<option value=\"friday_lunch\" >Friday Lunch</option>"
				+ "<option value=\"friday_snack\" >Friday Snack</option>"
				+ "<option value=\"friday_dinner\" >Friday Dinner</option>"
				+ "<option value=\"saturday_breakfast\" >Saturday Breakfast</option>"
				+ "<option value=\"saturday_lunch\" >Saturday Lunch</option>"
				+ "<option value=\"saturday_snack\" >Saturday Snack</option>"
				+ "<option value=\"saturday_dinner\" >Saturday Dinner</option>"
				+ "<option value=\"sunday_breakfast\" >Sunday Breakfast</option>"
				+ "<option value=\"sunday_lunch\" >Sunday Lunch</option>"
				+ "<option value=\"sunday_snack\" >Sunday Snack</option>"
				+ "<option value=\"sunday_dinner\" >Sunday Dinner</option>" + "</select>"
				+ "<button style=\"margin-left: 10px\" type=\"submit\">Add</button></form></li>" +

				CalendarDisplayHTML +

				"<button onclick=\"window.print()\">Print This Page</button>\r\n" + TagCreator.getFooter()
				+ TagCreator.closeTag();
	}
}
