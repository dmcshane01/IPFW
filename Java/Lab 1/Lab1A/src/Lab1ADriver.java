/*
 * Daniel DelyMcshane
 * 1/11/2016
 * CS161
 * Lab 1
 * Lab1ADriver Class
 * Driver class for Part A of Lab 1. Contains main and reads pattern from file and outputs pattern to console using Rectangle classs
 */

import java.io.*;
import java.util.Scanner;

public class Lab1ADriver {

	public static void main(String[] args) throws FileNotFoundException {
		
		int numOfRect;
		int rows;
		int cols;
		
		String fill;
		String output;
		
		File rectFile = new File("rectangleData.txt"); //reads in file containing rectangle info
		Scanner fileScan = new Scanner(rectFile);// Create scanner to read from file
		
		numOfRect = fileScan.nextInt(); //First int in file is the number of rectangle objects we need to create(Times to run for loop)
		
		for(int i = 0; i < numOfRect; i++)
		{
			rows = fileScan.nextInt(); //read row number
			cols = fileScan.nextInt(); //read column number
			fill = fileScan.next();   //Use next() to read string to decide if pattern should be filled or not
									  //using next() as opposd to nextLine() to avoid at putting a /s at beginning of string
			System.out.println(fill);
			
			
			Rectangle out = new Rectangle(rows, cols);
			
			if(fill.equals("filled")) //default is set to unfilled, so changes to filled if specified
			{
				out.setFilled(true);
			}
			
			output = out.toString();
			System.out.println(output);
		} //end of for loop
	
		fileScan.close();
		
	} //end of main

} //end of class
