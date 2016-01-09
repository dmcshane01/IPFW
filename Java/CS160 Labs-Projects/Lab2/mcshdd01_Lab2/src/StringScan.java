/*
 * Created 09-09-15 by Daniel DelyMcShane
 * Program does various functions to demonstrate use of Scanner and String class methods
 */


import java.util.Scanner;

public class StringScan {

	public static void main(String[] args) {
		
		
		Scanner keyboard = new Scanner(System.in); //creates new object Scanner
		
		System.out.println("What is your name?");
		
		String name = keyboard.nextLine(); //Scanner class method nextLine retrieves Strings
		
		System.out.println("What is your favorite number?");

		int fav = keyboard.nextInt(); // Scanner method nextInt retrieves integer
		
		keyboard.close(); //gotta close your scanners.
		
		System.out.println("Your name is " + name.length() + " characters long(including spaces)");
		
		System.out.println("First character in name is " + name.charAt(0) +
				"\nLast character in name is " + name.charAt(name.length() - 1)); // prints first index with zero, and 
																				//prints last  by finding length of string and subtracting 1
		
		System.out.println("The sixth character in your name is " + name.charAt(5));
		
		System.out.println("This is how you make your name cooler -> " + name.toUpperCase()); // String method prints String in upper case
		
		int equation = (name.length() + 2) * fav;
		
		System.out.println("Output of magic equation is: " + equation);
		

	}

}
