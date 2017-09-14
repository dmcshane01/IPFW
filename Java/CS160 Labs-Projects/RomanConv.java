/*
NAME: Daniel DelyMcShane
PROJECT: Lab 3 RomanConv
COURSE: CS 160
INSTRUCTOR: Karim Elish
LAB TIME: W 6:00 PM 
DUE DATE: September 19, 2015
DESCRIPTION:
RomanConv takes the user input of a roman numeral in string format
and outputs the integer value to the user
(Only does roman numers 1-8)
*/


import javax.swing.JOptionPane;

public class RomanConv {

	public static void main(String[] args) {
		
		String immutable = JOptionPane.showInputDialog("Please enter your roman numeral(I-VIII):" ); //since strings are immutable and we can't change it to upper case
																									// with toUpper we assign it to a temp string
		
		String numeral = immutable.toUpperCase(); // then String numeral is assigned the Uppercase value of 'immutable'
		numeral.toUpperCase(); //make string uppercase so we don't have to check for lower case characters
		int stLength; //integer used to store the length of numeral
		stLength = numeral.length(); //assigns length of numeral to stLength
		
if(numeral.equals("I") || numeral.equals("II") || numeral.equals("III") || numeral.equals("IV") || numeral.equals("V") //if the input is not one of the 8 valid ones  it throws an error message
					   || numeral.equals("VI") || numeral.equals("VII") || numeral.equals("VIII"))
{																								
		if(numeral.charAt(0) == 'I') //checks for all numerals that begin with an I
		{
			if(stLength > 1) //if the length is greater for one it checks, but if not it prints out 1
			{
				if(stLength > 2) //if the length is greater than 2, the numeral is 3
				{
						JOptionPane.showMessageDialog(null, "The numeral you've entered is 3");
				}
				else if(numeral.charAt(1) ==  'I') //if the second character is I the numerals is 2
				{
					JOptionPane.showMessageDialog(null, "The numeral you've entered is 2");
				}
				else // if none of the other checks pass it has to be a 4
				{
					JOptionPane.showMessageDialog(null, "The numeral you've entered is 4");
				}
				
			}
			else // if length is not greater than 1 the numeral is 4
			{
				JOptionPane.showMessageDialog(null, "The numeral you've entered is 1");
			}
		} // end of if block that checks numerals that start with I
		
		else if(numeral.charAt(0) == 'V') //checks all numerals that start with a v
		{
			if(stLength > 1) // if the numeral is longer than 1 character
			{
				if(stLength > 2)
				{
					if(stLength > 3) // if numeral is longer than 3 characters it is 8
					{
						JOptionPane.showMessageDialog(null, "The numeral you've entered is 8");
					}
					else // if numeral is >2 || <3 then the numeral is 7
					{
						JOptionPane.showMessageDialog(null, "The numeral you've entered is 7");
					}
				}
				else // if not longer than 2 character, the numeral is 6
				{
					JOptionPane.showMessageDialog(null, "The numeral you've entered is 6");
				}
			}
			else // if not longer than 1 character, the numeral is 5
			{
				JOptionPane.showMessageDialog(null, "The numeral you've entered is 5");
			}
			
		}
	
}
else
{
	JOptionPane.showMessageDialog(null, "You have entered an invalid numeral", "ERROR", JOptionPane.ERROR_MESSAGE);
}



}
}
		


