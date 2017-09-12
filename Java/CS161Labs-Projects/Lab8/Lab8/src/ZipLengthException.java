
public class ZipLengthException extends Exception {
	
	public ZipLengthException()
	{
		super("Invalid zip code; please reenter.");
	}
	
	public String getMessage()
	{
		return "Invalid zip code; please reenter.";
	}

}
