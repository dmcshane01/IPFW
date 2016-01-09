/*
 * Created 10-07-15 by Daniel DelyMcShane
 * displays use of while loop and counters, prints out mass, etc
 */
import java.util.Scanner;
import java.text.DecimalFormat;


public class MassHandler {

	public static void main(String[] args) {
	 
		//variables used in program
		double		mass = 0;
		double		weight = 0;
		String		obj = "";
		int 		counter = 0;
		int			countValid = 0;
		
		while(mass != -5)
		{
			
			DecimalFormat formatter = new DecimalFormat("#0.0"); //creates a decimalformat object that formats to one decimal place
			Scanner input = new Scanner(System.in);
			System.out.println("What is the objects name?");
			
			obj = input.nextLine();
		
			System.out.println("What is the mass of " + obj + "?");
		
			mass = input.nextDouble();
			input.nextLine();
			
			if(mass == -5)
				break;

		
			weight = mass * 9.8;
			
		
			if(weight > 1000)
			{
				System.out.println(obj + " is too heavy!");
				counter++;
			}
			else if (weight < 10)
			{
				System.out.println(obj + " is too light!");
				counter++;
			}
			else
			{
				countValid++;
				counter++;
				System.out.println(obj + " weighs " + formatter.format(weight) );
			}//end of if/else statement
		
		}//end of while loop
	
	System.out.println("Total input count was: " + counter + "\nTotal valid input was: " + countValid);

	}
}
