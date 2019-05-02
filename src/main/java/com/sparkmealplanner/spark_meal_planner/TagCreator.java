package com.sparkmealplanner.spark_meal_planner;

/**
 * This class is created from various static methods that allows the coders to quickly create and reuse
 * existing HTML codes
 *
 */
public class TagCreator {

	// The following html tags refer to the footer page links
	private static final String GoToHome = "<a href=\"/\"> Home </a>";
	private static final String GoToCalendar = "<a href=\"/addtocalendar\"> Calendar </a>";
	private static final String GoToGroceryList = "<a href=\"/grocerylist\"> GroceryList </a>";
	private static final String GoToSearchRecipe = "<a href=\"/searchrecipe\"> Search Recipes </a>";
	private static final String GoToFAQ = "<a href=\"/faqs\"> Frequently Asked Questions </a>";
	private static final String GoToRecipeInputFromURL = "<a href=\"/addrecipe\"> Add Recipes From URLs </a>";

	public static String returnCSSStyle() {
		return 
		// Add the style in the navigation bar
		 ".navbar {"
		+ "overflow: hidden;"
		+ " background-color: #333;"
		+ " position: fixed;"
		+ " top: 0;"
		+ " width: 100%;}"
		
		// Style the links inside the navigation bar */
		+ ".navbar a {"
		+ "float: left;"
		+ "display: block;"
		+ "color: #f2f2f2;"
		+ "text-align: center;"
		+ "padding: 14px 16px;"
		+ "text-decoration: none;"
		+ "font-size: 17px;}"
		
		// Change the color of links on hover 
		+".navbar a:hover {"
		+ "background: #f1f1f1;"
		+"color: black;}"
		
		// Style the "active" element to highlight the current page
		+".navbar a.active {"
		+"background-color: #4CAF50;"
		+"color: white;}";
	}
	/**
	 * The following returns an html head element
	 * 
	 * @param titleText title of the html head page
	 * @return html page
	 */
	public static String gethtmlHead(String titleText) {
		return "<html><head><style> "+ returnCSSStyle() + "table, th, td {border: 1px solid black;</style><title>" + titleText + "</title></head>";
	}

	/**
	 * The following method returns a footer html element
	 * 
	 * @return footer html tag
	 */
	public static String getFooter() {
		return  "<div class=\"navbar\">"+
				GoToHome 
				+ GoToCalendar 
				+ GoToGroceryList 
				+ GoToSearchRecipe 
				+ GoToRecipeInputFromURL 
				+ GoToFAQ
				+"</div>";
	}

	/**
	 * The following method creates a button html element
	 * 
	 * @param pageUrlToDirect page url
	 * @param ButtonTextToDisplay Button text
	 * @return HTML
	 */
	public static String createButton(String pageUrlToDirect, String ButtonTextToDisplay) {
		return "<button type=\"button\" \"margin-left: 10px\" onclick=\"location.href='/" + pageUrlToDirect + "'\">"
				+ ButtonTextToDisplay + "</button>";
	}

	/**
	 * The following method returns an html element with button with one ID parameter to
	 * pass.
	 * 
	 * @param pageUrlToDirect page url
	 * @param ButtonTextToDisplay button text
	 * @param ID ID
	 * @return HTML
	 */
	public static String createButton(String pageUrlToDirect, String ButtonTextToDisplay, String param1Name, String param1Info) {
		return "<button type=\"button\" \"margin-left: 10px\" onclick=\"location.href='/" + pageUrlToDirect + "?" + param1Name+ "="
				+ param1Info + "'\">" + ButtonTextToDisplay + "</button>";
	}

	/**
	 * The following method returns an html element with button with two ID parameters to
	 * pass.
	 * @param pageUrlToDirect page Url To Direct
	 * @param ButtonTextToDisplay Button Text To Display
	 * @param param1Name param#1 Name
	 * @param param1Info param#1 Info
	 * @param param2Name param#2Name
	 * @param param2Info param#2 Info
	 * @return HTML
	 */
	public static String createButton(String pageUrlToDirect, String ButtonTextToDisplay, String param1Name, String param1Info, String param2Name, String param2Info) {
		return "<button type=\"button\" \"margin-left: 10px\" onclick=\"location.href='/" + pageUrlToDirect + "?" + param1Name+ "="
				+ param1Info +"&" + param2Name + "=" + param2Info + "'\">" + ButtonTextToDisplay + "</button>";
	}
	
	/**
	 * The following method creates a title in the body tag
	 * 
	 * @param title title to display
	 * @return HTML
	 */
	public static String createBodyTitle(String title) {
		return "<body><br><br><h3>" + title + "</h3>";
	}

	/**
	 * The following method create a paragraph html element
	 * 
	 * @param text text to display
	 * @return HTML
	 */
	public static String createAParagraph(String text) {
		return "<p>" + text + "</p>";
	}
	
	/**
	 * The following method creates a print this page button
	 * @return HTML
	 */
	public static String createPrintThisButton() {
		return "<button onclick=\"window.print()\">Print This Page</button>";
				
	}
	
	/**
	 * The following method closes the body and html tags.
	 * 
	 * @return HTML
	 */
	public static String closeTag() {
		return "</body></html>";
	}
	
}
