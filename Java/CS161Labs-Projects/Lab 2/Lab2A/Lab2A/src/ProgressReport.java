/*
 * Daniel DelyMcShane
 * 1/25/2016
 * CS161
 * 
 * ProgressReport class reads in student information from a file, then creates a report from the info. Also implements sequential sort and binary search
 */

import java.util.Scanner;
import java.io.*;
public class ProgressReport {
	
	private Student[][] sectionArray = new Student[2][];
	
	public void readInputFile() throws FileNotFoundException
	{

		int count = 0;
		File studentFile = new File("Lab2A.in");
		Scanner fileScan = new Scanner(studentFile); //create scanner for file input
	
		while(fileScan.hasNextInt())
		{
			
			int numOfStudents = fileScan.nextInt();
			sectionArray[count] = new Student[numOfStudents];
			
			
			for(int i = 0; i < numOfStudents; i++)
			{
				sectionArray[count][i] = new Student(); // have to initialize here or else we get NullPointer
				String name = fileScan.next();
				sectionArray[count][i].setName(name);
			
				int arrayLength = 5; //sets array length to length of scores array in stud obj
				int[] temp = new int[5];

				for(int j = 0; j < arrayLength ; j++)
				{
					if(fileScan.hasNextInt())
					{
						temp[j] = fileScan.nextInt();
					}
				}
						
				sectionArray[count][i].setScores(temp);
				
			}
			
			count++;
		} //end of while loop	
		
		fileScan.close();
	}
	
	public void sortByName()
	{
		String compOuter;
		String compInner;
		char minOut;
		char minIn;
		int minIndex;
		Student temp;

		for(int i = 0; i < sectionArray.length; i++) //this for loop loops for each row of the array, sorting each row
		{

			for(int j = 0; j < sectionArray[i].length; j++) //outerloop of selection sort
			{
				
				compOuter = sectionArray[i][j].getName().toUpperCase(); // sets string to upper case to avoid comparison errors due to capitalization
				minOut = compOuter.charAt(0); //always select first character of string
				minIndex = j;
				
				for(int k = j + 1; k < sectionArray[i].length; k++)
				{

					compInner = sectionArray[i][k].getName().toUpperCase(); //selecs the Student name field to be compared in inner string, and sets it to uppercase
					minIn = compInner.charAt(0); //selects first letter for comparison

					
					if(minIn < minOut)
					{
						minIndex = k;
					}
					
					temp = sectionArray[i][minIndex];
					sectionArray[i][minIndex] = sectionArray[i][j]; 
					sectionArray[i][j] = temp;
				}
			}
		}
		
	}

	public void generateReport() throws FileNotFoundException
	{
		
		
		System.out.println("Pregress Report\n");
		
		for(int i = 0; i < sectionArray.length; i++)
		{
			
			System.out.println("Section " + (i + 1));
			System.out.println(i);
			for(int j = 0; j < sectionArray[i].length; j++)
			{
				
				sectionArray[i][j].calculateAverage();
				sectionArray[i][j].calculateGrade();
				System.out.println(sectionArray[i][j].getName() + "\t" + sectionArray[i][j].getAverage() + " " + sectionArray[i][j].getGrade());
			}
			
			System.out.println();
		}
		
		
	}
	
	Student binarySearch(int section, String name)
	{
		name.toUpperCase();
		Student temp = null;
		int first = 0;
		int last = sectionArray[section].length - 1;
		String nameComp;
		
		char compChar;
		char nameChar = name.charAt(0);
		
		int middle = (first + last) / 2;
		
		while(first <= last)
		{
			nameComp = sectionArray[section][middle].getName().toUpperCase();
			compChar = nameComp.charAt(0);
			
			if(compChar < nameChar)
			{
				first = middle + 1;
			}
			else if(compChar == nameChar)
			{
				if(name.equalsIgnoreCase(nameComp))
				{
					temp = sectionArray[section][middle];
					break;
				}
				
				first = middle + 1;
			}
			else
				last = middle - 1;
			
			middle = (first + last) / 2;
		}
		
		return temp;
	}
}
