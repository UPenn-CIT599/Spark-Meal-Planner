package com.sparkmealplanner.spark_meal_planner;

import java.util.ArrayList;
import spark.Request;
import spark.Response;
import spark.Route;

/**
 * This is a class to be used for the page of the app when user wants to
 * manually input a recipe from an external url
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
	 * The following constructor initiates the instance variables needed for the
	 * page
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
		sb.append("Recipe URL:<br>\r\n" + "  <input type=\"URL\" name=\"recipeURL\" value = \"" + manCookingStepsURL
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
		sb.append("Cooking Time in Minutes:<br>\r\n"
				+ "  <input type=\"number\" name=\"cookingtime\" min = \"1\"value =\"" + (int) manCookingTimeInSeconds
				+ "\"required>\r\n" + "  <br>");
		return sb.toString();
	}

	/**
	 * The following class returns the serving size input field to be filled in HTML
	 * 
	 * @return HTML string
	 */
	public String servingsizeForm() {
		StringBuilder sb = new StringBuilder();
		sb.append("Serving size:<br>\r\n" + "  <input type=\"number\" name=\"servingsize\" min = \"1\" value =\""
				+ manNumOfPeopleToServe + "\"required>\r\n" + "<br><br>"
				+ "<button class = \" button\" type=\"submit\">Add Ingredients To Proceed</button>" + "</form></div>"
				+ "  <br>\r\n");
		return sb.toString();
	}

	/**
	 * The following method creates a button with the text "Display the Recipe".
	 * Clicking on this button takes the user to a page from where they can add it
	 * to the calendar
	 * 
	 * @return HTML string
	 */
	public String displayRecipeButton() {

		String sb = HtmlWriter.createButton("addrecipe", "Display The recipe");
		return sb;
	}

	/**
	 * This method creates an html button that lets the user submit the recipe for
	 * the creation of a dish object and lets them add it to their calendar
	 * 
	 * @return HTML string
	 */
	public String submitButton() {

		String sb = HtmlWriter.createButton("addmanualrecipetocalendar", "Send To Calendar", "recipename", manDishName);
		return sb;
	}

	/**
	 * This method creates an HTML button that lets the user to refresh the recipe
	 * adding page to default blank fields
	 * 
	 * @return HTML string
	 */
	public String addnewrecipeButton() {
		String sb = HtmlWriter.createButton("addnewrecipe", "Create a New Recipe");
		return sb;
	}

	/**
	 * This method creates an HTML unordered list object to display the list of
	 * ingredients entered by the user for a recipe
	 * 
	 * @return HTML string
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
	 * Handle method to create a form to collect details of a recipe from the user
	 */
	public Object handle(Request request, Response response) throws Exception {

		if ("/addingredients".equals(request.pathInfo())) {

			// storing variables from the request
			if (request.queryParams("recipename") != null) {
				manDishName = request.queryParams("recipename");
			}
			if (request.queryParams("recipeURL") != null) {
				manCookingStepsURL = request.queryParams("recipeURL");
			}
			if (request.queryParams("cookingtime") != null) {
				manCookingTimeInSeconds = Double.parseDouble(request.queryParams("cookingtime")) * 60;
			}
			if (request.queryParams("servingsize") != null) {
				manNumOfPeopleToServe = Integer.parseInt(request.queryParams("servingsize"));
			}
			if (request.queryParams("ingredientname") != null) {
				String ingredientLine = request.queryParams("ingredientname");
				Ingredient thisIngredient = new Ingredient(ingredientLine);
				manIngredients.add(thisIngredient);
			}

			// creating a dish object
			manDish = new Dish("manual", manDishName, manIngredients, manCookingStepsURL, manCookingTimeInSeconds,
					manNumOfPeopleToServe);

			// returns the "add ingredients page" first
			return HtmlWriter.gethtmlHead("Add Ingredients")
					+ HtmlWriter.createBodyTitle("Enter your ingredients below:") + AddIngredientForm + ingredientList()
					+ displayRecipeButton() + HtmlWriter.getFooter() + HtmlWriter.closeTag();
		}
		
		// this is the default page where the user clicks the link to add recipe from
		// URL manually
		if ("/addnewrecipe".equals(request.pathInfo())) {

			// creating an instance of the Handler
			new ManualRecipeInputHandler();

			// initializing the variables with each request to clear prior recipe
			// information
			manDishName = "";
			manIngredients = new ArrayList<Ingredient>();
			manCookingStepsURL = "";
			manCookingTimeInSeconds = 0;
			manNumOfPeopleToServe = 0;
			manDish = null;

			// default HTML landing page (does not have an option to submit to calendar
			// until the ingredient add page is shown).
			return HtmlWriter.gethtmlHead("Meal Planner Calendar")
					+ HtmlWriter.createBodyTitle("Enter your recipe below:") + recipeNameForm() + recipeURLForm()
					+ cookingTimeForm() + servingsizeForm() + ingredientList() + HtmlWriter.getFooter()
					+ HtmlWriter.closeTag();

		}

		// once the user comes back from the "add ingredient" page, the user lands here
		// (extra option of submitting to the calendar)
		return HtmlWriter.gethtmlHead("Meal Planner Calendar") + HtmlWriter.createBodyTitle("Enter your recipe below:")
				+ recipeNameForm() + recipeURLForm() + cookingTimeForm() + servingsizeForm() + ingredientList()
				+ submitButton() + addnewrecipeButton() + HtmlWriter.getFooter() + HtmlWriter.closeTag();
	}

	/**
	 * getter method
	 * 
	 * @return a manually input dish object
	 */
	public static Dish getManDish() {
		return manDish;
	}

}
