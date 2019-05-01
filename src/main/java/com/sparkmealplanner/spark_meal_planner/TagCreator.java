package com.sparkmealplanner.spark_meal_planner;

public class TagCreator {

	// The following html tags refer to the footer page links
	private static final String GoToHome = "<br><br><a href=\"/\">Home </a>";
	private static final String GoToCalendar = "<a href=\"/calendar\">|  Calendar </a>";
	private static final String GoToGroceryList = "<a href=\"/grocerylist\">|  GroceryList </a>";
	private static final String GoToSearchRecipe = "<a href=\"/searchrecipe\">|  Search Recipes </a>";
	private static final String GoToFAQ = "<a href=\"/faqs\">|  Frequently Asked Questions </a>";
	private static final String GoToRecipeInputFromURL = "<a href=\"/addrecipe\">|  Add Recipes From URLs </a>";

	/**
	 * The following returns an html head element
	 * 
	 * @param titleText title of the html head page
	 * @return html page
	 */
	public static String gethtmlHead(String titleText) {
		return "<html><head><style>table, th, td {border: 1px solid black;</style><title>" + titleText + "</title></head>";
	}

	/**
	 * The following method returns a footer html element
	 * 
	 * @return footer html tag
	 */
	public static String getFooter() {
		return GoToHome + GoToCalendar + GoToGroceryList + GoToSearchRecipe + GoToRecipeInputFromURL + GoToFAQ;
	}

	/**
	 * The following method creates a button html element
	 * 
	 * @param pageUrlToDirect
	 * @param ButtonTextToDisplay
	 * @return
	 */
	public static String createButton(String pageUrlToDirect, String ButtonTextToDisplay) {
		return "<button type=\"button\" \"margin-left: 10px\" onclick=\"location.href='/" + pageUrlToDirect + "'\">"
				+ ButtonTextToDisplay + "</button>";
	}

	/**
	 * The following method returns an html element with button with ID parameter to
	 * pass.
	 * 
	 * @param pageUrlToDirect
	 * @param ButtonTextToDisplay
	 * @param ID
	 * @return
	 */
	public static String createButton(String pageUrlToDirect, String ButtonTextToDisplay, String param1Name, String param1Info) {
		return "<button type=\"button\" \"margin-left: 10px\" onclick=\"location.href='/" + pageUrlToDirect + "?" + param1Name+ "="
				+ param1Info + "'\">" + ButtonTextToDisplay + "</button>";
	}

	/**
	 * The following method returns an html element with button with ID parameter to
	 * pass.
	 * 
	 * @param pageUrlToDirect
	 * @param ButtonTextToDisplay
	 * @param ID
	 * @return
	 */
	public static String createButton(String pageUrlToDirect, String ButtonTextToDisplay, String param1Name, String param1Info, String param2Name, String param2Info) {
		return "<button type=\"button\" \"margin-left: 10px\" onclick=\"location.href='/" + pageUrlToDirect + "?" + param1Name+ "="
				+ param1Info +"&" + param2Name + "=" + param2Info + "'\">" + ButtonTextToDisplay + "</button>";
	}

	
	
	/**
	 * The following method creates a title in the body tag
	 * 
	 * @param title
	 * @return
	 */
	public static String createBodyTitle(String title) {
		return "<body><h3>" + title + "</h3>";
	}

	/**
	 * The following method create a paragraph html element
	 * 
	 * @param text
	 * @return
	 */
	public static String createAParagraph(String text) {
		return "<p>" + text + "</p>";
	}

	
	public static String createPrintThisButton() {
		return "<button onclick=\"window.print()\">Print This Page</button>";
				
	}
	/**
	 * The following method closes the body and html tags.
	 * 
	 * @return
	 */
	public static String closeTag() {
		return "</body></html>";
	}
	
}
