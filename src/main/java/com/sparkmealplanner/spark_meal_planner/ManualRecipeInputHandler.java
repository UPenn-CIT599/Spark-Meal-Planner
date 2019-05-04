package com.sparkmealplanner.spark_meal_planner;

import java.util.ArrayList;
import java.util.Scanner;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * This is a class to be used when user wants to manually input a recipe
 */
public class ManualRecipeInputHandler implements Route {

	// instance variables
	private String manDishName;
	private ArrayList<Ingredient> manIngredients;
	private String manCookingStepsURL;
	private double manCookingTimeInSeconds;
	private int manNumOfPeopleToServe;

	// form to add ingredients
	private final String AddIngredientForm = "<div><form action=\"/addingredients\" method=\"get\">Add new Ingredient:"
			+ "<input type=\"text\" name=\"ingredientname\">"
			+ "<button style=\"margin-left: 10px\" type=\"submit\">Add</button>" + "</form></div>";
	private static Dish manDish;

	/**
	 * The following constructor initiates the instance variables needed for the page
	 */
	public ManualRecipeInputHandler() {
		manDishName = "";
		manIngredients = new ArrayList<Ingredient>();
		manCookingStepsURL = "";
		manCookingTimeInSeconds = 0;
		manNumOfPeopleToServe = 0;
		manDish = null;
	}

	/**
	 * This is a method to create a HTML field for the recipe name in the manual
	 * recipe entry form
	 * 
	 * @return string with HTML code for recipe name field
	 */
	public String recipeNameForm() {
		StringBuilder sb = new StringBuilder();
		sb.append("<div> <form action = \"/addingredients\" method = \"get\">\r\n" + "  Recipe Name:<br>\r\n"
				+ "  <input type=\"text\" name=\"recipename\" value = \"" + manDishName + "\"required>\r\n" + "  <br>");
		return sb.toString();
	}

	/**
	 * This is a method to create a field for the recipe URL in the manual recipe
	 * entry form
	 * 
	 * @return string with HTML code for recipe URL field
	 */

	public String recipeURLForm() {
		StringBuilder sb = new StringBuilder();
		sb.append("  Recipe URL:<br>\r\n" + "  <input type=\"URL\" name=\"recipeURL\" value = \"" + manCookingStepsURL
				+ "\"required>\r\n" + "  <br>");
		return sb.toString();
	}

	/**
	 * The following method returns the cooking time field to be filled in HTML
	 * 
	 * @return HTML string
	 */
	public String cookingTimeForm() {
		StringBuilder sb = new StringBuilder();
		sb.append("Cooking Time in Minutes:<br>\r\n" + "  <input type=\"number\" name=\"cookingtime\" value =\""
				+ manCookingTimeInSeconds + "\"required>\r\n" + "  <br>");
		return sb.toString();
	}

	/**
	 * The following class returns the serving size input field to be filled in HTML
	 * 
	 * @return HTML string
	 */
	public String servingsizeForm() {
		StringBuilder sb = new StringBuilder();
		sb.append("Serving size:<br>\r\n" + "  <input type=\"number\" name=\"servingsize\" value =\""
				+ manNumOfPeopleToServe + "\"required>\r\n" + "<br><br>"
				+ "<button class = \" button\" type=\"submit\">Add Ingredients To Proceed</button>" + "</form></div>" + "  <br>\r\n");
//	    sb.append("<button style=\"margin-left: 10px\" type=\"submit\">Submit The Recipe</button>" + "</form></div>");
		return sb.toString();
	}

	/**
	 * 
	 * @return
	 */
	public String displayRecipeButton() {

		String sb = TagCreator.createButton("addrecipe", "Display The recipe");
		return sb;
	}

	/**
	 * 
	 * @return
	 */
	public String submitButton() {

		String sb = TagCreator.createButton("addmanualrecipetocalendar", "Send To Calendar", "recipename", manDishName);
		return sb;
	}
	
	public String addnewrecipeButton() {
	    String sb = TagCreator.createButton("addnewrecipe", "Create a New Recipe");
		return sb;
	}

	/**
	 * 
	 * @return
	 */
	public String ingredientList() {
		StringBuilder sb = new StringBuilder();
		sb.append("<div><ul class=\"a\">");
		for (Ingredient ingredient : manIngredients) {
			sb.append("<li>" + ingredient.getIngredientLine() + "</li>");
		}
		sb.append("</ul></div>");
		return sb.toString();
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
	public String getManCookingStepsURL() {
		return manCookingStepsURL;
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

	/**
	 * 
	 */
	public Object handle(Request request, Response response) throws Exception {
		if ("/addingredients".equals(request.pathInfo())) {
			if (request.queryParams("recipename") != null) {
				manDishName = request.queryParams("recipename");
			}
			if (request.queryParams("recipeURL") != null) {
				manCookingStepsURL = request.queryParams("recipeURL");
			}
			if (request.queryParams("cookingtime") != null) {
				manCookingTimeInSeconds = Double.parseDouble(request.queryParams("cookingtime"));
			}
			if (request.queryParams("servingsize") != null) {
				manNumOfPeopleToServe = Integer.parseInt(request.queryParams("servingsize"));
			}
			if (request.queryParams("ingredientname") != null) {
				String ingredientLine = request.queryParams("ingredientname");
				Ingredient thisIngredient = new Ingredient(ingredientLine);
				manIngredients.add(thisIngredient);
			}
			manDish = new Dish(manDishName, manIngredients, manCookingStepsURL, manCookingTimeInSeconds,
					manNumOfPeopleToServe);
			manDish.setDishID("manual");
			
			return TagCreator.gethtmlHead("Add Ingredients")
					+ TagCreator.createBodyTitle("Enter your ingredients below:") + AddIngredientForm + ingredientList()
					+ displayRecipeButton() + TagCreator.getFooter() + TagCreator.closeTag();
		}
		if ("/addnewrecipe".equals(request.pathInfo())) {
		    new ManualRecipeInputHandler();
		    manDishName = "";
			manIngredients = new ArrayList<Ingredient>();
			manCookingStepsURL = "";
			manCookingTimeInSeconds = 0;
			manNumOfPeopleToServe = 0;
			manDish = null;
		}
		return TagCreator.gethtmlHead("Meal Planner Calendar") + TagCreator.createBodyTitle("Enter your recipe below:")
				+ recipeNameForm() + recipeURLForm() + cookingTimeForm() + servingsizeForm() + ingredientList()
				+ submitButton() + addnewrecipeButton() +
				TagCreator.getFooter() + TagCreator.closeTag();
	}

	public static Dish getManDish() {
		return manDish;
	}

}
