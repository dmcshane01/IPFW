import java.text.DecimalFormat;


/*
 * Created 09-02-15 by Daniel DelyMcShane
 *  This class will calculate the acreage of a plot of land
 */
public class LandCalculation {

	public static void main(String[] args) 
	{
		
		int area = 534521;
		final double CONVERSION = 43560;
		double acres = area / CONVERSION;

		
		System.out.println("The area of our land in square feet is: " + area + " square feet");
		System.out.println("The area of the land in acres is : " + acres);
		
		//cannot be resolved until you import the class
		DecimalFormat df = new DecimalFormat("##.###");
		System.out.println("Formatted acres to the 3rd digit: " + df.format(acres));
		DecimalFormat dftwo = new DecimalFormat("##.#####");
		System.out.println("Formatted acres to the 5th digit: " + dftwo.format(acres));
		

	}

}
