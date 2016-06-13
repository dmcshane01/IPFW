/* 
 * * <your name> * CS16000 Fall 2015 * Project 2:
Exam Statistics * * Description: <summarize the purpose of
the program here> */ 

import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;

public class ExamStatistics {

	public static void main(String[] args) throws FileNotFoundException {
		
		/*
		 * Block of variables used in program
		 */
		final int 	PASSING = 70;
		int			minScore = 9999; //set too 99 so that first loop will automatically be the min
		int    		maxScore = 0; //set to 0 so that on first loop the first int will be the max
		double 		sumScore = 0;
		double 		tempScore = 0;
		double 		averageScore;
		int			count = 0;
		int			countAverage = 0;
		int			countOverSev = 0;
		String		inFileName;
		String 		outputMessage;
	
		
		/*
		 * Objects we will use that can be initiated here
		 */
		PrintWriter outputfile = new PrintWriter("ExamStatFile.txt");	
		Scanner inp = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("###.0"); // for average score
		DecimalFormat percentage = new DecimalFormat("##.0"); //to display percentages
	
		/*
		 * prompt user for filename, then create a File object using the input
		 */
		System.out.println("Please enter your filename: ");
		inFileName = inp.nextLine();
		File file = new File(inFileName);
		
		
		while(!file.exists()) //filename is "scores.txt"
		{
			System.out.println("The file cannot be found");
			System.out.println("Please enter your filename: ");
			inFileName = inp.nextLine(); //scanner takes another name from user
			file = new File(inFileName); // and assigns the file variable to a new object using the new name
			//if the while loop finds the file exists it will exit loop
		}
		
		
		Scanner inputFile = new Scanner(file); //scanner to read from file
		
		while(inputFile.hasNextInt()) //loops if there is another integer to read
		{								// also handles all the score tracking in the loop
			
			tempScore = inputFile.nextInt(); //store integer in a temporary variable
			count++; //our count of scores in file
			
			if(tempScore > maxScore) // checks to see if current int is the max score
			{
				maxScore = (int) tempScore; //if it is assign maxScore its value
			}
			
			if(tempScore < minScore) //check to see if current int is the min 
			{
				minScore = (int) tempScore;
			}
			
			sumScore += tempScore; //add temp score to the sum	
		}//end of while loop
		
		averageScore = sumScore / count; //calculate score average
		
		inputFile.close(); //close the first instance of inputFile so we can open a new one
		inputFile = new Scanner(file); //assign fresh scanner to file
		
		while(inputFile.hasNextInt())
		{
			tempScore = inputFile.nextInt();
			
			if(tempScore > averageScore) //if int is above average add to count
			{
				countAverage++;
			}
			
			if(tempScore >= PASSING) //if int is above 70 add to count
			{
				countOverSev++;
			}
		}
		
		
		/*
		 *  this is the concatenated output message ot print to screen and output file
		 *I used the decimal formatter for average Score output, and have casted the counters into double's so that
		 * we can divide and get the percentage, and then we multiple that by 100 to print a pretty percentage
		 */
		outputMessage = "Number of scores: " + count + "\nMinimum: " + minScore + "\nMaximum: " + maxScore
				+ "\nAverage: " + df.format(averageScore) + "\nScores at or above 70: " + countOverSev + " (" +
				percentage.format(((double) countOverSev / (double) count) * 100) + "%)" + "\nScores above average: " + countAverage + " (" +
				percentage.format(((double) countAverage / (double) count) * 100)+ "%)";
		
		System.out.println(outputMessage);
		outputfile.println(outputMessage);
		
		inp.close();
		inputFile.close();
		outputfile.close();
	}

}