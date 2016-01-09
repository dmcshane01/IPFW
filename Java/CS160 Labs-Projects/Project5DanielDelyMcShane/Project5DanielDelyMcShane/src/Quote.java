import java.text.DecimalFormat;

public class Quote {
	
	private String bankName;
	private String codeToBank;
	private double amtToBank;
	private String codeFromBank;
	private double amtFromBank;
	private double bankComRate;
	private double comAmt;
	
	DecimalFormat df = new DecimalFormat("###.##");
	
	public Quote(String bName, String ctb, double atb, String cfb, double afb, double bcr, double ca)
	{
		bankName = bName;
		codeToBank = ctb;
		amtToBank = atb;
		codeFromBank = cfb;
		amtFromBank = afb;
		bankComRate = bcr;
		comAmt = ca;
		
	}
	
	public String toString()
	{
	String message = bankName + " will give you " + df.format(amtFromBank) + " " + codeFromBank + " for "
			+ df.format(amtToBank) + " " + codeToBank + " after collecting a commission of " 
			+ df.format(comAmt )+ " " + "USD " + "(" + bankComRate * 100 + "%)";

	return message;
	}

}
