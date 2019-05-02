package com.sparkmealplanner.spark_meal_planner;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.JSONObject;

/**
 * This class contains the logic of the meal planner
 *
 */
public class MealPlanner {

	public void run() {

		//use http://localhost:4042 in browser
		port(4049);

		//creates various page handlers
		HomePageHandler homePageHandle = new HomePageHandler(); 
		RecipeSearchHandler recipeSearchHandler = new RecipeSearchHandler();
		CalendarHandler calendarHandler = new CalendarHandler();
		GroceryListHandler groceryListHandler = new GroceryListHandler();
		FAQHandler faqHandler = new FAQHandler();
		RecipeListDisplayHandler recipeListDisplayHandler = new RecipeListDisplayHandler();
		RecipeDisplayHandler recipeDisplayHandler = new RecipeDisplayHandler();
		ManualRecipeInputHandler manualRecipeHandler = new ManualRecipeInputHandler();
		
		get("/", homePageHandle); 
		get("/searchrecipe", recipeSearchHandler); //recipe search page path
		get("/addtocalendar", calendarHandler); //calendar page path
		get("/removefromcalendar", calendarHandler); //calendar page path
		get("/addmanualrecipetocalendar", calendarHandler); //calendar page path		
		get("/grocerylist", groceryListHandler); //grocery list page path
		get("/faqs", faqHandler);//retrieve meal plan page path
		get("/displayrecipelist", recipeListDisplayHandler);//create a display searched recipe path
		get("/displayfullrecipe", recipeListDisplayHandler);//create a display searched recipe path
		get("/recipechosen", recipeDisplayHandler);//create a display searched recipe path
		get("/addrecipe", manualRecipeHandler);//create a display of manual recipe
		get("/addingredients", manualRecipeHandler);//create a display of manual recipe

		// user input verification and related actions

		// add code here evaluate (if block) for retrieving old meal plan here

		/*
		 * if the user selected to retrieve an old meal plan, a file reader object will
		 * open and get lines from the old meal plan file.
		 * 
		 * Create a dish reader class to read lines and create a list of dishes.
		 */

		// add code here evaluate (else block) whether the user asked to create a new
		// meal plan

		// ask whether the user wants a default serving size? If so provide the number
		// of people that the recipe should serve to and store it in a variable

		// while loop - do the following until the user clicks the "done with mealplan"

		// Ask user whether they want to manually input the recipe or search the API for
		// a recipe

		// if the user wants to create it manually we can run it through 'Manual Recipe
		// Handler' and create a dish object using the DishReader class

		// if the user chooses to search for an recipe on the API, it will run through
		// the API handler class create a dish object using the DishReader class

//		String recipeToSearch = "";
//		YummlyAPIHandler apiHandler = new YummlyAPIHandler(recipeToSearch);
//
//		// search for recipes on yummly
//		try {
//			apiHandler.searchReceipe();
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		// user to chose the recipe (TODO add error catching here or use GUI to select)
//		String recipeChosen = "";
//
//		// get recipe of the chosen dish
//		String dishID = apiHandler.getDishID(recipeChosen);
//		try {
//
//			// create a new dish JSON object
//			JSONObject receipeJSON = apiHandler.getRecipe(dishID);
//
//			// create a new dish reader object
//			DishReader dishReader = new DishReader(receipeJSON);
//
//			// create a new dish object
//			Dish dishCreated = dishReader.getDishCreated();
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// if the serving size is different from the user's default size then use the
		// converter class to
		// convert the dish to a particular serving size

		// add the dish to the grocery list instance variable ArrayList of Dish

		// display empty calendar

		// ask the user for the day and meal to place the dish in the calendar

		// place the meal on the calendar

		/*
		 * Ask the user if the final calendar looks good to them. If not, continue the
		 * while loop and on the calendar swapameal, remove a meal or add a meal method
		 * to update it until finalized. Display calendar after each step
		 */

		// prompt user if they would like to check the grocery list against the pantry
		// items and update the grocery list by removing an item within a dish

		// Prompt the user if they would like to print the calendar or the grocery list

		// save the meal plan and recipe to a .csv file using a predefined mechanism
		// that can be parsed easily

	}
}
