import java.util.ArrayList;
import java.util.Scanner;
public class EmployeeDriver {

	public static void main(String[] args) {

		boolean quit = false;
		int choice;
		int empType;
		Scanner in = new Scanner(System.in);
		String input;
		
		ArrayList<Employee> emList;
		emList = new ArrayList<Employee>(100); //Kept getting error if I didn't specify size??? I thought arrayList didn't need to have a declaration size
		
		while(!quit)
		{
			System.out.println("Please select an option\n1) Add an Employee\n"
			+ "2) List Employees\n3) List Benefit Status\n 4) Quit");
			choice = in.nextInt();
			
			switch(choice)
			{
				case 1: //add workers
					System.out.println("Enter 1 for Hourly, 2 for Salary, 3 for contract");
					empType = in.nextInt();
					if(empType == 1) //hourly workers
					{
						System.out.println("Enter first name: ");
						String fName = in.next();
						System.out.println("Enter last name: ");
						String lName = in.next();
						System.out.println("Enter company: ");
						String company = in.next();
						System.out.println("Enter hours worked: ");
						int hours = in.nextInt();
						System.out.println("Enter wage: ");
						double pay = in.nextDouble();
						
						emList.add(new HourlyEmployee(company, fName, lName, hours, pay));
					}
					if(empType == 2) //salary workers
					{
						System.out.println("Enter first name: ");
						String fName = in.next();
						System.out.println("Enter last name: ");
						String lName = in.next();
						System.out.println("Enter company: ");
						String company = in.next();
						System.out.println("Enter salary: ");
						double salary = in.nextDouble();
						
						emList.add(new SalaryEmployee(company, fName, lName, salary));
					}
					if(empType == 3) //contract workers
					{
						System.out.println("Enter first name: ");
						String fName = in.next();
						System.out.println("Enter last name: ");
						String lName = in.next();
						System.out.println("Enter company: ");
						String company = in.next();
						System.out.println("Enter hours worked: ");
						int hours = in.nextInt();
						System.out.println("Enter wage: ");
						double pay = in.nextDouble();
						System.out.println("Enter contract fee");
						double fee = in.nextDouble();
						
						emList.add(new ContractEmployee(company, fName, lName, hours, pay, fee));
					}
					break;
					
				case 2: //print employee info
					for(int i = 0; i < emList.size(); i++)
					{
						System.out.println(emList.get(i).toString());
					}
					break;
				case 3: //print employee benefits
					for(int i = 0; i < emList.size(); i++)
					{
						System.out.println(emList.get(i).determineBenefits());
					}
					break;
				case 4: //exit program
					System.exit(0);
			}
		}
		
	}

}
