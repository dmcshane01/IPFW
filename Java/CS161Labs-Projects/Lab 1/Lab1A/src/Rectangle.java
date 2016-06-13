/*
 * Daniel DelyMcshane
 * CS161
 * Lab 1
 * Rectangle Class
 * Contains data about rectangle and prints out to console
 */

public class Rectangle {
	
	private int numRows;
	private int numCols;
	private boolean filled = false;
	
	//default Constructor not really used
	public Rectangle()
	{
	}
	
	Rectangle(int numRows, int numCols)
	{
		//initializes fields in class
		this.numCols = numCols;
		this.numRows = numRows;
	
	}
	
	public int getNumRows() {
		return numRows;
	}

	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}

	public int getNumCols() {
		return numCols;
	}

	public void setNumCols(int numCols) {
		this.numCols = numCols;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public String toString()
	{
		String output = "";
		
		
		if(filled) //pattern if filled is set to true
		{
			 for(int i = 0; i < numRows; i++)
			 {
				 for(int k = 0;k < numCols; k++)
				 {
					 output += "#"; //while incrementer is less than columns
					 				//prints out appropriate number of symbols
					 				//then does same for next row
				 }
				 output += "\n"; //appends newline character to string to start next row
			 }
		}
		
		if(!filled) //pattern if filled is set to false
		{
			for(int i = 0; i < numRows; i++)
			 {
				output += "#";
				
				 for(int k = 1;k < numCols; k++)
				 {
					//Prints out a constant stream of symbols equal to the number of columns if it is the top or bottom row, or if it is the outside of the rectagle
					if(k == (numCols - 1) || i == 0 || i == (numRows  - 1)) 
					{
						output += "#";
					}
					else
						output += " "; //if it doesn't meet the requirements it prints the whitespace
				 }
				 output += "\n";
			 }
		
		
		}
		return output;
	
	}//end of toString
	
}//end of class
