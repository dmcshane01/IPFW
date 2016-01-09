
public class Payroll {

	private final int SIZE = 7;
	
	//arrays used in class
	private String[] employeeID;
	int[] hours = new int[SIZE];
	double[] payRates = new double[SIZE];
	double[] wages = new double[SIZE];
	
	
	//default constructor creates an array with employee id's
	public Payroll()
	{

		employeeID = new String[]{"ADL7", "ARD9", "AET8", "AFG2", "AFK7", "AVN8", "AMR8"};
	}
	
	//getter methods
	public String[] getEmployeeID()
	{
		return employeeID;
	}
	
	public int[] getHours()
	{
		return hours;
	}
	
	public double[] getPay()
	{
		return payRates;
	}
	
	public double[] getWages()
	{
		return wages;
	}
	
	//setter methods
	public void setHours(int[] hrsIn)
	{
		hours = ArrayOps.copyIntArray(hrsIn);
	
	}
	
	public void setRates(double[] inRates)
	{
		payRates = ArrayOps.copyDoubleArray(inRates);
	}
	

	//sets wages by computing each employees pay after user has input necessary info
	public void setWages()
	{
		double pay = 0;
		
		for(int i = 0; i < wages.length; i++)
		{
			pay = hours[i] * payRates[i];
			wages[i] = pay;
		}
	}
	
	//This is the *toString* function. It outputs information about employees
	//I can't name it toString because eclipse is trying to tell me how to name
	//my methods and says that it has to return a string.
	public void summaryOutput() 
	{
		System.out.println("PAYROLL DATA");
		System.out.println("------------");
		
		for(int i = 0; i < SIZE; i++)
		{
			System.out.println("Employee Id: " + employeeID[i]);
			System.out.println("Gross Pay:   " +  wages[i]);
		}
		
		System.out.println("Sum Hours: " + ArrayOps.sumArray(hours));
		System.out.println("Sum Pay: " + ArrayOps.sumArray(wages));
	}
	
	
}
