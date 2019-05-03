package com.sparkmealplanner.spark_meal_planner;

/**
 * The following class represents an ingredient in a recipe. For future
 * viability of the app, this class has been created. More attributes, such as
 * nutrition information, can be added at a future stage.
 *
 */
public class Ingredient {
	private String ingredientLine; // represent the ingredient parsed from the API or manually inputed item

	/**
	 * The following constructor creates a new ingredient based on the following:
	 * 
	 * @param ingredientLine ingredient line
	 */
	public Ingredient(String ingredientLine) {
		this.ingredientLine = ingredientLine;
	}

	/**
	 * Getter method
	 * 
	 * @return the ingredientLine
	 */
	public String getIngredientLine() {
		return ingredientLine;
	}
}
