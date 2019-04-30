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
	public final String IngredientForm = "<div><form action =\"/addIngredient\" method = \"post\"> Add new Ingredient:"+
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
	public String RecipeNameForm() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("<div> <form>\r\n" + 
	    	"  Recipe Name:<br>\r\n" + 
	    	"  <input type=\"text\" name=\"recipename\"required>\r\n" + 
	    	"  <br></form></div>");
	    sb.append("<button><a href=\"/recipeName\">Submit</a></button>");
	    return sb.toString();
	}
	
	public String RecipeURLForm() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("<div> <form>\r\n" + 
	    	"  Recipe URL:<br>\r\n" + 
	    	"  <input type=\"URL\" name=\"recipeURL\"required>\r\n" + 
	    	"  <br></form></div>");
	    return sb.toString();
	}
	
	public String IngredientListForm() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("<div><form>\r\n" + 
	    	"    <p>\r\n" + 
	    	"        <label>Ingredient Name:</label> <input type=\"text\">\r\n" + 
	    	"        <span class=\"remove\">Remove</span>\r\n" + 
	    	"    </p>\r\n" + 
	    	"    <p>\r\n" + 
	    	"        <span class=\"add\">Add fields</span>\r\n" + 
	    	"    </p>\r\n" + 
	    	"</form><div>");
	    return sb.toString();
	}
	
	public String IngredientList() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("<div><ol>");
	    for (Ingredient ingredient : manIngredients) {
		sb.append("<li>" + ingredient.getIngredientLine() + "</li>");
	    }
	    sb.append("</ol></div>");
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
	    else if ("/addIngredient".contentEquals(request.pathInfo())){
		String ingredientLine = request.queryParams("ingredientLine");
		Ingredient i = new Ingredient(ingredientLine);
		manIngredients.add(i);
	    }
	    return TagCreator.gethtmlHead("Meal Planner Calendar") + 
		    RecipeNameForm() + RecipeURLForm() + IngredientListForm() + IngredientList() + 
		    TagCreator.getFooter() + "</body></html>";
	}

}
