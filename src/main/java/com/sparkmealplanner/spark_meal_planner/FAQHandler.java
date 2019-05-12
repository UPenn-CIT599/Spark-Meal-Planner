package com.sparkmealplanner.spark_meal_planner;

import java.util.ArrayList;

import spark.Request;
import spark.Response;
import spark.Route;

/**
 * This class handles the FAQ (Frequently Asked Questions) page of this app
 *
 */
public class FAQHandler implements Route {

	private String pageTitle = "Frequently Asked Questions";
	private ArrayList<String> questionsAndAnswers;

	// setting questions and answers below in variables
	private String question1 = "How to can I create a meal plan?";

	private String answer1 = "When you start the application, click on "
			+ "\"Create A Meal Plan Now\" button or simply go to \"Search Recipes\" in the navigation bar.";

	private String question2 = "How to can I search a recipe?";
	private String answer2 = "Simply enter the recipe that you would like to search in the search box on "
			+ "the \"Search Recipes\" tab and click on \"Search\" button";

	private String question3 = "How to can I add a recipe to the calendar?";
	private String answer3 = "Click on \"Add to Calendar\" button whenever the option is available and "
			+ "you will be taken to the calendar view where you can select the day and the meal to add the recipe to.";

	private String question4 = "How to can I access the grocery list?";
	private String answer4 = "You can access the grocery list at any time by clicking on the Grocery List tab in the "
			+ "navigation bar. The grocery list will only show the ingredients for those recipes that have been added to "
			+ "the calendar.";

	private String question5 = "How to can I view the full recipe?";
	private String answer5 = "You can access the full recipe by clicking on the recipe name in the calendar view "
			+ "or in the searched listing view. If a recipe was added via search functionality of the app, you can find "
			+ "the original website by clicking on the \"Visit original recipe site\" link. If the recipe was manually added, the calendar view will "
			+ "directly take you to the original website as entered by the user.";

	private String question6 = "How can I save a meal plan and grocery list and retrieve them?";
	private String answer6 = "There is a \"Print to PDF\" button on the grocery list and calendar pages. Once clicked, "
			+ "you can save your meal planner calendar and grocery list in a PDF format on your computer, which can be "
			+ "accessed at any time. Alternatively, you can always save a webpage from your browser as a local file on your "
			+ "computer and access it later at any point of time.";

	/**
	 * The following handle method returns the HTML supporting the FAQ page
	 */
	public Object handle(Request request, Response response) throws Exception {

		questionsAndAnswers = new ArrayList<String>();

		// adding all the questions and answers to the arrayList
		questionsAndAnswers.add(question1);
		questionsAndAnswers.add(answer1);
		questionsAndAnswers.add(question2);
		questionsAndAnswers.add(answer2);
		questionsAndAnswers.add(question3);
		questionsAndAnswers.add(answer3);
		questionsAndAnswers.add(question4);
		questionsAndAnswers.add(answer4);
		questionsAndAnswers.add(question5);
		questionsAndAnswers.add(answer5);
		questionsAndAnswers.add(question6);
		questionsAndAnswers.add(answer6);

		// initialize the string builder object
		StringBuilder sb = new StringBuilder();

		// adding the heading
		sb.append(HtmlWriter.gethtmlHead("Frequently Asked Questions"));

		// adding the body
		sb.append(HtmlWriter.createBodyTitle(pageTitle));

		// adding different HTML formatting for questions and answers
		for (int i = 0; i < questionsAndAnswers.size(); i++) {
			if (i % 2 == 0) {
				sb.append("<strong>" + HtmlWriter.createAParagraph(questionsAndAnswers.get(i)) + "</strong>");
			} else {
				sb.append(HtmlWriter.createAParagraph(questionsAndAnswers.get(i)));
			}
		}

		// adding the footer and the closing tab
		sb.append(HtmlWriter.getFooter() + HtmlWriter.closeTag());

		return sb.toString();
	}
}
