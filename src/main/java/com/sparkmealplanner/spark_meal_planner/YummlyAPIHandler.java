package com.sparkmealplanner.spark_meal_planner;

import java.io.*;
import java.net.*;
import java.util.*;
import org.json.*;

/**
 * Before using this class, add the external JSON jar file located in the Meal
 * Planner folder. Use File/properties/Java Build Path/Add external/Jars/select
 * file/java-json.jar"
 * 
 * The following class uses Yummly.com API at "http://api.yummly.com/v1" to pull
 * information on recipes. Below code was adopted from below web sites but was
 * modified for this assignment purposes:
 * 
 * https://docs.oracle.com/javase/tutorial/networking/urls/readingWriting.html
 */
public class YummlyAPIHandler {
	private static JSONObject getRecipeJSON;
	private static JSONObject searchRecipeJSON;
	private String recipeToSearch;
	private String recipeName;
	private static String dishID;
	private static HashMap<String, String> recipeNameAndDishID = new HashMap<String, String>();
	private static String recipeStepsURL;
	private static String searchRecipeAttributionhtml;
	private static String getRecipeAttributionhtml;

	/**
	 * The following constructor creates an API handler object specific to
	 * yummly.com API
	 * 
	 * @param recipeToSearch recipe name to search
	 */
	public YummlyAPIHandler() {
		//this.recipeToSearch = recipeToSearch;
	}

	/**
	 * @return the getRecipeJSON
	 */
	public static JSONObject getGetRecipeJSON(String dishID) {
		return getRecipeJSON;
	}

	/**
	 * Getter method
	 * 
	 * @return the recipeNameAndDishID
	 */
	public static HashMap<String, String> getRecipeNameAndDishID() {
		return recipeNameAndDishID;
	}

	/**
	 * Getter method
	 * 
	 * @return the searchRecipeJSON
	 */
	public static JSONObject getSearchRecipeJSON(String recipeToSearch) {
		return searchRecipeJSON;
	}
	
	

	/**
	 * Getter method
	 * 
	 * @return the searchRecipeAttributionhtml
	 */
	public static String getSearchRecipeAttributionhtml() {
		return searchRecipeAttributionhtml;
	}

	/**
	 * Getter method
	 * 
	 * @return the getRecipeAttributionhtml
	 */
	public static String getGetRecipeAttributionhtml() {
		return getRecipeAttributionhtml;
	}

	/**
	 * 
	 * The following method sends search recipe request to Yummly API and returns 20
	 * recipes/dishes to chose from. It also returns a HashMap of recipe name and
	 * recipe ID.
	 * 
	 * @return hashmap of recipe name and ID
	 * @throws Exception
	 */
	public static HashMap<String, String> searchReceipe(String recipeToSearch) throws Exception {

	//	this.recipeToSearch = recipeToSearch;
		
		// URLencoding parameter names and values (i.e. replacing " " to "+")
		recipeToSearch = recipeToSearch.replace(" ", "+");

		// searching the recipe and limiting the results to 20 with 10 recipes per page
		String url = "http://api.yummly.com/v1/api/recipes?_app_id=07657d11&_app_key=6d13fda0951bfe4dc2f12d1690058462&q="
				+ recipeToSearch + "&maxResult=20&start=10";

		// initializing the url object
		URL yummylySearchURL = new URL(url);
		//System.out.println("search url: " + yummylySearchURL);

		// opens the connection
		HttpURLConnection connection = (HttpURLConnection) yummylySearchURL.openConnection();

		// checking response code for continuation of the process
		int responseCode = connection.getResponseCode();
		// System.out.println("Response Code : " + responseCode);
		getResponseCodeExplanation(responseCode);

		// continue the process only if a valid response code of 200 is given by API
		if (responseCode == 200) {

			// initializing buffer reader and string buffer to read the response stream
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String inputLine;
			while ((inputLine = in.readLine()) != null) {

				// creating a JSON object to obtain information
				JSONObject searchRecipeJSON = new JSONObject(inputLine);
				searchRecipeJSON = searchRecipeJSON;
//				System.out.println();

				// creating JSON array which is linked to key "matches" in the JSON object
				JSONArray receipesArray = searchRecipeJSON.getJSONArray("matches");
//				System.out.println("total recipes " + receipesArray.length());
				
				
				// looping through the JSON array
				for (int i = 0; i < receipesArray.length(); i++) {
//					System.out.println(receipesArray.get(i));

					// creating JSON object of dish info
					JSONObject dishInfo = (JSONObject) receipesArray.get(i);

					// key "recipeName" stores the name of the recipe in the the JSON object
					String recipeName = (String) dishInfo.get("recipeName");

					// adding index in front of the recipe name
					//System.out.println(i + 1 + ". " + recipeName);

					// storing dish ID
					String dishID = (String) dishInfo.get("id");
//					System.out.println("Dish Id: " + dishInfo.get("id") + "\n");
					recipeNameAndDishID.put(recipeName, dishID);
				}

				// JSON object "attribution" stores information such as "text", "url", and
				// "logo" related to the attribution
				//System.out.println("Attributions:");
				JSONObject attribution = searchRecipeJSON.getJSONObject("attribution");
				searchRecipeAttributionhtml = (String) attribution.get("html");
				//System.out.println(searchRecipeAttributionhtml);
				//recipeNameAndDishID.put("Attribution html", searchRecipeAttributionhtml);

				//System.out.println(attribution.get("text") + " at: " + attribution.get("url"));
				//System.out.println("Find logo at: " + attribution.get("logo") + "\n");

			}
			in.close();
		}

		return recipeNameAndDishID;
	}

