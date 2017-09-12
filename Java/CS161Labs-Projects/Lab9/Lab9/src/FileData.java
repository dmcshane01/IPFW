import java.io.Serializable;

public class FileData implements Serializable {
	
	String text;
	String backColor;
	String forColor;
	
	public FileData()
	{
		
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getBackColor() {
		return backColor;
	}

	public void setBackColor(String backColor) {
		this.backColor = backColor;
	}

	public String getForColor() {
		return forColor;
	}

	public void setForColor(String foreColor) {
		this.forColor = foreColor;
	}

	
}
