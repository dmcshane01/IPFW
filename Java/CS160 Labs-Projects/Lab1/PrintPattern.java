/*
 * Created 09-02-15 by Daniel DelyMcShane
 * This class will print out rows of stars in a varying degree of methods
 * 
 *     ================ ERROR REPORTING =====================
 *      a) main method not found in class
		b) Main method not found in class
		c) Runs without error
		d) Runs without errpr
		e) Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
				Syntax error, insert "VariableDeclarators" to complete LocalVariableDeclaration
				Syntax error, insert ";" to complete BlockStatements
		f) Syntax error on token ":", ; expected
		g) It works if you leave the semicolon
		h) I don't see any changes
 */


public class PrintPattern {

	public static void main(String[] asdahsdlasda)
	{
		PartA(); 
		PartB();
		PartC();
		PartD();
		PartE();
		termination();

	}
	
	public static void PartA()
	{
		
		System.out.println("Printing star pattern using default method:\n");
		System.out.println("**");
		System.out.println("****");
		System.out.println("******");
		System.out.println("****");
		System.out.println("**");
		System.out.println();
	};
	
	public static void PartB()
	{
		System.out.println("Printing star pattern using a string:\n");
		String stars = "**\n****\n******\n****\n**\n";
		System.out.println(stars);
		System.out.println();
	};
	
	public static void PartC()
	{
		System.out.println("Printing star pattern using \\t, \\n, and space characters:\n");
		System.out.println("**    \t\n****\n******\n****\n**\n"); //not sure how spaces or tab characters can be useful here
		System.out.println();
	
	};
	
	public static void PartD()
	{
		System.out.println("Printing pattern with a single print statement:\n");
		System.out.println("**\n****\n******\n****\n**\n");
	};
	
	public static void PartE()
	{
	int number = 100;
	System.out.println("Created variable 'number' of type int and assigned value of 100.\n"
			+ " Ouptput of 'number' = " + number + "\n\n");
	};
	
	public static void termination()
	{
		String name = "Daniel DelyMcShane";
		int number = 100;
		System.out.println("**\n****\n******\n****\n**\n\n");
		System.out.println("Program is now terminating, This program was created by "
				+ name + " and his favorite number is " + number);
		
	};
	
	

}
