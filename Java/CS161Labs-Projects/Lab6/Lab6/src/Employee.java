import java.text.DecimalFormat;

/*
 * Daniel DelyMcShane
 * CS161
 * Lab 6
 * 
 * Employee is the base abstract class for all other employee subclasses. It houses some abstract methods to be overriden and basic employee info
 */

public abstract class Employee {

	DecimalFormat df = new DecimalFormat("#.00");
	protected String company;
	protected String fName;
	protected String lName;
	
	public Employee(String company, String fName, String lName)
	{
		this.company = company;
		this.fName = fName;
		this.lName = lName;
	}
	
	public String toString()
	{
		String msg;
		msg = fName + " " + lName + " from " + company + ".";
		return msg;
	}
	
	public abstract double getPay();
	
	public abstract String determineBenefits();
	
	
}
