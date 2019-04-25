package com.sparkmealplanner.spark_meal_planner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The following class represents an object that reads a file and includes
 * properties related to a file and methods
 *
 */
public class FileReader {

	// instance variables
	private String fileName;
	private ArrayList<String> lines;
	private Scanner fileScanner;

	/**
	 * The constructor creates the file object based on the file name and reads the
	 * file
	 * 
	 * @param fileName name of the file to be read
	 */
	public FileReader(String fileName) {
		this.fileName = fileName;
		lines = new ArrayList<String>();
		readfile();
	}

	/**
	 * returns the file name
	 * 
	 * @return file name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * returns the lines contained in a file
	 * 
	 * @return lines
	 */
	public ArrayList<String> getLines() {
		return lines;
	}

	/**
	 * returns the file scanner object of a file
	 * 
	 * @return scanner
	 * 
	 */
	public Scanner getFileScanner() {
		return fileScanner;
	}

	/**
	 * This method create and read the entire file. It will store the contents in
	 * the lines ArrayList.
	 *
	 */
	private void readfile() {
		try {
			File inputfile = new File(fileName);
			Scanner in = new Scanner(inputfile);
			this.fileScanner = in;

			while (in.hasNextLine()) {
				String line = in.nextLine();
				lines.add(line);
			}
			in.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}

	/**
	 * This is a helper method checks if the file name contains a period character.
	 * 
	 * @return true or false
	 *
	 */
	private boolean hasPeriod() {
		if (!(fileName.contains("."))) {
			System.out.println("The file does not seem to have a file extension at the end.");
			System.out.println("Please enter the file name with a valid extension.");
			return false;
		}
		return true;
	}

	/**
	 * The following method returns the file extension if it exists (i.e. if the
	 * file has a period in the file name.)
	 * 
	 * @return file extension
	 *
	 */
	public String getFileExtension() {
		String FileExtension = "";

		if (hasPeriod() == true) {

			// splitting and storing the words from the file name
			String fileNameWords[] = fileName.split("\\.");

			// find the last item followed by delim "." which is
			// generally the file extension
			FileExtension = fileNameWords[fileNameWords.length - 1];
		} else {
			FileExtension = "";
		}
		return FileExtension;
	}
}
