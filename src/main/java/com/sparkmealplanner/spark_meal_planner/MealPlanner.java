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

		// use http://localhost:4042 in browser
		port(8092);
		
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
		get("/removeFromGroceryList", groceryListHandler); // grocery list page path
		get("/faqs", faqHandler);// retrieve meal plan page path
		get("/displayrecipelist", recipeListDisplayHandler);// create a display searched recipe path
		get("/displayfullrecipe", recipeListDisplayHandler);// create a display searched recipe path
		get("/recipechosen", recipeDisplayHandler);// create a display searched recipe path
		get("/addrecipe", manualRecipeHandler);// create a display of manual recipe
		get("/addingredients", manualRecipeHandler);// create a display of manual recipe
		get("/addnewrecipe", manualRecipeHandler);// create a display of manual recipe
		get("/selectameal", calendarHandler);
		get("/calendar", calendarHandler); // calendar page path
		get("/addtocalendar", calendarHandler); // calendar page path
		get("/removefromcalendar", calendarHandler); // calendar page path
		get("/addmanualrecipetocalendar", calendarHandler); // calendar page path

	}
}
