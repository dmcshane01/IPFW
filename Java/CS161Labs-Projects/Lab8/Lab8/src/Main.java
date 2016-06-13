/*
 * Daniel DelyMcshane
 * Lab 7
 * CS 161
 * This program has a couple functions that utilize recursion
 */
public class Main {

	public static void main(String[] args) {


		System.out.println(sumDownBy3(2));
		System.out.println(harmonicSum(3));
	}

	
	static int sumDownBy3(int n)
	{
		if(n <= 0) //if n is 0 or a negative number return 0
			return 0;
		else if(n == 1)
			return 1;
		else
			return n + sumDownBy3(n-3); //return n and call the function with n-3
	}


	static double harmonicSum(int n)
	{
		if(n == 1)
			return 1.0;
		else
			return (1.0 / n) + harmonicSum(n-1);
		
	}
	
	static double geometricSum(int n)
	{
		if(n == 1)
			return 1.0;
		else
			return (1.0 / Math.pow(2, n)) + harmonicSum(n-1);
	}
	
	static double loanLength(double loan, double rate, double pay)
	{
		if(loan <= 0)
			return 0;
		
		double monthInterest = rate / (12 * 100); //gets interest accrued in a month
		loan = loan * (1 + monthInterest); //adds interest to loan amount
		return 1 + loanLength(loan - pay, rate, pay);
	}
	
	static int additiveMult(int i, int j)
	{
		if(i == 0)
			return j;
		else
			return additiveMult(i-1, j+1); // I have no idea if this is correct, I could make no sense of the instructions
	}
}