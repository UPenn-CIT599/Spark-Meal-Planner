package com.sparkmealplanner.spark_meal_planner;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is a class to be used when user wants to manually input a recipe We are
 * using a scanner item for now to get user input but will figure out how to
 * deal with this on the web app user interface once we get to creating it
 */
public class ManualRecipeInputHandler {
	/*
	 * Each of the labels for the indicator variables in this class have a "man"
	 * prefix in the front to indicate that they are manually entered
	 */
	private String manDishName;
	private ArrayList<Ingredient> manIngredients;
	private ArrayList<String> manCookingSteps;
	private double manCookingTimeInSeconds;
	private int manNumOfPeopleToServe;

	/*
	 * The manualDishBuilding method is used to get input from the user through the
	 * We will create a dish object from this in the main method when the user
	 * decides to manually input a recipe instead of searching from an API
	 */
	public void manualDishBuilding() {
		Scanner manualInput = new Scanner(System.in);

		// asking for the name of the dish
		System.out.println("What is the name of the Dish?");
		manDishName = manualInput.nextLine();

		// asking for the ingredients
		System.out.println("Please enter a List of indgredients and press Done");
		// The while loop below stops here when the user enters "Done" and for now it is
		// assumed that the user will correctly
		// enter done when done with inputting the ingredients. This will be connected
		// with clicking a done button on HTML
		while (!manualInput.nextLine().equals("Done")) {
			String s = manualInput.nextLine();
			Ingredient i = new Ingredient(s);
			manIngredients.add(i);
		}

		// Similar to the above step, the while loop below for manually entering steps
		// for cooking stops when the user enters "Done" and
		// for now it is assumed that the user will correctly enter done when done with
		// inputting the ingredients
		System.out.println("Please enter a List of steps to be followed for cooking and press Done");
		while (!manualInput.nextLine().equals("Done")) {
			String cookingStep = manualInput.nextLine();
			manCookingSteps.add(cookingStep);
		}

		// asking for the cooking time
		System.out.println("What is the cooking time in seconds?");
		manCookingTimeInSeconds = manualInput.nextDouble();// The user is expected to enter cooking time in seconds.

		// serving size
		System.out.println("Hom many people does this recipe serve?");
		manNumOfPeopleToServe = manualInput.nextInt();

		manualInput.close();
	}

	/**
	 * getter method
	 * 
	 * @return Name of the Dish that was entered manually
	 */
	public String getManDishName() {
		return manDishName;
	}

	/**
	 * getter method
	 * 
	 * @return ArrayList of ingredients that were entered manually
	 */
	public ArrayList<Ingredient> getManIngredients() {
		return manIngredients;
	}

	/**
	 * getter method
	 * 
	 * @return ArrayList of cooking steps that were entered manually
	 */
	public ArrayList<String> getManCookingSteps() {
		return manCookingSteps;
	}

	/**
	 * getter method
	 * 
	 * @return Cooking time for a recipe that was entered manually
	 */
	public double getManCookingTimeInseconds() {
		return manCookingTimeInSeconds;
	}

	/**
	 * getter method
	 * 
	 * @return Number of people that the recipe will serve
	 */
	public int getManNumOfPeopleToServe() {
		return manNumOfPeopleToServe;
	}

}
