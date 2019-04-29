package com.sparkmealplanner.spark_meal_planner;

import java.util.ArrayList;
import java.util.Scanner;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * This is a class to be used when user wants to manually input a recipe We are
 * using a scanner item for now to get user input but will figure out how to
 * deal with this on the web app user interface once we get to creating it
 */
public class ManualRecipeInputHandler implements Route{

	private String manDishName;
	private ArrayList<Ingredient> manIngredients;
	private ArrayList<String> manCookingSteps;
	private double manCookingTimeInSeconds;
	private int manNumOfPeopleToServe;
	public final String IngredientForm = "<div><form action =\"/createIngredientList\" method = \"post\"> Add new Ingredient:"+
	"<input type = \"text\" name=\"ingredientLine\">" +
	"<button style = \"margin-left: 10px\" type=\"submit\">Add Ingredient</button>"+
	"</form><div>";
	/**
	 * This is method name 
	 * @return This returns a html string which is later used in the handle method
	 */
	public ManualRecipeInputHandler() {
	    manDishName ="";
	    manIngredients = new ArrayList<Ingredient>();
	}
	public String RecipeName() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("<div> <form>\r\n" + 
	    	"  Recipe Name:<br>\r\n" + 
	    	"  <input type=\"text\" name=\"recipename\">\r\n" + 
	    	"  <br></form></div>");
	    sb.append("<button><a href=\"/recipeName\">Submit</a></button>");
	    return sb.toString();
	}
	public String IngredientList() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("<div><ol>");
	    int ingredientCounter =0;
	    for (Ingredient ingredient : manIngredients) {
		ingredientCounter++;
		sb.append("<li>" + ingredient.getIngredientLine() + "<button style = \"margin-left: 10px\" onclick = " +
			"\"location.href/Ingredients?id=" +  ingredientCounter + "'\">Add More</button></li>");
	    }
	    sb.append("</ol></div>");
	    return sb.toString();
	}
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

	public Object handle(Request request, Response response) throws Exception {
	    if ("/recipeName".equals(request.pathInfo())) {
		manDishName = request.queryParams("recipename");
	    }
	    else if ("/createIngredientList".contentEquals(request.pathInfo())){
		String ingredientLine = request.queryParams("ingredientLine");
		Ingredient i = new Ingredient(ingredientLine);
		manIngredients.add(i);
	    }
	    return TagCreator.gethtmlHead("Meal Planner Calendar") + 
		    RecipeName() + IngredientList() + IngredientForm +
		    TagCreator.getFooter() + "</body></html>";
	}

}
