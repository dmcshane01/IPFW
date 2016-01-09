/*
 * Created 10-21-15 by Daniel DelyMcShane
 * Outputs text pattern to prompt and external file
 */

import java.util.Scanner;
import java.io.*;
public class PatternMaker {

	public static void main(String[] args) throws FileNotFoundException {

		//variables used to store pattern type and size
		String 	pattern;
		int 	numLines;
		
		//object declarations for scanner input and file output
		Scanner inp = new Scanner(System.in);
		PrintWriter patFile = new PrintWriter("Pattern.txt");
		
		
		System.out.println("Would you like a square or rectangle pattern");
		pattern = inp.nextLine();
		pattern.toLowerCase(); //change to lower case so we can verify it easier
		System.out.println("How many lines would you like?");
		numLines = inp.nextInt();

		//verifies user input
		if(pattern.equals("square") == false && pattern.equals("rectangle") == false) // if both equals functions return false then terminate program
		{
			System.out.println("buzz off");
			System.exit(0);
		}
		
		//This statement prints out the pattern depending on user input
		if(pattern.equals("rectangle"))
		{
			for(int i = 0; i < numLines; i++) //for loop rectangle prints 3 wide times the user input
			
			{
				System.out.println("###");
				patFile.println("###");
			}	
		}
		else
		{
			for(int i = 0; i < numLines; i++) //first for loop prints output of the nested loop 
			{
				for(int j = 0; j < numLines; j++) //nested for loop that prints a single character for each time it loops
				{								  //each loop represent a row of the square
					System.out.print("$");
					patFile.print("$");
				}
				System.out.println();//create newline after each row of square has been printed
				patFile.println();//newline for output file
			}
			
		}
		
		patFile.close();//close printwriter and scanner
		inp.close();
	}

}
