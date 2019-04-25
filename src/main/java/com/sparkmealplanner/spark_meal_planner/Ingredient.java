package com.sparkmealplanner.spark_meal_planner;

/**
 * The following class represents an ingredient in a recipe
 *
 */
public class Ingredient {
	private String ingredientLine; // represent the ingredient parsed from the API or manually inputed item
	private int quantity; // represents the quantity of the ingredient which would be used in the
							// converter class later. derived from the ingredient line

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

	/**
	 * getter method
	 * 
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

}
