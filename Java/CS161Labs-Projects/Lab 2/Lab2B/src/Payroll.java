/*
 * Daniel DelyMcShane
 * Lab2 part b
 * CS161
 * 1/25/2016
 * 
 * Payroll class utilizes parallel arrays to keep track of employees payroll information
 */

import java.util.Random;

public class Payroll {
	
	private final int SIZE = 5; 
	

	private int[] employeeId;
	private int[] hours;
	private double[] payRate; 
	
	public Payroll()
	{
		//initialize parallel arrays
		employeeId = new int[SIZE];
		hours = new int[SIZE];
		payRate = new double[SIZE];
	}
	
	public int getEmployeeIdAt(int index)
	{
		return employeeId[index];
	}
	
	public double getPayRateAt(int index)
	{
		return payRate[index];
	}

	public int getHoursAt(int index)
	{
		return hours[index];
	}
	
	public double getGrossPay(int index)
	{
		return hours[index] * payRate[index];
	}
	
	public void setEmployeeIdAt(int index, int id)
	{
		employeeId[index] = id;
	}
	
	public void setPayRateAt(int index, double pay)
	{
		payRate[index] = pay;
	}
	
	public void setHoursAt(int index, int hrs)
	{
		hours[index] = hrs;
	}
	
	public void setHoursAt(int index) //overloaded setHours method to 
	{
		//these are used to generate the range of random numbers
		//just using variables for readability
		final int MAX = 50; //max hours employee can work
		final int MIN = 15; //min hours employee can work
		
		int randNum;
		
		
		Random rand = new Random();
		
		randNum = rand.nextInt((MAX - MIN) + 1) + MIN; //MAX - MIN gives us 35, whih would make the range of random numbers (0,34), so we add 1 to make it range(0,35).
													  // then add 15(MIN) outisde of method to make the range(15,50)
		hours[index] = randNum;
	}
}
