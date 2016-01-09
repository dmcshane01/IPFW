
public class Passenger {
	
	String fNumber;


	String passID;
	String seatNum;
	String name;
	
	
	public Passenger(String passID, String fNumber, String seatNum, String name)
	{
		
		this.passID = passID;
		this.fNumber = fNumber;
		this.seatNum = seatNum;
		this.name = name;
		
	}
	
	public String getfNumber() {
		return fNumber;
	}


	public void setfNumber(String fNumber) {
		this.fNumber = fNumber;
	}


	public String getPassID() {
		return passID;
	}


	public void setPassID(String passID) {
		this.passID = passID;
	}


	public String getSeatNum() {
		return seatNum;
	}


	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String showInfo()
	{
		String out = "Passenger " + name + " has reserved the seat " + seatNum + " on flight " + fNumber 
			+ " their passenger ID is " + passID;
		
		return out;
	}

}
