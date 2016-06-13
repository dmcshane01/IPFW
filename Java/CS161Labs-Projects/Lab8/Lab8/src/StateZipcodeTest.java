/*
 * Daniel DelyMcShane
 * April 11, 2016
 * CS161
 * 
 * StateZipcodeTest validates user input with exceptions
 */

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StateZipcodeTest {

	//static fields so that we can manipulate them in the methods
	static String sArr[][] = new String[50][2];
	static Scanner in = new Scanner(System.in);
	static DataInputStream dis;
	static int age;


	public static void main(String[] args) throws IOException {
	
		
		//fields that hold user input
		String fileName;
		String state;
		String zip;
		int zipNum;
		
		initSurvey(); //retrieves age
		
		//beging prompting user for file
		System.out.println("Please enter the name of your file or enter quit: ");
		fileName = in.nextLine();

		while(getInputFileName(fileName) == false) //loops until user enters valid file name or quit
		{			
			if(fileName.equals("quit"))
			{
				System.out.println("Your participation has been valuable.\n"
						+ "Thank you for your time.");
				System.exit(0);
			}
			
			System.out.println("Unable to open file, reenter the file name. ");

			fileName = in.nextLine();
		}
		
		readBinaryFile(dis); //read binary file by passing static datainputstream
		
		
		System.out.println("Please enter the 2 letter state abbreviation:");
		state = in.nextLine();
		state = getState(state); //assigns state the value returned from getState method, which checks validity, if invalid returns null
		
		while(state == null) //if state is an invalid abbreviation this will loop until it's valid
		{
			System.out.println("Please enter the 2 letter state abbreviation:");
			state = in.nextLine();
			state = getState(state);
		}
		
		System.out.println("Please enter your zip code: ");
		zip = in.nextLine();
		zipNum = getZip(zip);
		
		while(zipNum == 0) //while zipNum is 0 the zip is invalid and this will loop
		{
			System.out.println("Please enter your zip code: ");
			zip = in.nextLine();
			zipNum = getZip(zip);
			
		}
		
		System.out.println("Your age: " + age + "\nYour State and Zip: "
				+ state.toUpperCase() + " " + zip + "\nYour participation has been valuable.");
		

		
		
	}

	//Begins survey by asking for user age
	public static void initSurvey()
	{

		
		System.out.println("Please enter your age or 'q' to quit: ");
		
		try{ //user enters age
			age = in.nextInt();
		}
		catch(InputMismatchException e) //if int is not entered throw mismatch exception
		{
			System.out.println("You've chosen not to participate. Thank you for your time.");
			System.exit(0); //terminates
		}
	}
	
	
	//returns true/false depending if file exists
	public static boolean getInputFileName(String fileName)
	{
		try{
			fileName = in.nextLine(); //user inputs file name
			dis = new DataInputStream(new FileInputStream(fileName)); //create serialized object with filename, using static dis object
		}
		catch(FileNotFoundException e) //if file is not found method returns false
		{
			return false;
		}
		
		return true;
	}
	
	//reads in info from data input stream
	public static void readBinaryFile(DataInputStream dis) throws IOException
	{
		String temp;
		
		for(int i = 0; i < sArr.length; i++)
		{
			
			temp = dis.readUTF(); 
			sArr[i][0] = temp; //store abbreviation
			temp = dis.readUTF();
			sArr[i][1] = temp; //store state
		}
	}
	
	//getstate takes a string as an argument and validates that it is a state abbreviation
	public static String getState(String state)
	{
			boolean found = false; //determineif state is valid
			try{
				
					for(int i = 0; i < sArr.length; i++) //loop through each row of array
					{
						
						if(sArr[i][0].equalsIgnoreCase(state)) //check first index of each row where state abbreviations are stored
						{
							found = true; //set found flag as true
						}
					}
			
					if(found == false) //if not found throw invalid name exception
					{
						throw new InvalidStateNameException();
					}
					
						return state; //if state is valid return state abbreviation
			}
			catch(InvalidStateNameException e) //prompt user to re enter info by returning null to our loop
			{
					System.out.println(e.getMessage());
					return null;
			}
	}
	
	//getZip checks the validity of zip codes by examining length, and cast zip code from string to int
	public static int getZip(String zip)
	{
		
		int zipNum = Integer.parseInt(zip); //cast zip to int
		
		try
		{
			if(zip.length() != 5) //if the lenth is not 5 digits throws exception
			{
				throw new ZipLengthException();
			}
		}
		catch(ZipLengthException e) //prints error and returns the invalid flag 0
		{
			System.out.println(e.getMessage());
			return 0;
		}
		
		return zipNum; //if zip is valid returns zip in int
	}
}
