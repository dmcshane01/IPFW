/*
 * Daniel DelyMcshane
 * CS160
 * Project 3
 * 
 * The main class uses the Bank, Quote, and Currency classes to convert currencies for users
 */

import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class CurrencyExchange {

	public static void main(String[] args) throws FileNotFoundException {

		String buyOrSell;
		String userCurr;
		String outMessage;
		
		Bank a = new Bank("bank1.txt");
		Bank b = new Bank("bank2.txt");
		Quote output = null;
		Scanner bors = new Scanner(System.in);
		
		
		int cont = 0;
		int amount;
		
		while(cont == JOptionPane.YES_OPTION)//at the end of each loop
		{
			
			bors = new Scanner(System.in); //reinitialize scanner each loop because if it doesn't then there is already data in the bugger
										  //and it skips the first Nextline method call
			System.out.println("Would you like to buy or sell?");
			buyOrSell = bors.nextLine();

		
			if(buyOrSell.equalsIgnoreCase("buy") || buyOrSell.equalsIgnoreCase("sell")) //validate input
			{
				System.out.println("What kind of currency do you want to trade?");
				userCurr = bors.nextLine();
		
				if(a.supportCurrency(userCurr) && b.supportCurrency(userCurr)) //if both banks support the currency
				{
			
					System.out.println("Two bank support that currency");
					System.out.println("How many " + userCurr + ":");
					amount = bors.nextInt();
					
					if(buyOrSell.equalsIgnoreCase("buy"))
					{
						output = a.quoteBuy(amount, userCurr); //Bank object returns Quote and assigns the new quote object ooutput
						outMessage = output.toString(); //assign the toString method return to string for output
						System.out.println(outMessage);
						output = b.quoteBuy(amount, userCurr);//reeat same steps for  the other bank
						outMessage = output.toString();
						System.out.println(outMessage);
						

						
					}
					else
					{
						output = a.quoteSell(amount, userCurr);
						outMessage = output.toString();
						System.out.println(outMessage);
						output = b.quoteSell(amount, userCurr);
						outMessage = output.toString();
						System.out.println(outMessage);
						

					}
					
					
				}
				else if(a.supportCurrency(userCurr))
				{
					System.out.println("One bank support that currency");
					System.out.println("How many " + userCurr + ":");
					amount = bors.nextInt();
					
					if(buyOrSell.equalsIgnoreCase("buy"))
					{
						output = a.quoteBuy(amount, userCurr);
						outMessage = output.toString();
						System.out.println(outMessage);
						

					}
					else
					{
					output = a.quoteSell(amount, userCurr);
					outMessage = output.toString();
					System.out.println(outMessage);
					

					}
	
				}
				else if(b.supportCurrency(userCurr))
				{
					System.out.println("One bank support that currency");
					System.out.println("How many " + userCurr + ":");
					amount = bors.nextInt();
					
					if(buyOrSell.equalsIgnoreCase("buy"))
					{
						output = b.quoteBuy(amount, userCurr);
						outMessage = output.toString();
						System.out.println(outMessage);
						

					}
					else
					{
						output = b.quoteSell(amount, userCurr);
						outMessage = output.toString();
						System.out.println(outMessage);
						

					}
					

				}
				else
				{
					System.out.println("No bank supports that currency, input a different currency");
					continue;
				}
			
			}
			else
			{
			System.out.println("Not valid input, please enter buy or sell");
			continue;
			
			}
			
			cont = JOptionPane.showConfirmDialog(null, "Would you like to go again?", "Currency Converter", JOptionPane.YES_NO_OPTION);
	}
		bors.close();
}
}
