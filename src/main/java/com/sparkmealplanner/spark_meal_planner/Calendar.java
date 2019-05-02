package com.sparkmealplanner.spark_meal_planner;

import java.util.HashMap;

/**
 * This class represents a calendar to display and/or to be printed
 *
 */
public class Calendar {
	private HashMap<String, Dish> calendar = new HashMap(); // HashMap to store the calendar for a week with dish
	private HashMap<String, String> calendarToDisplay = new HashMap(); // HashMap to display the calendar in HTML
	private final static String[] daysOfTheWeek = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
			"Sunday" };
	private final static String[] meals = { "Breakfast", "Lunch", "Snack", "Dinner" };

	/**
	 * The following constructor creates a calendar HashMap. This method loops
	 * through the dayOfTheWeek and meal String[] and a calendarKey is created by
	 * adding the Strings for dayOfWeek and meal which creates a unique key. This is
	 * initially mapped to a default dish called 'Not Picked Yet'
	 * 
	 */
	public Calendar() {
		for (String day : daysOfTheWeek) {
			for (String meal : meals) {
				String calendarKey = day + " " + meal;// key for the calendar HasMap using the dayOfWeek and meal
				calendar.put(calendarKey, null);
				calendarToDisplay.put(calendarKey, "");
			}
		}
	}

	/**
	 * @return the daysOfTheWeek
	 */
	public static String[] getDaysOfTheWeek() {
		return daysOfTheWeek;
	}

	/**
	 * @return the meals
	 */
	public static String[] getMeals() {
		return meals;
	}

	/**
	 * Getter method to access the calendar instance variable from a different class
	 * 
	 * @return calendar
	 */
	public HashMap<String, Dish> getCalendar() {
		return calendar;
	}

	/**
	 * Getter method to access the calendar instance variable from a different class
	 * 
	 * @return calendar
	 */
	public HashMap<String, String> getCalendarToDisplay() {
		return calendarToDisplay;
	}

}
