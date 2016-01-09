/*
 * Daniel DelyMcShane
 * CS160
 * Project 4
 * December 9, 2015
 * 
 * This program uses 3 classes, flights passenger and main, to simulate a flight reservation
 * service. It prints out flight charts into a txt file as well as the console
 * 
 * There is 2 things that I am having trouble with in this program, and I have worked around then.
 * 
 * Firstly, If I close any of my Scanners, then the program crashes. From what I am reading it seems like closing a scanner also closes the 
 * System.in, I would need to rewrite my whole program to operate on only 1 scanner, but I found the bug way too late to do that. So the scanners just aren't closed
 * 
 * Secondly, anytime that I iterate through my flightCount array I get weird nullpointer errors. I know why it does this, but I am too late to change anything that
 * big in my program because as I write this it is due in 2 hours. But it's because when I use the for loop I call allFights.length, which when I wrote the code I thought
 * should only return the amount of objects in the array, but it doesn't it returns 100, so in my loops it ends up trying to use methods on null.
 * To work around this I check to see if the spots in an array are null before I call methods on them. The downside is that all for loops loop hundreds of more time than they have to
 */

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

public class Main {
	/*
	 * Declaring these variables in objects outside of the main function 
	 * so that the whole main class can access them
	 */
	
	//keeps track of position in array of flights
	static int flightCount = 0;
	static int passCount = 0;
	
	//arrays used to store fligth and passenger obj
	static Flights[] allFlights = new Flights[100];//stores 100 flights
	static Passenger[] allPass = new Passenger[100];
	
	public static void main(String[] args) throws FileNotFoundException {
	
		boolean cont = true;
		Scanner select = new Scanner(System.in);;

		
		int choice;
		String temp;
		
		//This loop controls the program flow, if user selects 7 it sets cont to false and exits
		while(cont)
		{
		
			System.out.print("1. Add New Flight\n2. Make a new Reservation\n3. Displayy Passengers seats map\n4. List information of all flights"
					+ "\n5.List all passenger reservations for all flights\n6. List all pasenger reservations for a specific flight\n7. Exit the program");
			
			choice = select.nextInt();
			
			switch(choice)
			{
			case(1):
				createFlight();
				break;
			case(2):
				newReservation();
				break;
			case(3):
				System.out.println("Please enter the flight number");
				temp = select.nextLine();
				displayFlightChoice(temp);
				break;
			case(4):
				displayAllFlights();
				break;
			case(5):
				displayAllReservations();
				break;
			case(6):
				System.out.println("Please enter the flight number");
				temp = select.nextLine();
				displayPassForFlight(temp);
				break;
			case(7):
				cont = false;
				break;
			default:
				System.out.println("You've made an invalid selection, please enter again");
				break;
			}
			
		}
		
	}
	
	public static void createFlight() throws FileNotFoundException // this is where the user will select 
	{
		//create scanner and strings for method
		Scanner flightInfo = new Scanner(System.in);
		String fNumber;
		String fDate;
		String fTime;
		String aTime;
		String dCity;
		String desCity;
		int seats;
		
		//This block collects flight data from user
		System.out.println("Please enter the following information:\nFlight Number:");
		fNumber = flightInfo.nextLine();
		fNumber.toUpperCase();
		System.out.println("Flight Date: ");
		fDate = flightInfo.nextLine();
		System.out.println("Flight Departure Time: ");
		fTime = flightInfo.nextLine();
		System.out.println("Flight Arrival Time: ");
		aTime = flightInfo.nextLine();
		System.out.println("Flight Departing City: ");
		dCity = flightInfo.nextLine();
		System.out.println("Flight Destination City: ");
		desCity = flightInfo.nextLine();
		System.out.println("Number of Seats on Plane:");
		seats = flightInfo.nextInt();
		
		//initialize Flight object using user data
		Flights newf = new Flights(fNumber, fDate, fTime, aTime, dCity, desCity, seats);
		
		//adds the flight to array object, and increments the array counter
		allFlights[flightCount] = newf;
		flightCount++;
		
		
	}

