/*
 * Daniel DelyMcShane
 * CS160
 * 11-14-2015
 * Create two classes circle and triangle and output information about them
 */

import java.util.Random;
import java.util.Scanner;

public class shapes {

	public static void main(String[] args)
	{
		//variables used in main
		String choice;
		double mainRadius;
		double mainBase;
		double mainHeight;
		
		//Objects used in main
		Triangle mainTriangle;
		Circle mainCircle;
		Random rand = new Random();
		Scanner inp = new Scanner(System.in);
		
		
		System.out.println("Would you like tm make a circle or triange?");
		choice = inp.nextLine();
		
		if(choice.equalsIgnoreCase("circle")) // if user selects circle
		{ 
			//get radius from user
			
			System.out.println("Please enter the radius for your circle");
			mainRadius = inp.nextDouble();
			
			
			if(mainRadius < 0) //if user enters invalid radius
			{
				mainCircle = new Circle();
				System.out.println("Area: " + mainCircle.getArea());
				System.out.println("Diameter: " + mainCircle.getDiameter());
				System.out.println("Circumfrerence: " + mainCircle.getCircumference());
				
				int ranInt = rand.nextInt(20) + 1;
				
				System.out.println("New radius is " + ranInt);
				mainCircle.setRadius(ranInt);
				System.out.println("Area: " + mainCircle.getArea());
				System.out.println("Diameter: " + mainCircle.getDiameter());
				System.out.println("Circumfrerence: " + mainCircle.getCircumference());
			}
			else //if radius input is valid
			{
				mainCircle = new Circle(mainRadius);
				System.out.println("Area: " + mainCircle.getArea());
				System.out.println("Diameter: " + mainCircle.getDiameter());
				System.out.println("Circumfrerence: " + mainCircle.getCircumference());
			}
			
		}
		else if(choice.equalsIgnoreCase("triangle"))
		{
			//get base and height from user
			System.out.println("Please enter the triangle's base");
			mainBase =inp.nextDouble();
			System.out.println("Please enter the triangle's height");
			mainHeight = inp.nextDouble();
			
			//if user had invalid input for base or height
			if(mainHeight == 0 || mainBase == 0)
			{
				mainTriangle = new Triangle();
				System.out.println("Triangle's area is: " + mainTriangle.getArea());
				mainBase = rand.nextInt(20) + 1;
				mainHeight = rand.nextInt(20) + 1;
				System.out.println("New base is: " + mainBase + "\nNew height is: " + mainHeight);
				System.out.println("Triangle's area is: " + mainTriangle.getArea());
			}
			else
			{
				mainTriangle = new Triangle(mainBase, mainHeight);
				System.out.println("Triangle's area is: " + mainTriangle.getArea());
			}
			
			
		}
		else
			System.out.println("Invalid input, must be triangle or circle");
		
		inp.close();

	}

	
	
}


