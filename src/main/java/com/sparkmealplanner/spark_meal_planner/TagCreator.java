package com.sparkmealplanner.spark_meal_planner;

/**
 * This class is created from various static methods that allows the coders to
 * quickly create and reuse existing HTML codes
 *
 */
public class TagCreator {

	// The following HTML tags refer to the footer page links
	private static final String GoToHome = "<a href=\"/\"> Home </a>";
	private static final String GoToCalendar = "<a href=\"/addtocalendar\"> Calendar </a>";
	private static final String GoToGroceryList = "<a href=\"/grocerylist\"> GroceryList </a>";
	private static final String GoToSearchRecipe = "<a href=\"/searchrecipe\"> Search Recipes </a>";
	private static final String GoToFAQ = "<a href=\"/faqs\"> Frequently Asked Questions </a>";
	private static final String GoToRecipeInputFromURL = "<a href=\"/addnewrecipe\"> Add Recipes From URLs </a>";

	public static String returnULListCSSStyle() {
		return "ul.a { "+ 
//				"border-left: 5px solid red;" + 
//				"background-color: #f1f1f1;" + 
				"list-style-type: none;" + 
//				"padding: 10px 20px;" + 
				"}";
	}
	
	public static String returnButtonCSS() {
		return ".button {"
//				+ "border: none;"
//				+ "background-color: #555555;"
				+ "border: 1px solid black;"
				+ "padding: 3px 3px;"
				+ "font-family:verdana;"
				+ "font-size: 16px;"
//				+ "box-shadow: 0 0 20px rgba(0,0,0,0.2);"
				+ "border-radius: 5px;"
				+ "cursor: pointer;"
				+ "display: inline-block;"
				+ "}"
				+ ".butotn:hover {background: #eee;  transition: background-color .6s ease-out;}";
	}
	
	public static String returnTableCSSStyle() {

		return "#calendar {"
				// setting overall height and width in percentage
				+ "width: 70%;" + "height: 50%;" + "table-layout: fixed;"+  "}"

				// setting the attributes of table data elements
				+ "#calendar td, #customers th {" + "border: 1px solid #ddd;" + "padding: 4px;" + "text-align: center;" + "word-wrap:break-word"
				+ "}"

				// setting the attributes of table row elements
				+ "#calendar tr:nth-child(even){background-color: #f2f2f2;}"
				+ "#calendar tr:hover {background-color: #ddd;}"

				// setting the attributes of table heading elements
				+ "#calendar th {" + "padding-top: 12px;" + "padding-bottom: 12px;" + "text-align: center;"
				+ "background-color: gray;" + "color: white;";
	}

	public static String returnNavBarCSSStyle() {
		return
		// Add the style in the navigation bar
		".navbar {" + "overflow: hidden;" + " background-color: #333;" + " position: fixed;" + " top: 0;"
				+ " width: 100%;}"

				// Style the links inside the navigation bar */
				+ ".navbar a {" + "float: left;" + "display: block;" + "color: #f2f2f2;" + "text-align: center;"
				+ "padding: 14px 16px;" + "text-decoration: none;" + "font-size: 17px;}"

				// Change the color of links on hover
				+ ".navbar a:hover {" + "background: #f1f1f1;" + "color: black;}"

				// Style the "active" element to highlight the current page
				+ ".navbar a.active {" + "background-color: #4CAF50;" + "color: white;}";
	}

	/**
	 * The following returns an html head element
	 * 
	 * @param titleText title of the html head page
	 * @return html page
	 */
	public static String gethtmlHead(String titleText) {
		return "<html><head><style> " + returnNavBarCSSStyle() + returnButtonCSS() +  returnTableCSSStyle() + returnULListCSSStyle() + "</style><title>" + titleText
				+ "</title></head>";
	}

	/**
	 * The following method returns a footer html element
	 * 
	 * @return footer html tag
	 */
	public static String getFooter() {
		return "<div class=\"navbar\">" + GoToHome + GoToCalendar + GoToGroceryList + GoToSearchRecipe
				+ GoToRecipeInputFromURL + GoToFAQ + "</div>";
	}

	/**
	 * The following method creates a button html element
	 * 
	 * @param pageUrlToDirect     page url
	 * @param ButtonTextToDisplay Button text
	 * @return HTML
	 */
	public static String createButton(String pageUrlToDirect, String ButtonTextToDisplay) {
		return "<button class = \"button\"type=\"button\" onclick=\"location.href='/" + pageUrlToDirect + "'\">"
				+ ButtonTextToDisplay + "</button>";
	}

	/**
	 * The following method returns an html element with button with one ID
	 * parameter to pass.
	 * 
	 * @param pageUrlToDirect     page url
	 * @param ButtonTextToDisplay button text
	 * @param ID                  ID
	 * @return HTML
	 */
	public static String createButton(String pageUrlToDirect, String ButtonTextToDisplay, String param1Name,
			String param1Info) {
		return "<button class =\"button\" type=\"button\" \"margin-left: 10px\" onclick=\"location.href='/" + pageUrlToDirect + "?"
				+ param1Name + "=" + param1Info + "'\">" + ButtonTextToDisplay + "</button>";
	}

	/**
	 * The following method returns an html element with button with two ID
	 * parameters to pass.
	 * 
	 * @param pageUrlToDirect     page Url To Direct
	 * @param ButtonTextToDisplay Button Text To Display
	 * @param param1Name          param#1 Name
	 * @param param1Info          param#1 Info
	 * @param param2Name          param#2Name
	 * @param param2Info          param#2 Info
	 * @return HTML
	 */
	public static String createButton(String pageUrlToDirect, String ButtonTextToDisplay, String param1Name,
			String param1Info, String param2Name, String param2Info) {
		return "<button class =\"button\" type=\"button\" \"margin-left: 10px\" onclick=\"location.href='/" + pageUrlToDirect + "?"
				+ param1Name + "=" + param1Info + "&" + param2Name + "=" + param2Info + "'\">" + ButtonTextToDisplay
				+ "</button>";
	}

	/**
	 * The following method returns an html element with button with two ID
	 * parameters to pass.
	 * 
	 * @param pageUrlToDirect     page Url To Direct
	 * @param ButtonTextToDisplay Button Text To Display
	 * @param param1Name          param#1 Name
	 * @param param1Info          param#1 Info
	 * @param param2Name          param#2Name
	 * @param param2Info          param#2 Info
	 * @return HTML
	 */
	public static String createButton(String pageUrlToDirect, String ButtonTextToDisplay, String param1Name,
			String param1Info, String param2Name, String param2Info, String param3Name, String param3Info) {
		return "<button class =\"button\" type=\"button\" \"margin-left: 10px\" onclick=\"location.href='/" + pageUrlToDirect + "?"
				+ param1Name + "=" + param1Info + "&" + param2Name + "=" + param2Info + "&" + param3Name + "=" + param3Info +"'\">" + ButtonTextToDisplay
				+ "</button>";
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
	 * 
	 * @return HTML
	 */
	public static String createPrintThisButton() {
		return "<button class = \"button\" onclick=\"window.print()\">Print This Page</button>";

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
