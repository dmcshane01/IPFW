
public class ArrayOps2D {
	
	//returns total of a double 2d array
	public static double getTotal(double[][] arr)
	{
		
		double total = 0;
		
		for(int rows = 0; rows < arr.length; rows++)
		{
			for(int col = 0; col < arr[rows].length; col++)
			{
				total += arr[rows][col];
			}
					
		}
		
		return total;
	}
	
	//returns the average
	public static double getAverage(double[][] arr)
	{
		double total = 0;
		double count = 0;
		
		//iterates through 2d array and adds the total as well as the maount of items in array
		for(int rows = 0; rows < arr.length; rows++)
		{
			for(int col = 0; col < arr[rows].length; col++)
			{
				total += arr[rows][col];
				count++;
			}
					
		}
		//return average
		return total / count;
	}

	
	public static double getRowTotal(double[][]arr, int rw)
	{
		double total = 0;
		
		//totals user specified row of an array
		for(int i = 0; i < arr[rw].length; i++)
		{
			total += arr[rw][i];
		}
		
		return total;
	}

	public static String findHighestValue(double[][]arr)
	{
		double max    = 0;
		int maxRow	  = 0;
		int maxColumn = 0;
		
		for(int rows = 0; rows < arr.length; rows++)
		{
			for(int columns = 0; columns < arr[rows].length; columns++)
			{
				if(arr[rows][columns] > max)
				{
					max = arr[rows][columns];
					maxRow = rows;
					maxColumn = columns;
				}
			}
		}
		
		return "The highest value is " + max + " from row " + maxRow + ", column " + maxColumn;
		
	}

	public static int findHighestValueInRow(double[][]arr, int rw)
	{
		
		double max = 0;
		int index = 0;
		
		//looks through user specified row and returns the highest value
		for(int i = 0; i < arr[rw].length; i++)
		{
			if(arr[rw][i] > max)
			{
				max = arr[rw][i];
				index = i;
			}
		}
		
		return index;
	}

	public static String sequentialSearch2D(double[][]arr, double find)
	{
		boolean found = false;
		int fRow = 0;
		int fCol = 0;
		
		//iterates through 2d array, and if finds specified value found is set to true
		for(int rows = 0; rows < arr.length; rows++)
		{
			for(int col = 0; col < arr[rows].length; col++)
			{
				if(arr[rows][col] == find)
				{
					found = true;
					fRow = rows;
					fCol = col;
				}
			}
		}
		
		if(found == true)
		{
			return "Value " + find + " found at " + fRow + ", " + fCol;
		}
		else
			return "Value not found";
	}
}

