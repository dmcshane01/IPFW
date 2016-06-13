/*
 * Daniel DelyMcShane
 * CS161
 * Lab 6
 * Salary Employee is used to handle employees on salary and uses the Employee superclass
 * 
 **/
public class SalaryEmployee extends Employee{

	double salary;
	
	public SalaryEmployee(String company, String fName, String lName, double salary)
	{
		super(company, fName, lName);
		this.salary = salary;
		
	}

	@Override
	public double getPay() {
		return salary;
	}

	@Override
	public String determineBenefits() {
		return fName + " " + lName + ": This worker gets benefits!";
	}
	
	public String toString()
	{
		String msg;
		msg = this.fName + " " + lName + " from " + company + ". This worker's salary is $"
				+ df.format(getPay()) + ".";
		
		return msg;
	}
}
