package com.sparkmealplanner.spark_meal_planner;

/**
 * This class represents a converter that can convert ingredients from one to
 * another and change the serving size.
 *
 */
public class Converter {
	private Dish dishToConvertBasedOnServingSize;
	private int servingSizeToConvert;
	private int desiredServingSize;

	/**
	 * The following constructor creates a converter that converts a dish based on
	 * serving size change
	 * 
	 * @param dishToConvert        dish to convert
	 * @param servingSizeToConvert serving size to convert from
	 * @param desiredServingSize   desired serving size
	 */
	public Converter(Dish dishToConvert, int servingSizeToConvert, int desiredServingSize) {
		dishToConvert = dishToConvertBasedOnServingSize;
		this.servingSizeToConvert = servingSizeToConvert;
		this.desiredServingSize = desiredServingSize;
		convertDish();
		// TODO add code here
	}

	/**
	 * The following method changes a dish's ingredient quantities and cooking time
	 * based on serving size change
	 * 
	 * @return updated dish with updated ingredient quantities and cooking time
	 */

	public Dish convertDish() {
		Dish d = null;
		// TODO add the body to first find a dish's ingredient line, scan for the
		// integers to find quantities, find the cooking time and convert it by
		// multiplying the quantities and cooking time with the desired serving size and
		// dividing it by the dish's existing serving size
		return d;
	}
}
