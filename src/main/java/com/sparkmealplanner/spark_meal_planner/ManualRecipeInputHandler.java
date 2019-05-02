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
	private final String AddIngredientForm = "<div><form action=\"/addingredients\" method=\"get\">Add new Ingredient:"
		+ "<input type=\"text\" name=\"ingredientname\">"
		+ "<button style=\"margin-left: 10px\" type=\"submit\">Add</button>"
		+ "</form></div>";
	private static Dish manDish;
	
	public ManualRecipeInputHandler() {
	    manDishName ="";
	    manIngredients = new ArrayList<Ingredient>();
	    manCookingStepsURL = "";
	    manCookingTimeInSeconds = 0;
	    manNumOfPeopleToServe= 0;
	    manDish = null;
	}
	/**
	 * This is a method to create a html field for the recipe name in the manual recipe entry form
	 * @return string with html code for recipe name field
	 */
	public String RecipeNameForm() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("<div> <form action = \"/addingredients\" method = \"get\">\r\n" + 
	    	"  Recipe Name:<br>\r\n" + 
	    	"  <input type=\"text\" name=\"recipename\" value = \"" + manDishName +"\"required>\r\n" + 
	    	"  <br>");
	    return sb.toString();
	}

	/**
	 * This is a method to create a field for the recipe URL in the manual recipe entry form
	 * @return string with html code for recipe URL field
	 */
	
	public String RecipeURLForm() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("  Recipe URL:<br>\r\n" + 
	    	"  <input type=\"URL\" name=\"recipeURL\" value = \"" + manCookingStepsURL + "\"required>\r\n" + 
	    	"  <br>");
	    return sb.toString();
	}
	public String CookingTimeForm() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Cooking Time in Minutes:<br>\r\n" + 
	    	"  <input type=\"number\" name=\"cookingtime\" value =\""+ manCookingTimeInSeconds+"\"required>\r\n" + 
	    	"  <br>");
	    return sb.toString();
	}	
	public String ServingsizeForm() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Serving size:<br>\r\n" + 
	    	"  <input type=\"number\" name=\"servingsize\" value =\""+ manNumOfPeopleToServe +"\"required>\r\n" + 
	    	"<button style=\"margin-left: 10px\" type=\"submit\">Add Ingredients</button>" + "</form></div>"+
	    	"  <br> +\r\n");
//	    sb.append("<button style=\"margin-left: 10px\" type=\"submit\">Submit The Recipe</button>" + "</form></div>");
	    return sb.toString();
	}
	public String DisplayRecipeButton() {
	    
	    String sb = TagCreator.createButton("addrecipe", "Display The recipe");
	    return sb;
	}
	
	public String submitButton() {
	    
	    String sb = TagCreator.createButton("addmanualrecipetocalendar", "Send To Calendar","recipename",manDishName);
	    return sb;
	}
//	public String IngredientListForm() {
//	    StringBuilder sb = new StringBuilder();
//	    sb.append("Please enter the number of ingredients in your recipe to proceed with adding the ingredient list:<input type=\"text\" id=\"ingredients\" name=\"ingredients\" value=\"\"><br />\r\n" + 
//	    	"<a href=\"#\" id=\"addingredients\" onclick=\"addFields()\">Add your list of Ingredients</a>\r\n" + 
//		"<button style=\"margin-left: 10px\" type=\"submit\">Submit The Recipe</button>" + "</form></div>" +
//	    	"<div id=\"container\"/>");
//	    return sb.toString();
//	}

	
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
	    if ("/addingredients".equals(request.pathInfo())){
		System.out.println("Reaching this point");
		if(request.queryParams("recipename")!=null) { 
		    manDishName = request.queryParams("recipename");
		}		
		System.out.println(manDishName);
		if(request.queryParams("recipeURL")!=null) {
		    manCookingStepsURL = request.queryParams("recipeURL");
		}
		if(request.queryParams("cookingtime")!=null) {
		    manCookingTimeInSeconds = Double.parseDouble(request.queryParams("cookingtime"));
		}
		if(request.queryParams("servingsize")!=null) {
		manNumOfPeopleToServe = Integer.parseInt(request.queryParams("servingsize"));
		}		
		if(request.queryParams("ingredientname")!=null) {
			String ingredientLine = request.queryParams("ingredientname");
			Ingredient thisIngredient = new Ingredient(ingredientLine);
			manIngredients.add(thisIngredient);			
		}
		manDish = new Dish(manDishName, manIngredients, manCookingStepsURL, manCookingTimeInSeconds, manNumOfPeopleToServe);
		System.out.println(manDish.getCookingStepsURL());
		return TagCreator.gethtmlHead("Add Ingredients") + AddIngredientForm + IngredientList() + DisplayRecipeButton() + TagCreator.getFooter() + TagCreator.closeTag();
	    }
	    
	    return TagCreator.gethtmlHead("Meal Planner Calendar") + 
	    		TagCreator.createBodyTitle("Enter your recipe below:")+
		    RecipeNameForm() + RecipeURLForm() + CookingTimeForm() +  ServingsizeForm() +  IngredientList() +  submitButton()+ //myfunction() + 
		    TagCreator.getFooter() + TagCreator.closeTag();
	}
	public static Dish getManDish() {
	    return manDish;
	}

}
