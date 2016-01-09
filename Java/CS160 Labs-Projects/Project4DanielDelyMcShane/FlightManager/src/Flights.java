import java.io.*;

public class Flights {
	
	final int COLUMNS = 8; 
	String fNumber;
	String fDate;
	String depTime;
	String arrTime;
	String depCity;
	String destCity;
	String fileOutput; //used to store string to output to txt file
	int	   avSeats;
	int    rows;
	
	char[][] seats;

	public Flights(String fNumber, String fDate, String depTime, String arrTime, String depCity,
			String destCity, int avSeats) throws FileNotFoundException
	{
		this.fNumber  = fNumber;
		this.fDate    = fDate;
		this.depTime  = depTime;
		this.arrTime  = arrTime;
		this.depCity  = depCity;
		this.destCity = destCity;
		this.avSeats  = avSeats;
		
		if(avSeats % 7 == 0) //since there is 7 seats in a row, if there is no remainder then we make rows the amount of total seats divide by 7
		{

			rows = avSeats / 7;
		}
		else
			rows = (avSeats / 7) + 1; // adds another row for remainder of seats
		
		seats = new char[rows][COLUMNS];//2d array, set columns to 8
		
		
		char position = 65; //65 is 'A', used to print character into seats pattern
		
		//Fills a 2d char array with passenger info, empty.
		for(int i = 0; i < rows; i++)
		{
			seats[i][0] = (char) (i + 1);
			for(int j = 0; j < COLUMNS - 1; j++)
			{
				seats[i][j] = position; 
				position++;
			}
			position = 65;
		}
		
		
		//create file storing flight data
		this.createFile();
	}
	
	public char[][] getSeats() {
		return seats;
	}

	public String getfNumber() {
		return fNumber;
	}

	public String getfDate() {
		return fDate;
	}

	public String getDepTime() {
		return depTime;
	}

	public String getArrTime() {
		return arrTime;
	}

	public String getDepCity() {
		return depCity;
	}

	public String getDestCity() {
		return destCity;
	}

	public int getAvSeats() {
		return avSeats;
	}
	
	public void setAvSeats(int sts){
		avSeats = sts;
	}
	
	//creates file storing flight information
	public void createFile() throws FileNotFoundException
	{
		String fileName = fNumber + ".txt"; //take flight number and append .txt to it to create file
		PrintWriter pr = new PrintWriter(fileName); //create the file
		
		String output;
		//prints 2d array into txt file
		int index = 0;
		
		for(int i = 0; i < rows; i++)
		{
						//(i+1) is for the row number, since it starts at 1 we add one
						//the rest of this string outputs the Letters of the seat charts to the file
				output = (i + 1) + "\t" + seats[i][index++] + " " + seats[i][index++] + "\t" + seats[i][index++] + " " + seats[i][index++] + " " + seats[i][index++]
						+ "\t" + seats[i][index++] + " " + seats[i][index++];
				
				pr.println(output);
				pr.println();
				index = 0;
		}
		
		pr.close();
	}
	
	public void printSeats()
	{
		String output = null;
		int index = 0;
		
		for(int i = 0; i < rows; i++)
		{
			//outputs a row of the flight seating chart. we use i + 1 to print out the number for the row, then increase index after each column letter is printed
			output = (i + 1) + "\t" + seats[i][index++] + " " + seats[i][index++] + "\t" + seats[i][index++] + " " + seats[i][index++] + " " + seats[i][index++]
					+ "\t" + seats[i][index++] + " " + seats[i][index++];
			System.out.println(output);
			System.out.println();
			index = 0;
		}
		
		
	}

	public void setSeats(char[][] tempChar) {
		
		this.seats = tempChar;
		
	}
}

	
