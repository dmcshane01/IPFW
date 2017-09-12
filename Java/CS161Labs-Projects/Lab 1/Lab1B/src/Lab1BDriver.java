/*
 * Daniel DelyMcshane
 * 1/11/2016
 * CS161
 * Lab 1
 * Lab1BDriver Class
 * Driver class for Part B of Lab 1. Contains main and reads pattern from file and outputs pattern to console using Rectangle classs
 */
import java.util.Scanner;
import java.text.*;
import java.io.*;

public class Lab1BDriver {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		final int SIZE = 30; //size of array required by assignment
		int count = 0; //keeps track of Student array index in while loop

		Student[] studentList = new Student[SIZE]; //creates array to store Student objects
	
		File studentFile = new File("Lab1B.in");//reads in data file
		Scanner studentScan = new Scanner(studentFile);
		DecimalFormat df = new DecimalFormat("##.0");//for formatting grade average
		
		while(studentScan.hasNext()) //This loop reads student data from input file and creates objects in the studentList array
		{
			studentList[count] = new Student();
			studentList[count].setName(studentScan.next()); //gets student name from file
			int[] temp = new int[studentList[count].getScores().length]; //creates a temp array to read in grades and store temporarily
																		//wecopy the length of the array in student object and use it to make size of temp, just to be sure we dont get outofbounds error
			
			
			
			
			for(int i = 0; i < temp.length; i++)
			{
				temp[i] = studentScan.nextInt(); //copes score from txt into temp array
			}
			
			studentList[count].setScores(temp);//sets score array of student object to the temp array
			

			studentList[count].calculateAverage(); //calculate grade and average while this student object is on our incrementer(count)
			studentList[count].calculateGrade();
			count++;
			
		}//end of while loop
		
		PrintWriter outFile = new PrintWriter("Lab1B.out");
		outFile.println("Student\tTest1\tTest2\tTest3\tTest4\tTest5\tAve\tGrade");//prints out header tto file
		
		for(int i = 0; i < count; i++)
		{
			String tempString = "";			
			int[] temp = studentList[i].getScores();//grabs scores fromt student object to use temporarily
			tempString = studentList[i].getName() + "\t"; //add name to our output string
			
			for(int j = 0; j < temp.length; j++)
			{
				tempString += (temp[j] + "\t\t"); //prints score then tab for each test to output file	
			}
			
			tempString += (df.format(studentList[i].getAverage()) + "\t"); //formats average and appends to string
			tempString += studentList[i].getGrade();// appends grade to output string
			outFile.println(tempString); //print string to output file
			
		} //end of outer for loop
		
		outFile.close();
		studentScan.close();
		
	} //end of main
} //end of class
