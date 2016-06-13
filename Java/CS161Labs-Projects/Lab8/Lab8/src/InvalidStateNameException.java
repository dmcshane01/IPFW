
public class InvalidStateNameException extends Exception {

	public InvalidStateNameException()
	{
		super("Invalid State Abbreviation Exception. Your state abbreviation is not valid.");
		
	}
	
	public String getMessage()
	{
		return "Invalid State Abbreviation Exception. Your state abbreviation is not valid.";
	}
}
