/*
 * Daniel DelyMcShane
 * Lab2 part b
 * CS161
 * 1/25/2016
 * 
 * PayrollDriver class initializes all fields of Payroll class and then prints Payroll report to console
 */
import java.util.Scanner;

public class PayrollDriver {

	
	public static void main(String[] args) {
		
		final int PAYROLL_SIZE = 5; //Size of Payroll's parallel arrays
		
		Payroll employees = new Payroll();
		Scanner inp = new Scanner(System.in);
				
		for(int i = 0; i < PAYROLL_SIZE ; i++) //loop to set employee ID
		{
			employees.setEmployeeIdAt(i, i + 1001); //set employee id at index 0 to 1001, and increments id and index by one each pass
		}
		
		for(int i = 0; i < PAYROLL_SIZE; i++) //loop to set employee's pay rate
		{
			double payRate = 0;
			System.out.println("Enter the hourly pay rate for the employee number " + employees.getEmployeeIdAt(i) + ": ");
			payRate = inp.nextDouble();
			
			while(payRate < 7.5) //if user enters pay rate below minimum wage
			{
				System.out.println("ERROR: Enter 7.50 or greater for pay rate: ");
				payRate = inp.nextDouble();
			}
			
			employees.setPayRateAt(i, payRate);
			
		}
		
		for(int i = 0; i < PAYROLL_SIZE; i++) //loop to set random hours for each employee
		{
			employees.setHoursAt(i);
		}
		
		System.out.println("\t\t\tPAYROLL DATA\n==============================================================");

		for(int i = 0; i < PAYROLL_SIZE; i++)
		{
			//String stores all info on emploee to print out
			String output = "Employee ID: " + employees.getEmployeeIdAt(i) + "\tHours : " + employees.getHoursAt(i) + "\tRate : " + employees.getPayRateAt(i)
			+ "\tGross Pay : $" + employees.getGrossPay(i);
			
			System.out.println(output);
		}
		
		inp.close(); //close Scanner
		
	} //end of main

} //end of driver class
