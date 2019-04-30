package com.sparkmealplanner.spark_meal_planner;

import spark.Request;
import spark.Response;
import spark.Route;

public class FAQHandler implements Route {

	private String PageTitle = "Frequently Asked Questions";
	private String question1 = "How to save a meal plan?";
	private String answer1 = "Go to your browser's menu bar. Click on \"File\" and \"Save as\". Once clicked, you will be directed to a file explorer. Find the location where you would like to save file, and save it as a \"Webpage Complete\" file format.";

	private String question2 = "How to retrieve a meal plan?";
	private String answer2 = "Go to your browser's menu bar. Click on \"File\" and \"Open file\". Once clicked, you will be directed to a file explorer. Locate the file that you saved previously and click \"Open\"";

	public Object handle(Request request, Response response) throws Exception {
		return TagCreator.gethtmlHead("Frequently Asked Questions") 
				+ TagCreator.createBodyTitle(PageTitle)
				
				+"<strong>" + TagCreator.createAParagraph(question1) + "</strong>" 
				+ TagCreator.createAParagraph(answer1)
			
				+"<strong>" + TagCreator.createAParagraph(question2) + "</strong>" 
				+ TagCreator.createAParagraph(answer2)
				
				+TagCreator.getFooter()
				+TagCreator.closeTag();
				
	}
}
