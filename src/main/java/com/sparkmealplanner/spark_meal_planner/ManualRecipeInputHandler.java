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
	private String manCookingStepsURL;
	private double manCookingTimeInSeconds;
	private int manNumOfPeopleToServe;

	public ManualRecipeInputHandler() {
	    manDishName ="";
	    manIngredients = new ArrayList<Ingredient>();
	}
	/**
	 * This is method name 
	 * @return This returns a html string which is later used in the handle method
	 */
	public String AddRecipeForm() {
	    StringBuilder sb = new StringBuilder();
	    return sb.toString();
	}
	public String RecipeNameForm() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("<div> <form action = \"/addingredients\" method = \"post\">\r\n" + 
	    	"  Recipe Name:<br>\r\n" + 
	    	"  <input type=\"text\" name=\"recipename\"required>\r\n" + 
	    	"  <br>");
	    return sb.toString();
	}	
	public String RecipeURLForm() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("  Recipe URL:<br>\r\n" + 
	    	"  <input type=\"URL\" name=\"recipeURL\"required>\r\n" + 
	    	"  <br>");
	    return sb.toString();
	}
	public String CookingTimeForm() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Cooking Time in Minutes:<br>\r\n" + 
	    	"  <input type=\"number\" name=\"cookingtime\"required>\r\n" + 
	    	"  <br>");
	    return sb.toString();
	}	
	public String ServingsizeForm() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Serving size:<br>\r\n" + 
	    	"  <input type=\"number\" name=\"servingsize\"required>\r\n" + 
	    	"  <br>");
	    return sb.toString();
	}
	
	public String IngredientListForm() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Please enter the number of ingredients in your recipe to proceed with adding the ingredient list:<input type=\"text\" id=\"ingredients\" name=\"ingredients\" value=\"\"><br />\r\n" + 
	    	"<a href=\"#\" id=\"addingredients\" onclick=\"addFields()\">Add your list of Ingredients</a>\r\n" + 
		"<button style=\"margin-left: 10px\" type=\"submit\">Submit The Recipe</button>\"" + "</form></div>" +
	    	"<div id=\"container\"/>");
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
	public String myfunction() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("<script>");
	    sb.append("        function addFields(){\r\n" + 
	    	"            var number = document.getElementById(\"ingredients\").value;\r\n" + 
	    	"            var container = document.getElementById(\"container\");\r\n" + 
	    	"            while (container.hasChildNodes()) {\r\n" + 
	    	"                container.removeChild(container.lastChild);\r\n" + 
	    	"            }\r\n" + 
	    	"            for (i=0;i<number;i++){\r\n" + 
	    	"                container.appendChild(document.createTextNode((i+1)));\r\n" + 
	    	"                var input = document.createElement(\"input\");\r\n" + 
	    	"                input.type = \"text\";\r\n" + 
	    	"                container.appendChild(input);\r\n" + 
	    	"                container.appendChild(document.createElement(\"br\"));\r\n" + 
	    	"            }\r\n" + 
	    	"        }");
	    sb.append("</script>");
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

	public Object handle(Request request, Response response) throws Exception {
	    if ("/addingredients".contentEquals(request.pathInfo())){
		manDishName = request.queryParams("recipename");
		manCookingStepsURL = request.queryParams("recipeURL");
		manCookingTimeInSeconds = Double.parseDouble(request.queryParams("cookingtime"));
		manNumOfPeopleToServe = Integer.parseInt(request.queryParams("servingsize"));
		int numberOfIngredients = Integer.parseInt(request.queryParams("ingredients"));
		for (int i = 0; i < numberOfIngredients;i++) {
		    String id = Integer.toString(i)+1;
			String ingredientLine = request.queryParams("ingredient" + id);
			Ingredient ingredient = new Ingredient(ingredientLine);
			manIngredients.add(ingredient);
		}

	    }
	    return TagCreator.gethtmlHead("Meal Planner Calendar") + 
		    RecipeNameForm() + RecipeURLForm() + CookingTimeForm() +  ServingsizeForm() +  IngredientListForm() + myfunction() + IngredientList()+
		    TagCreator.getFooter() + TagCreator.closeTag();
	}

}
