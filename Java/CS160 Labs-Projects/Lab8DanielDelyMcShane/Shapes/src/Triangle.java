
	
	public class Triangle
	{
		private double base;
		private double height;
		
		Triangle() //default constructor
		{
			base = 0;
			height = 0;
		}
		
		Triangle(double b, double h) //constructor takes two double arguments
		{
			base = b;
			height = h;
		}
		
		public void setBase(double b)
		{
			base = b;
		}
		
		public double getBase()
		{
			return base;
		}
		
		public void setHeight(double h)
		{
			height = h;
		}
		
		public double getHeight()
		{
			return height;
		}
		
		public double getArea()
		{
			return .5 * base * height;
		}
		
	}	