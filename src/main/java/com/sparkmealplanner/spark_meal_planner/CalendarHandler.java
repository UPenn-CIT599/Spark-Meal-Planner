package com.sparkmealplanner.spark_meal_planner;

import spark.Request;
import spark.Response;
import spark.Route;

public class CalendarHandler implements Route {

    private final String htmlHead = "<html><head><title>Meal Planner Calendar</title></head>";

    public Object handle(Request request, Response response) throws Exception {
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
		"<table>\r\n" + 
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
		"  	<td>Not picked yet</td>\r\n" + 
		"  	<td>Not picked yet</td> \r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  </tr>\r\n" + 
		"  <tr>\r\n" + 
		"  	<th>Lunch</th>\r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  	<td>Not picked yet</td> \r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  </tr>\r\n" + 
		"  <tr>\r\n" + 
		"  	<th>Snack</th>\r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  	<td>Not picked yet</td> \r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  </tr>\r\n" + 
		"  <tr>\r\n" + 
		"  	<th>Dinner</th>\r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  	<td>Not picked yet</td> \r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  	<td>Not picked yet</td>\r\n" + 
		"  </tr>\r\n" + 
		"</table>\r\n" + 
		"<button><a href=\"/todo\">Go back to your list</a></button></body></html>";
    }
}
