package com.sparkmealplanner.spark_meal_planner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The following class represents a file writer and its properties and methods
 *
 */
public class FileWriter {

	String fileName;
	ArrayList<String> linesToWrite;
	PrintWriter printWriter;
	File fileToWriteTo;

	/**
	 * The following constructor creates a file and printwriter object
	 * 
	 * @param fileName to write to
	 *
	 */
	public FileWriter(String fileName) {
		File fileToWriteTo = new File(fileName);
		this.fileToWriteTo = fileToWriteTo;
		try {
			if (fileToWriteTo.exists()) {
				System.out.println("Warning! The file " + fileName + " exists and will be overwriten." + "\n");
			}
			fileToWriteTo.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			PrintWriter printWriter = new PrintWriter(fileToWriteTo);
			this.printWriter = printWriter;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * returns the file to write to
	 * 
	 * @return file to write to
	 *
	 */
	public File getFileToWriteTo() {
		return fileToWriteTo;
	}

	/**
	 * writes to a file based on the line given to write
	 * 
	 * @param linesToWrite lines to write to the file
	 *
	 */
	public void writeToFile(String linesToWrite) {
		printWriter.print(linesToWrite);
		printWriter.flush();
		printWriter.print("\r\n");
		printWriter.flush();
	}
}
