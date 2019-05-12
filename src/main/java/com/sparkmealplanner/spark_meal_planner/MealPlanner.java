package com.sparkmealplanner.spark_meal_planner;

import static spark.Spark.get;
import static spark.Spark.port;

/**
 * This class contains the get and post methods of the handlers
 */
public class MealPlanner {

	public void run() {

		// use http://localhost:8081 in browser
		port(8081);

		// creates various page handlers
		HomePageHandler homePageHandle = new HomePageHandler();
		RecipeSearchHandler recipeSearchHandler = new RecipeSearchHandler();
		CalendarHandler calendarHandler = new CalendarHandler();
		GroceryListHandler groceryListHandler = new GroceryListHandler();
		FAQHandler faqHandler = new FAQHandler();
		RecipeListDisplayHandler recipeListDisplayHandler = new RecipeListDisplayHandler();
		RecipeDisplayHandler recipeDisplayHandler = new RecipeDisplayHandler();
		ManualRecipeInputHandler manualRecipeHandler = new ManualRecipeInputHandler();

		// create get methods
		get("/", homePageHandle);
		get("/searchrecipe", recipeSearchHandler); // recipe search page path
		get("/grocerylist", groceryListHandler); // grocery list page path
		get("/removeFromGroceryList", groceryListHandler); // remove from grocery list page path
		get("/faqs", faqHandler);// FAQ page path
		get("/displayrecipelist", recipeListDisplayHandler);// display searched recipe list path
		get("/displayfullrecipe", recipeListDisplayHandler);// display full recipe path
		get("/recipechosen", recipeDisplayHandler);// recipe chosen path
		get("/addrecipe", manualRecipeHandler);// add recipe path
		get("/addingredients", manualRecipeHandler);// add ingredient path
		get("/addnewrecipe", manualRecipeHandler);// add new recipe path
		get("/selectameal", calendarHandler); // select a meal page path
		get("/calendar", calendarHandler); // calendar page path
		get("/addtocalendar", calendarHandler); // add to calendar page path
		get("/removefromcalendar", calendarHandler); // remove from calendar page path
		get("/addmanualrecipetocalendar", calendarHandler); // add manual recipe to calendar page path

	}
}
