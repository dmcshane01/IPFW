/*
 * Daniel DelyMcShane
 * CS161
 * Lab 6
 * Hourly Employee is used to handle employees on wage and uses the Employee superclass
 * 
 **/
public class HourlyEmployee extends Employee {
	
	protected double pay;
	protected int hours;
	boolean benefits;

	public HourlyEmployee(String company, String fName, String lName, int hours, double pay)
	{
		super(company, fName, lName);
		this.pay = pay;
		this.hours = hours;
		
	}

	@Override
	public double getPay() {
		
		if(hours >= 40)
		{
			pay = (40 * hours) + ((hours - 40) * 3);
		}
		else
			pay = pay * hours;
		
		return pay;
	}

	@Override
	public String determineBenefits() {

		if(hours >= 40)
		{
			return fName + " " + lName + ": This worker gets benefits!";
		}
		else
			return fName + " " + lName + ": No benefits";
	}
	
	public String toString()
	{
		String msg;
		msg = this.fName + " " + lName + " from " + company + ". This worker's pay this week was $"
		+ df.format(getPay()) + ".";
		return msg;
	}
}
