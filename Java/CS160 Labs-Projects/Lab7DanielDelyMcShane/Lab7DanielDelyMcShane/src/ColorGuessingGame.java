/*
 * Daniel DelyMcshane
 * Lab 7 - Color Guessing Game
 * CS160 - Karim Elish
 * 10/31/2015
 */

import java.awt.Color;
import javax.swing.*;
import java.util.Random;


public class ColorGuessingGame {
	
	public static String globalColor;

	public static void main(String[] args) {
		
		//prompt user if they would like to play
		 int confirm = JOptionPane.showConfirmDialog(null, "Doyou want to play the guessing game",
		 "Guessing Game", JOptionPane.YES_NO_OPTION); 
		 
		 //if user clicked yes on the dialog box then
		 // the boolean loop is set to true and we run our while loop
		 if(confirm == JOptionPane.YES_OPTION)
		 {
			 boolean loop = true;
			 
			 //while loop runs the game methods 
			 while(loop == true)
			 {
				 Random ranNum = new Random(); //create random object
				 int randoNumber = ranNum.nextInt(6) + 1; // assigns random number between 1 and 6
				 
				 Color picked = chooseColor(randoNumber); //assigns the random Color object to picked
				 guessColor(picked); //color is passed to the guessColor
				 //the guessColor method calls the rest of the necessary functions to complete the game
				 
				 
				 //ask if user would like to play again
				 confirm = JOptionPane.showConfirmDialog(null, "Doyou want to play the guessing game again?",
						 "Guessing Game", JOptionPane.YES_NO_OPTION);
				 if(confirm == JOptionPane.NO_OPTION)
				 {
					 System.exit(0); //if they select no then loop is set to false and program terminates
				 }
			 }
		 }
		 else // terminates if user doesn't want to play
		 {
			 System.exit(0);
		 }
		
	}
	
	
	//This method uses the random integer and determines the 
	//Color for the guessing game with that integer
	public static Color chooseColor(int inpColor)

	{
	
		
		Color color = new Color (0); //create a color objet to return from method
		
		switch(inpColor)
		{
	
		//each case sets global string and color object to a color
		case(1):
			globalColor = "blue";
			color = Color.BLUE;
			break;
		case(2):
			globalColor = "yellow";
			color = Color.YELLOW;
			break;
		case(3):
			globalColor = "red";
			color = Color.RED;
			break;
		case(4):
			globalColor = "green";
			color = Color.GREEN;
			break;
		case(5):
			globalColor = "orange";
			color = Color.ORANGE;
			break;
		case(6):
			globalColor = "cyan";
			color = Color.CYAN;
			break;
		default:
			System.out.println("Invalid color input"); // default case prints out error message, should never reach here.
			System.exit(0);
		}
		return color;
	}
	
	
	//Displays color chosen
	public static void showColor(Color colorArg)
	{
		JFrame frame = new JFrame("Guess this color");
		frame.setSize(200,200);
		frame.setLocation(300,300);
		JPanel panel = new JPanel();
		panel.setBackground(colorArg);
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//Displays the color to user, as well as prompting them to input their color choice
	public static void guessColor(Color colorArg)

	{
		showColor(colorArg); //shows the random color chosen
		String inp = JOptionPane.showInputDialog("Choose the name of the color you see:\nbrown\nred\ngreen\nblue\nmagenta\ncyan\nblack\norange\nyellow\nbeige");
		inp = inp.toLowerCase(); //put inp in lower case to use in switch statement
		confirmGuess(inp); //calls the confirmguess method using the user's color guess
	}
	
	//This method outputs whether the user has won or lost
	public static void confirmGuess(String guess)
	{
		if(guess.equals(globalColor))
		{
			JOptionPane.showMessageDialog(null,"You Win!!");
		}
		else
			JOptionPane.showMessageDialog(null,"You Lose!");
	}	
}