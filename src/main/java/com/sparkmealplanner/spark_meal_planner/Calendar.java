package com.sparkmealplanner.spark_meal_planner;
import java.util.HashMap;

/**
 * This class represents a calendar to display and/or to be printed
 *
 */
public class Calendar {
	private HashMap<String, String> calendar = new HashMap(); // HashMap to store the calendar for a week
	private String[] daysOfTheWeek = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
	private String[] meals = { "Breakfast", "Lunch", "Snack", "Dinner" };

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
				//TODO we may change the key formation based on it's display on the GUI
				String calendarKey = day + meal;// key for the calendar HasMap using the dayOfWeek and meal
				calendar.put(calendarKey, "Not Picked Yet");
			}
		}
	}

	/**
	 * The following method modifies the calendar instance variable based on the day
	 * and meal selected and replaces the "Not Picked Yet" string with the dishName
	 * 
	 * @param mealName     i.e. lunch, dinner, snack, etc.
	 * @param dayOfTheWeek i.e. Sunday
	 * @param dishName dish name
	 * @return updated calendar
	 */
	public HashMap<String, String> addADishToCalendar(String mealName, String dayOfTheWeek, String dishName) {
		//TODO add error checking mechanism to ensure a key exists
		String calendarKey = dayOfTheWeek + mealName;
		calendar.put(calendarKey, dishName);
		return calendar;
	}

	/**
	 * The following method removes a meal from the calendar and places the String
	 * "Not Picked Yet" as a placeholder
	 * 
	 * @param mealName     i.e. lunch, dinner, snack, etc.
	 * @param dayOfTheWeek i.e. Sunday
	 * @return updated calendar
	 */
	public HashMap<String, String> removeADishFromTheCalendar(String mealName, String dayOfTheWeek) {
		//TODO add error checking mechanism to ensure a key exists
		String calendarKey = dayOfTheWeek + mealName;
		calendar.put(calendarKey, "Not Picked Yet");
		return calendar;
	}

	/**
	 * The following method moves a meal on the calendar to a different meal if the
	 * user chooses to do so It will remove the meal from it's current position and
	 * adds it to the new meal that the user wants to change it to
	 * 
	 * @param mealKeytoChangeFrom meal key to change from 
	 * @param mealKeyToChangeTo meal key to change to 
	 * @return updated calendar
	 */
	public HashMap<String, String> swapAMeal(String mealKeytoChangeFrom, String mealKeyToChangeTo) {
		// TODO update the calendar to move a dish from a given meal to a new meal
		// chosen by the user
		return calendar;
	}
}
