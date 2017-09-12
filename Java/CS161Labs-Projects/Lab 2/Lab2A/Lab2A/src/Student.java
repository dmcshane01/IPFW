/*
 * Daniel DelyMcShane
 * 1/25/2016	
 * CS161
 * 
 * Student class stores information about  a student and their test scores
 */
public class Student {
	
	final int SIZE = 5;
	private String name;
	private char grade;
	private double average;
	private int[] scores = new int[SIZE];
	
	public Student()
	{
		
	}
	public void calculateAverage()
	{
		double total = 0;
		
		for(int i = 0; i < SIZE; i++)
		{
			total += scores[i];  //total value of array elements
		}
		
		average = total/SIZE; 
	}
	
	public void calculateGrade()
	{
		if(average >= 90)
		{
			grade = 'A';
		}
		else if(average >= 80)
		{
			grade = 'B';
		}
		else if(average >= 70)
		{
			grade = 'C';
		}
		else if(average >= 60)
		{
			grade = 'D';
		}
		else
			grade = 'F';
	}
	
	public int[] getScores() {
		int[] temp = new int[scores.length];
		
		for(int i = 0; i < scores.length; i++)
		{
			temp[i] = scores[i];
		}
		return temp;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	
	
	public void setScores(int[] scoresTemp) { //create deep copy of array

		for(int i = 0; i < scores.length; i++)
		{
			this.scores[i] = scoresTemp[i];
			
		}

	}
	

	
}
