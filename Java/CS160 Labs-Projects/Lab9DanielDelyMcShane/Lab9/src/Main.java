/*
 * Daniel DelyMcShane
 * CS160
 * 11/21/2015
 * 
 * Creates a payroll class that calculates
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//objects used in main
		Payroll pay = new Payroll();
		Scanner in 	= new Scanner(System.in);
		
		
		//arrays
		String[] emp 	 = pay.getEmployeeID(); //copies employee id's into an array
		int[]	 hours	 = new int[7]; //stores user input 
		double[] payRate = new double[7];//stores user input 
		
		//variables used, for inputting user data
		int 	hoursIn;
		double  payIn;
		int 	index = 0;//keeps track of each employee's index
	
		//enhanced for loop to loop through each employee ID
		for(String each : emp)
		{
			
			
			//Gets user input for employee hours and pay and stores in array
			System.out.println("Enter the hours worked by Employee " + each +": ");
			hoursIn = in.nextInt();
			hours[index] = hoursIn;
			
			System.out.println("Enter the hourly pay rate for Employee " + each + ": ");
			payIn = in.nextDouble();
			payRate[index] = payIn;
			index++;
		}
		
		//set the Payroll class' fields to the user input, compute the wages, then output the summary report
		pay.setHours(hours);
		pay.setRates(payRate);
		pay.setWages();
		pay.summaryOutput();
		
		in.close();
		
	}

}
