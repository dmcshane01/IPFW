/*
 * Daniel DelyMcshane
 * CS160
 * Project 3
 * 
 * The Currency Class stores a currency code and conversion rate and is used by the bank class
 */
public class Currency {
	
	private String curCode;
	private double exRate;

	public Currency(String code, double rate) 
	{
		curCode = code;
		exRate = rate;
	}
	
	
	public void setCode(String code)
	{
		curCode = code;
	}
	
	public void setRate(double rate)
	{
		exRate = rate;
	}
	
	public String getCode()
	{
		return curCode;
	}
	
	public double getRate()
	
	{
		return exRate;
	}
	
	
}
