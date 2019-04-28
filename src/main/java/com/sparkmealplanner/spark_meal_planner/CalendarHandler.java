package com.sparkmealplanner.spark_meal_planner;

import java.util.HashMap;

import spark.Request;
import spark.Response;
import spark.Route;

public class CalendarHandler implements Route {

    private final String htmlHead = "<html><head><title>Meal Planner Calendar</title></head>";
    private String CalendarDisplayHTML;
    
    public void calendarDisplay(Calendar calendar) {
	HashMap<String, String> calendarToDisplay = calendar.getCalendar();
	CalendarDisplayHTML = "<table>\r\n" + 
	"  <tr>\r\n" + 
	"    <th>Meal</th>\r\n" + 
	"    <th>Sunday</th>\r\n" + 
	"    <th>Monday</th> \r\n" + 
	"    <th>Tuesday</th>\r\n" + 
	"    <th>Wednesday</th>\r\n" + 
	"    <th>Thursday</th>\r\n" + 
	"    <th>Friday</th>\r\n" + 
	"    <th>Saturday</th>\r\n" + 
	"  </tr>\r\n" + 
	"  <tr>\r\n" + 
	"  	<th>Breakfast</th>\r\n" + 
	"  	<td>" + calendarToDisplay.get("SundayBreakfast") +"</td>\r\n" + 
	"  	<td>" + calendarToDisplay.get("MondayBreakfast") +"</td> \r\n" + 
	"  	<td>" + calendarToDisplay.get("TuesdayBreakfast") +"</td>\r\n" + 
	"  	<td>" + calendarToDisplay.get("WednesdayBreakfast")+ "</td>\r\n" + 
	"  	<td>" + calendarToDisplay.get("ThursdayBreakfast") +"</td>\r\n" + 
	"  	<td>" + calendarToDisplay.get("FridayBreakfast") +"</td>\r\n" + 
	"  	<td>" + calendarToDisplay.get("SaturdayBreakfast") +"</td>\r\n" + 
	"  </tr>\r\n" + 
	"  <tr>\r\n" + 
	"  	<th>Lunch</th>\r\n" + 
	"  	<td>"+ calendarToDisplay.get("SundayLunch") +"</td>\r\n" + 
	"  	<td>"+ calendarToDisplay.get("MondayLunch") +"</td> \r\n" + 
	"  	<td>"+ calendarToDisplay.get("TuesdayLunch") +"</td>\r\n" + 
	"  	<td>"+ calendarToDisplay.get("WednesdayLunch") +"</td>\r\n" + 
	"  	<td>"+ calendarToDisplay.get("ThursdayLunch") +"</td>\r\n" + 
	"  	<td>"+ calendarToDisplay.get("FridayLunch") +"</td>\r\n" + 
	"  	<td>"+ calendarToDisplay.get("SaturdayLunch") +"</td>\r\n" + 
	"  </tr>\r\n" + 
	"  <tr>\r\n" + 
	"  	<th>Snack</th>\r\n" + 
	"  	<td>"+ calendarToDisplay.get("SundaySnack") +"</td>\r\n" + 
	"  	<td>"+ calendarToDisplay.get("MondaySnack") +"</td> \r\n" + 
	"  	<td>"+ calendarToDisplay.get("TuesdaySnack") +"</td>\r\n" + 
	"  	<td>"+ calendarToDisplay.get("WednesdaySnack") +"</td>\r\n" + 
	"  	<td>"+ calendarToDisplay.get("ThursdaySnack") +"</td>\r\n" + 
	"  	<td>"+ calendarToDisplay.get("FridaySnack") +"</td>\r\n" + 
	"  	<td>"+ calendarToDisplay.get("SaturdaySnack") +"</td>\r\n" + 
	"  </tr>\r\n" + 
	"  <tr>\r\n" + 
	"  	<th>Dinner</th>\r\n" + 
	"  	<td>"+ calendarToDisplay.get("MondayDinner") +"</td>\r\n" + 
	"  	<td>"+ calendarToDisplay.get("TuesdayDinner") +"</td> \r\n" + 
	"  	<td>"+ calendarToDisplay.get("WednesdayDinner") +"</td>\r\n" + 
	"  	<td>"+ calendarToDisplay.get("ThursdayDinner") +"</td>\r\n" + 
	"  	<td>"+ calendarToDisplay.get("FridayDinner") +"</td>\r\n" + 
	"  	<td>"+ calendarToDisplay.get("SaturdayDinner") +"</td>\r\n" + 
	"  	<td>"+ calendarToDisplay.get("TuesdayDinner") +"</td>\r\n" + 
	"  </tr>\r\n" + 
	"</table>\r\n";
    }
    public void calendarDisplayAddMeal() {
	
    }
    public Object handle(Request request, Response response) throws Exception {
	Calendar c = new Calendar();
	calendarDisplay(c);
	return htmlHead + "<body><h3>Meal Planner Calendar</h3>" + 
		"<div class=\"dropdown\">\r\n" + 
		"<div class=\"dropdown-content\">\r\n" + 
		"  <select>\r\n" + 
		"  <option value=\"Sunday\">Sunday</option>\r\n" + 
		"  <option value=\"Monday\">Monday</option>\r\n" + 
		"  <option value=\"Tuesday\">Tuesday</option>\r\n" + 
		"  <option value=\"Wednesday\">Wednesday</option>\r\n" +
		"  <option value=\"Thursday\">Thursday</option>\r\n" + 
		"  <option value=\"Friday\">Friday</option>\r\n" + 
		"  <option value=\"Saturday\">Saturday</option>\r\n" + 
		"  </select>" +
		"  </div>\r\n" + 
		"</div>" +
		"<div class=\"dropdown-content\">\r\n" + 
		"  <select>\r\n" + 
		"  <option value=\"Breakfast\">Breakfast</option>\r\n" + 
		"  <option value=\"Lunch\">Lunch</option>\r\n" + 
		"  <option value=\"Snack\">Snack</option>\r\n" + 
		"  <option value=\"Dinner\">Dinner</option>\r\n" +
		"  </select>" +
		"  </div>\r\n" + 
		"</div>" +
		"<button>Submit</button>\r\n"+
		CalendarDisplayHTML+
		"<button onclick=\"window.print()\">Print This Page</button>\r\n"+
		"<button><a href = \"/GroceryList\">Display Grocery List</button>\r\n"+
		"<button><a href=\"/todo\">Go back to the Recipe List</a></button></body></html>";
    }
}
