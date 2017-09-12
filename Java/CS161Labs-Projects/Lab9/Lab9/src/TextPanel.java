/*
 * Daniel DelymcShane
 * CS161
 * April 18, 2016
 * 
 * TextPanel extends JPanel and hold the main jtextarea and it's border of JLabels.
 */

import java.awt.*;
import javax.swing.*;

public class TextPanel extends JPanel {

	JTextArea text;
	JLabel b1;
	JLabel b2;
	JLabel b3;
	JLabel b4;
	
	String forColor;
	String backColor;

	
	public TextPanel()
	{
		buildWindow();
		
	}
	//maybe flowlayout around text area?
	public void buildWindow()
	{
		//set the color and dimensions of the JLabels, which will act as the background
		setLayout(new BorderLayout());
		text = new JTextArea(1, 1);
		b1 = new JLabel("");
		b1.setPreferredSize(new Dimension(10,10));
		b1.setOpaque(true);

		b2 = new JLabel("");
		b2.setPreferredSize(new Dimension(60,10));
		b2.setOpaque(true);

		b3 = new JLabel("");
		b3.setPreferredSize(new Dimension(60,10));
		b3.setOpaque(true);

		b4 = new JLabel("");
		b4.setPreferredSize(new Dimension(10,20));
		b4.setOpaque(true);

		//set the default colors
		setOuterColor("Red"); 
		setInnerColor("White");
		text.setEditable(true);
		
		//add scrollpane
		JScrollPane scrollPane = new JScrollPane(text);
		
		//add labels to panel
		add(text, BorderLayout.CENTER);
		add(b1, BorderLayout.NORTH);
		add(b2, BorderLayout.EAST);
		add(b3, BorderLayout.WEST);
		add(b4, BorderLayout.SOUTH);

		
		setOpaque(true);
		setBackground(Color.RED);
		setVisible(true);
	}
	
	//setOuterColor sets the color of the JLabels based off the string argument
	//sincec it's not user input it should never read any colors besides red purple and blue
	public void setOuterColor(String st)
	{
		//set class variable for color
		backColor = st;
		
		//changes color based on case
		switch(st)
		{
		case "Red": //RED
			b1.setBackground(Color.RED);
			b2.setBackground(Color.RED);
			b3.setBackground(Color.RED);
			b4.setBackground(Color.RED);
			break;
			
		case "Purple":
			b1.setBackground(Color.MAGENTA);
			b2.setBackground(Color.MAGENTA);
			b3.setBackground(Color.MAGENTA);
			b4.setBackground(Color.MAGENTA);
			break; 
			
		case "Blue":
			b1.setBackground(Color.BLUE);
			b2.setBackground(Color.BLUE);
			b3.setBackground(Color.BLUE);
			b4.setBackground(Color.BLUE);
			break; 
			
		}
		
	}
	
	//sets the backgrould color of the JTextArea
	public void setInnerColor(String color)
	{
		//sets class variable as color
		forColor = color;
		
		//set foreground color based off String argument
		switch(color)
		{
	
		case "White":
				text.setBackground(Color.WHITE);
			break;
		case "Gray":
				text.setBackground(Color.GRAY);
			break;
		case "Yellow":
				text.setBackground(Color.YELLOW);
			break;
		}
	}
	
	//sets  color and text info based off FileData arguement
	public void setFileData(FileData fd)
	{
		setInnerColor(fd.forColor);
		setOuterColor(fd.backColor);
		text.setText(fd.getText());
	}
	
	
	//getters below
	public String getText()
	
	{
		return text.getText();
	}
	
	public String getForColor()
	{
		return forColor;
	}
	
	public String getBackColor()
	{
		return backColor;
	}
	
}
