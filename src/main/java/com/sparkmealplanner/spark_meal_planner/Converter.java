package com.sparkmealplanner.spark_meal_planner;

import java.util.ArrayList;
import java.util.regex.*;

/**
 * This class represents a converter that can convert ingredients from one to
 * another and change the serving size.
 *
 */
public class Converter {
	private Ingredient ingredientToConvert;
	private ArrayList <Ingredient> ingredientsToConvert = new ArrayList <Ingredient>();
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
	public Converter(Ingredient ingredientsToConvert, int servingSizeToConvert, int desiredServingSize) {
		this.ingredientToConvert = ingredientsToConvert;
		this.servingSizeToConvert = servingSizeToConvert;
		this.desiredServingSize = desiredServingSize;
		convertIngredientLine();
		// TODO add code here
	}

	
	public static String convertQuantity (String wordContainingDigits) {
		char [] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		StringBuilder updatedWord = new StringBuilder();
		
		for (int j = 0; j < wordContainingDigits.length(); j++) {
			char character = wordContainingDigits.charAt(j);
			//System.out.println("The charcter is :" + character );
			for (char number : numbers) {
				System.out.println(number);
				if(character == number) {
					System.out.println("character is:" + character);
				}
			}
		}
		return "";
	}
	
	/**
	 * The following method changes a dish's ingredient quantities and cooking time
	 * based on serving size change
	 * 
	 * @return updated dish with updated ingredient quantities and cooking time
	 */

	private Ingredient convertIngredientLine() {
		Character [] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		String ingredientLineOriginal = ingredientToConvert.getIngredientLine();
		System.out.println("Original ingredient line: " + ingredientLineOriginal);
		StringBuilder ingredientLineUpdated = new StringBuilder();
		String[] words = ingredientLineOriginal.split(" ");

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			Pattern p = Pattern.compile("\\d+");
			Matcher m = p.matcher(word);
			Integer quantityToModify = 0;
			int updatedQuantity = 0;

			while (m.find()) {
				System.out.println("The word is: " + words[i]);
				
				for (int j = 0; j < word.length(); j++) {
					Character character = word.charAt(i);
					System.out.println("The charcter is :" + character );
					for (char number : numbers) {
						System.out.println(number);
					}
				}

			//	String num = m.group();
			//	System.out.println("num is :" +  num);
			//	quantityToModify = Integer.parseInt(num);
			//	System.out.println("quantity to modify: " + quantityToModify);
			//	updatedQuantity = quantityToModify / servingSizeToConvert * desiredServingSize;
			//System.out.println("updated quantity: " + updatedQuantity);
			}
			
			if (quantityToModify != updatedQuantity) {
//				System.out.println("The word is: " + words[i]);
				System.out.println("updated quantity: " + updatedQuantity);
				words[i] = String.valueOf(updatedQuantity);
				System.out.println("updated quantity in string: " + words[i]);				
			}
		}

		for (String word : words) {
			ingredientLineUpdated.append(word + " ");
		}
		
		System.out.println("The updated ingredient line is: " + ingredientLineUpdated.toString());
		
		ingredientToConvert.setIngredientLine(ingredientLineUpdated.toString());
		System.out.println("The new ingredient is " + ingredientToConvert.getIngredientLine());
		return ingredientToConvert;
	}

	public static void main(String[] args) {
		Ingredient ingredient = new Ingredient ("1/2 cup of corn");
		
		//Converter c = new Converter(ingredient, 2, 4);
		
		Converter.convertQuantity("1");
		//System.out.println("Updated ingredient line is: " + ingredient.getIngredientLine().toString());
	}

}
