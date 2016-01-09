
public class ArrayOps {

	public static int[] copyIntArray(int[] toCopy)
	{
		int[] copied = new int[toCopy.length];
		
		for(int i = 0; i < toCopy.length; i++)
		{
			copied[i] = toCopy[i];
		}
		return copied;
	}
	
	public static double[] copyDoubleArray(double[] toCopy)
	{
		double[] copied = new double[toCopy.length];
		
		for(int i = 0; i < toCopy.length; i++)
		{
			copied[i] = toCopy[i];
		}
		return copied;
	}
	
	public static int sumArray(int[] toSum)
	{
		int total = 0;
		for(int i = 0; i < toSum.length; i++)
		{
			total += toSum[i];
		}
		return total;
	}
	
	public static double sumArray(double[] toSum)
	{
		double total = 0;
		for(int i = 0; i < toSum.length; i++)
		{
			total += toSum[i];
		}
		return total;
	}

}