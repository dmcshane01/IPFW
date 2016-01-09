/*
 * Daniel DelyMcshane
 * CS160
 * Project 3
 * 
 * The Bank class reads in the bank file currency codes and creates Currency objects
 * Then uses them to do currency conversions
 * Uses Quote class to output information about 
 */


import java.util.Scanner;
import java.io.*;

public class Bank {

	private String bankName;
	private double comRate;
	
	//create pointers to objects
	private Currency curOne;
	private Currency curTwo;
	private Currency curThree;
	
	public Bank(String fileName) throws FileNotFoundException
	{
		//open txt file with bank info
		File bankFile = new File(fileName);
		Scanner scan  = new Scanner(bankFile);
		
		//get the name of the bank and the ocmmission rate
		bankName = scan.nextLine();
		comRate = scan.nextDouble();
		
		//initialize currency objects with data from file
		curOne 	 = new Currency(scan.next(), scan.nextDouble());
		curTwo 	 = new Currency(scan.next(), scan.nextDouble());
		curThree = new Currency(scan.next(), scan.nextDouble());
		
		scan.close();
	}
	
	public boolean supportCurrency(String curName) //bool method returns if the bank supports a currency
	{
		//if one of the three currenciies match it returns true
		if(curOne.getCode().equalsIgnoreCase(curName) || curTwo.getCode().equalsIgnoreCase(curName) || curThree.getCode().equalsIgnoreCase(curName))
		{
			return true;
		}
		else
			return false;
	}
	
	public double getRate(String curName)
	{
		//sets return rate to -1, if there is a matching return rate it will return that currency, else it returns -1
		double retRate = -1;
		
		if(supportCurrency(curName)) //use suppportCurrency method to see if bank supports currency
		{
			//if it does then searches through 3 currencys and returns the rate of corresponding one
			if(curOne.getCode().equalsIgnoreCase(curName))
			{
				retRate = curOne.getRate();
			}
			
			if(curTwo.getCode().equalsIgnoreCase(curName))
			{
				retRate = curTwo.getRate();
			}
			
			if(curThree.getCode().equalsIgnoreCase(curName))
			{
				retRate = curThree.getRate();
			}
			
		}
		
		return retRate;
	}
	
	public Quote quoteBuy(double currAmt, String currCode)
	{

	
		//dollars owed determines how much bank gives user after converting. Multiples initial amount times conversion rate and commission
		double dollarsOwed = currAmt * getRate(currCode) * (1-comRate);
	
		
		if(supportCurrency(currCode))
		{															
			Quote out = new Quote(bankName, "USD", currAmt, currCode, dollarsOwed, comRate, comRate * dollarsOwed);
			return out;
		}
		else
		{
			return null;
		}
	}
	
	public Quote quoteSell(double currAmt, String currCode)
	{
		
		double base = currAmt *  getRate(currCode) * (1- comRate);
		
		
		if(supportCurrency(currCode))
		{
			Quote out = new Quote(bankName, currCode, currAmt, "USD", base, comRate, comRate * base);
			return out;
		}
		else
			return null;
		
	}
	
	
	
	
}
