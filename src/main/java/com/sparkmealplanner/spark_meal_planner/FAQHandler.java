package com.sparkmealplanner.spark_meal_planner;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * This class handles the FAQ (Frequently Asked Questions) page of this app
 *
 */
public class FAQHandler implements Route {

	private String pageTitle = "Frequently Asked Questions";
	private String question1 = "How to save a meal plan?";
	private String answer1 = "Go to your browser's menu bar. Click on \"File\" and \"Save as\". "
			+ "Once clicked, you will be directed to a file explorer. "
			+ "Find the location where you would like to save file, and save it as a \"Webpage Complete\" file format.";
	private String question2 = "How to retrieve a meal plan?";
	private String answer2 = "Go to your browser's menu bar. " + "Click on \"File\" and \"Open file\". "
			+ "Once clicked, you will be directed to a file explorer. "
			+ "Locate the file that you saved previously and click \"Open\"";

	/**
	 * The following handle method returns the HTML supporting the FAQ page
	 */
	public Object handle(Request request, Response response) throws Exception {
		return HtmlWriter.gethtmlHead("Frequently Asked Questions") + HtmlWriter.createBodyTitle(pageTitle)

		// inserting question 1 and answer 1 in HTML
				+ "<strong>" + HtmlWriter.createAParagraph(question1) + "</strong>"
				+ HtmlWriter.createAParagraph(answer1)

				// inserting question 2 and answer 2 in HTML
				+ "<strong>" + HtmlWriter.createAParagraph(question2) + "</strong>"
				+ HtmlWriter.createAParagraph(answer2)

				+ HtmlWriter.getFooter() + HtmlWriter.closeTag();

	}
}