	public static void newReservation()
	{
		
		String 		passID;
		String 		seatNum;
		String 		name;
		String 		flight;
		char   		numCheck;
		char     	alphaCheck;
		char[][] 	tempChar; //temp 2d array
		int 		rowIndex;
		int 		colIndex;
				
		
		
		Flights reservedFlight = null;
		Scanner res = new Scanner(System.in);
		
		System.out.println("What is your flight number?");
		flight = res.nextLine();
		flight.toUpperCase();
		File check = new File(flight + ".txt");
		
		//checks to see if file exists, if not then it loops until it finds a valid file
		while(!check.exists())
		{
			System.out.println("That is not a valid flight nummber, please reenter");
			flight = res.nextLine();
			flight.toUpperCase();
			check = new File(flight + ".txt");
		}
		
		//gathers passenger info
		System.out.println("What is your name?");
		name = res.nextLine();
		System.out.println("What is your passenger ID");
		passID = res.nextLine();
		System.out.println("What is your seat Number?(Must be number then letter ex: 1A)");
		seatNum = res.nextLine();
		
		//sets these two chars to the seat numbers to check for valid input
		numCheck = seatNum.charAt(0);
		alphaCheck = seatNum.charAt(1);
		
		//if its more than 2 characters its invalid
		while(seatNum.length() > 2)
		{
			System.out.println("Invalid seat number. Can only be 2 characters, please reenter: ");
			seatNum = res.nextLine();
		}
		
		//if either statement is true then the seat number is invalid
		while(Character.isLetter(numCheck) == true || Character.isDigit(alphaCheck) == true)
		{
			System.out.println("Seat number must be in 1A type format, please enter a valid seat number: ");
			seatNum = res.nextLine();
			numCheck = seatNum.charAt(0);
			alphaCheck = seatNum.charAt(1);
		}
		
		//needs to be uppercase to find the row/column
		seatNum.toUpperCase();
		
		
		//create passenger object using user info, then store in our array
		Passenger newPass = new Passenger(passID, flight, seatNum, name);
		allPass[passCount] = newPass;
		passCount++; //incremement to new spot in array for next passenger object
		
		//iterates through flight objects to find desired flight
		for(int i = 0; i < allFlights.length; i++)
		{
			String tempF = ""; //initilize string to empty
			
			
			if(allFlights[i] != null) //check to see if the current index in array has an object so that we don't throw a nullPointer exception
			{
				tempF = allFlights[i].getfNumber(); //if it's not null then we get the flight number and store it in our temp string
			}
			
			//checks the flightnumber of each flight and see if it equals reservation
			if(tempF.equals(flight))
			{
				//if it does we copy the 2d array into our temp array
				//and copy the object
						tempChar = allFlights[i].getSeats();
						reservedFlight = allFlights[i];
												
			}
		}
	
		
		//tempseats holds the amount of seats in the flight
		int tempSeats = reservedFlight.getAvSeats();
		//we then set the seats of the flight object to one less than it was before,  because seat is now reserved
		reservedFlight.setAvSeats(tempSeats - 1);
		
		//copies seating array into temp array
		tempChar = reservedFlight.getSeats();
		
		
		//Here we will update the flights seating chart to show an x instead of the normal letter
		rowIndex = Character.getNumericValue(seatNum.charAt(0) - 1); //since the shown value is 1 greater than the index, we subtract 1 from the index
		colIndex = (int)seatNum.charAt(1); //get the unicode value of the second char
		
		 
		//find the remainder of colindex divided by 65 because it was a capital letter cast to int, so it is at least 65 (the unicode for A)
		//so if it was A the index is casted to the int 65, which will be 0, which is gonna be 0 when we do the remainded. Since [0][0] is not the righ spot, we add
		// 1 to the colIndex to move it over to the right.
		colIndex = (colIndex % 65) ;
		System.out.print(rowIndex + " " + colIndex);
		
		//sets the found spot to X for taken
		tempChar[rowIndex][colIndex] = 'X';
		
		reservedFlight.setSeats(tempChar);
		
		
	}

	public static void displayFlightChoice(String fNumber)
	{
		fNumber.toUpperCase();
		String tempString = "";
		
		for(int i = 0; i < allFlights.length; i++)
		{
			if(allFlights[i] != null)
			{
				tempString = allFlights[i].getfNumber();
				
				if(fNumber.equals(tempString))
				{
						allFlights[i].printSeats();
						break;
				}
			}
		}
		
		
	} 
	
	public static void displayAllFlights()
	{
		
		for(int i = 0; i < allFlights.length; i++)
		{
			//make sure that object in array isn't empty to avoid null pointer exception
			if(allFlights[i] != null)
			{
				allFlights[i].printSeats();
			}
		}
		
	
	}
	
	public static void displayAllReservations()
	{
		String temp;
		for(int i = 0; i < allPass.length; i++)
		{
			if(allPass[i] != null)
			{
				temp = allPass[i].showInfo();
				System.out.println(temp);
			}
		}
	}
	
	public static void displayPassForFlight(String fNum)
	{
		String temp;
		for(int i = 0; i < allPass.length; i++)
		{
			if(allPass[i] != null)
			{
				if(allPass[i].getfNumber().equalsIgnoreCase(fNum))
				{
					temp = allPass[i].showInfo();
					System.out.println(temp);
				}
			}
		}
	}
}