	/**
	 * The following method get recipe request to Yummly API and returns a JSON
	 * object
	 * 
	 * @param recipeID recipeID
	 * @throws Exception
	 * @return JSON object from Yummly
	 */
	public static JSONObject getRecipe(String recipeID) throws Exception {

		// URLencoding parameter names and values (i.e. replacing " " to "+")
		String url = "http://api.yummly.com/v1/api/recipe/" + recipeID
				+ "?_app_id=07657d11&_app_key=6d13fda0951bfe4dc2f12d1690058462";
		//System.out.println("get recipe url: " + url);

		// initializing the url and connection objects
		URL yummylySearchURL = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) yummylySearchURL.openConnection();

		// checking response code for continuation of the process
		int responseCode = connection.getResponseCode();

		//System.out.println("Response Code : " + responseCode);
		getResponseCodeExplanation(responseCode);

		// continue the process only if a valid response code of 200 is given by API
		// (valid response)
		if (responseCode == 200) {

			// initializing buffer reader and string buffer to read the response stream
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			// looping through the buffer reader lines
			String inputLine;
			while ((inputLine = in.readLine()) != null) {

				// creating a JSON object to obtain information
				getRecipeJSON = new JSONObject(inputLine);
//				System.out.println("passed");
//				System.out.println(getRecipeJSON.toString());

				// The following is created to meet Yummly's mandatory attribution requirements

				// JSON object "source" stores information on the original source of the recipe
				JSONObject source = getRecipeJSON.getJSONObject("source");
				recipeStepsURL = (String) source.get("sourceRecipeUrl");
				//System.out.println("Find Recipe steps at: " + recipeStepsURL);

				// JSON object "attribution" stores information such as "text", "url", and
				// "logo" related to the attribution
				JSONObject attribution = getRecipeJSON.getJSONObject("attribution");
				getRecipeAttributionhtml = (String) attribution.get("html");
			}
			in.close();
		}
		return getRecipeJSON;
	}

	/**
	 * The following method returns the dishID based on the recipe name
	 * 
	 * @param receipeName recipe name
	 * @return dishID
	 */
	public static String getDishID(String receipeName) {
		dishID = recipeNameAndDishID.get(receipeName);
		return dishID;
	}

	/**
	 * Per Yummly API documentation the response code has the following
	 * interpretations
	 * 
	 * @param responseCode response code
	 */
	public static void getResponseCodeExplanation(int responseCode) {
		// error checking for the response code (i.e. 200 being valid, 400 being bad
		// request, 409 being API limit exceeded, and 500 being Internal Server Error

		if (responseCode == 200) {
			// System.out.println("This is a valid API request.");
		} else if (responseCode == 400) {
			System.out.println("This is a bad request. Please modify your request.");
		} else if (responseCode == 409) {
			System.out.println("API limit has exceeded. Please try again tomorrow.");
		} else if (responseCode == 409) {
			System.out.println("API limit has exceeded. Please try again tomorrow.");
		} else if (responseCode == 500) {
			System.out.println("This is an internal server error. Please try again later.");
		} else {
			System.out.println(
					"There is an error that cannot be resolved at this moment. Please try again later or contact the project manager to resolve it");
		}
	}
}
