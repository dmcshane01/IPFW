/*
 * Daniel DelyMcShane
 * CS161
 * Lab 6
 * Contract Employee is used to handle employees on contract and uses the Employee superclass
 * 
 **/
public class ContractEmployee extends HourlyEmployee{

	double fee;
	
	public ContractEmployee(String company, String fName, String lName, int hours, double pay, double fee)
	{
		super(company, fName, lName, hours, pay);
		this.fee = fee;
		getPay();
	}
	
	@Override
	public String determineBenefits() {
		return "Contract workers get no benefits";
	}
	
	public double getPay()
	{
		return (hours * pay) + fee;
	}
}
