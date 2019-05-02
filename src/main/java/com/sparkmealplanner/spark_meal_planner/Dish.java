package com.sparkmealplanner.spark_meal_planner;

import java.util.ArrayList;

/**
 * This class represents a full dish/recipes that includes the ingredient lists,
 * along with their measures, cooking steps, serving size, and cooking time.
 *
 */
public class Dish {

	// instance variables
	private String dishID;
	private String dishName;
	private ArrayList<Ingredient> ingredients;
	private String cookingStepsURL;// the API will not give cooking steps but rather a URL
	// to the original recipe where the user can find the steps
	private double cookingTimeInSeconds;
	private int numOfPeopleToServe; // serving size
	private String attribution;

	/**
	 * The following constructor creates a Dish object with the following
	 * parameters:
	 * 
	 * @param dishName             dish name
	 * @param ingredients          ingredients
	 * @param cookingStepsURL      original recipe URL
	 * @param cookingTimeInSeconds cooking time in seconds
	 * @param numOfPeopleToServe   number of people to serve
	 */
	public Dish(String dishID, String dishName, ArrayList<Ingredient> ingredients, String cookingStepsURL,
			double cookingTimeInSeconds, int numOfPeopleToServe) {
		this.dishID = dishID;
		this.dishName = dishName;
		this.ingredients = ingredients;
		this.cookingStepsURL = cookingStepsURL;
		this.cookingTimeInSeconds = cookingTimeInSeconds;
		this.numOfPeopleToServe = numOfPeopleToServe;
	}

	public Dish(String dishName, ArrayList<Ingredient> ingredients, String cookingStepsURL, double cookingTimeInSeconds,
			int numOfPeopleToServe) {
		this.dishID = dishID;
		this.dishName = dishName;
		this.ingredients = ingredients;
		this.cookingStepsURL = cookingStepsURL;
		this.cookingTimeInSeconds = cookingTimeInSeconds;
		this.numOfPeopleToServe = numOfPeopleToServe;
	}

	// see the getter methods below

	/**
	 * getter method
	 * 
	 * @return the dishName
	 */
	public String getDishName() {
		return dishName;
	}

	/**
	 * getter method
	 * 
	 * @return the dishID
	 */
	public String getDishID() {
		return dishID;
	}

	/**
	 * getter method
	 * 
	 * @return the ingredients
	 */
	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	/**
	 * getter method
	 * 
	 * @return the cookingSteps
	 */
	public String getCookingStepsURL() {
		return cookingStepsURL;
	}

	/**
	 * getter method
	 * 
	 * @return the cookingTimeInSeconds
	 */
	public double getCookingTimeInSeconds() {
		return cookingTimeInSeconds;
	}

	/**
	 * getter method
	 * 
	 * @return the numOfPeopleToServe
	 */
	public int getNumOfPeopleToServe() {
		return numOfPeopleToServe;
	}

	/**
	 * Getter method
	 * 
	 * @return the attribution Yummly attribution
	 */
	public String getAttribution() {
		return attribution;
	}

	/**
	 * Setter method - optional instance variable
	 * 
	 * @param attribution the attribution to set attribution html to set
	 */
	public void setAttribution(String attribution) {
		this.attribution = attribution;
	}

	/**
	 * Setter method - for manually inputted recipes
	 * 
	 * @param dishID the dishID to set
	 */
	public void setDishID(String dishID) {
		this.dishID = dishID;
	}

}
