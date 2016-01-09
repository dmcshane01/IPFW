/*
 * Daniel DelyMcShane
 * Lab 10
 * 12/5/15
 * CS160
 * Creates a simple 2d array and a ragged 2d array, and then performs operations on them
 */

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
	//initialize simple 2d array
	double[][]sample2D = {{7,6,11,9,9},{6,9,2,1,6},{1,4,6,1,3}};
	
	//initialize ragged 2d array
	double[][]ragged2D = new double[3][];
	
	//assign values to array
	ragged2D[0] = new double[]{1,5,2};
	ragged2D[1] = new double[]{6,7,1,5,8,1};
	ragged2D[2] = new double[]{2,5,6,2};
	
	Scanner in = new Scanner(System.in);
	
	System.out.println("The total value of the simple 2D array is: " + ArrayOps2D.getTotal(sample2D)
	+ "\nThe total value of the ragged 2D array is: " + ArrayOps2D.getTotal(ragged2D));
	
	System.out.println("The average of the simple 2D array is: " + ArrayOps2D.getAverage(sample2D)
	+ "\nThe average of the ragged 2D array is: " + ArrayOps2D.getAverage(ragged2D) + "\nWhich row would you like to total(must be 0-2)");
	
	int rowChosen = in.nextInt();
	
	System.out.println("Simple array total: " + ArrayOps2D.getRowTotal(sample2D, rowChosen) + "\nRagged Array total: " + ArrayOps2D.getRowTotal(ragged2D, rowChosen)
	+ "\nWhich row would you like to find the highest value in?(0-2)");
	
	rowChosen = in.nextInt();
	
	System.out.println("Simple Array: The highest value in row " + rowChosen + " is located at index " + ArrayOps2D.findHighestValueInRow(sample2D, rowChosen)
			+ "\nRugged Array: The highest value in row " + rowChosen + " is located at index " + ArrayOps2D.findHighestValueInRow(ragged2D, rowChosen));
	
	System.out.println("Simple Array: " + ArrayOps2D.findHighestValue(sample2D)
			+ "\nRagged Array:  " + ArrayOps2D.findHighestValue(ragged2D)
			+ "\nPlease enter a value that you would like to search for: ");
	
	double valIn = in.nextDouble();
	
	System.out.println("Simple array: " +ArrayOps2D.sequentialSearch2D(sample2D, valIn)
			+ "\nRagged array: " + ArrayOps2D.sequentialSearch2D(ragged2D, valIn));
	
	in.close();
	
	
	
	
	
	
	
	
	
	
	
	
}
}


