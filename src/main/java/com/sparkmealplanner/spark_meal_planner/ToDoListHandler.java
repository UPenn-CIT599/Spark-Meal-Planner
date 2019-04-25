package com.sparkmealplanner.spark_meal_planner;

import java.util.HashMap;
import java.util.Map.Entry;

import spark.Request;
import spark.Response;
import spark.Route;

public class ToDoListHandler implements Route {

	private final String htmlHead = "<html><head><title>To Do List</title></head>";

	// creates a new form on the page
	private final String newTaskForm = "<div><form action = \"/createtodo\" method=\"post\">Add new task: "
			+ "<input type=\"text\" name\"taskname\">"
			+ "<button style=\"margin-left: 10px\" type=\"submit\">Create</button>" + "</form></div>";

	private final int TARGET_NUM_OF_TASK = 5;
	private int taskCompleted;
	private int idCount;
	private HashMap<Integer, String> tasks;

	public ToDoListHandler() {
		taskCompleted = 0;
		idCount = 0;
		tasks = new HashMap<Integer, String>();
	}

	public Object handle(Request request, Response response) throws Exception {
		if ("/taskdone".equals(request.pathInfo())) {
			int taskID = Integer.valueOf(request.queryParams("id"));
			tasks.remove(taskID);
			taskCompleted++;

			if (taskCompleted >= TARGET_NUM_OF_TASK) {
				response.redirect("/reward");
			}
		} else if ("/createtodo".equals(request.pathInfo())) {
			String taskname = request.queryParams("taskname");
			tasks.put(idCount, taskname);
		}
		return htmlHead + "<body><div><h3>To Do List</h3></div>" + taskCounter() + taskList() + newTaskForm
				+ "</body></html>";

		// form for creating tasks
	}

	// create a list of tasks
	public String taskList() {
		StringBuilder sb = new StringBuilder();
		sb.append("<div><ul>");

		for (Entry<Integer, String> task : tasks.entrySet()) {
			sb.append("<li>" + task.getValue() + "<button><a href \"/taskdone?id=" + task.getKey()
					+ "\">Done</a></button></li>");
			System.out.println(task.getValue());
		}

		sb.append("</ul></div>");
		return sb.toString();
	}

	// Task Counter
	public String taskCounter() {
		// TODO Auto-generated method stub
		return "<div><h4> Target Number of Tasks: " + TARGET_NUM_OF_TASK + "</h4><h4> Tasks Completed: " + taskCompleted
				+ "</h4></div>";
	}
}
