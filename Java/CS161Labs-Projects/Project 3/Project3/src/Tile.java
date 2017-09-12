/*
 * Daniel DelyMcShane
 * CS161
 * Project 3
 * 4/30/2016
 * 
 * Tile extends JButton to make a button that changes text and colors when clicked
 */import java.awt.*;
import java.io.*;
import javax.swing.*;

public class Tile extends JButton implements Serializable {
	
	private Color bg;
	private Color fg;
	private boolean output;
	
	public Tile()
	{
		output = false;
		switchText();
		bg = Color.BLACK;
		fg = Color.WHITE;
		setBackground(this.bg);
		setForeground(fg);
		setOpaque(true);
	
	}
	
	//sets color of foreground via string
	public void setForeground(String fg)
	{
		System.out.println("323232");
		if(fg.equalsIgnoreCase("black"))
		{
			this.fg = Color.BLACK;
			setForeground(this.fg);
		}
		else if(fg.equalsIgnoreCase("white"))
		{
			this.fg = Color.WHITE;
			setForeground(this.fg);
		}
		else if (fg.equalsIgnoreCase("red"))
		{
			this.fg = Color.RED;
			setForeground(this.fg);
		}
		else if(fg.equalsIgnoreCase("green"))
		{
			this.fg = Color.GREEN;
			setForeground(this.fg);
		}
		else if(fg.equalsIgnoreCase("blue"))
		{
			this.fg = Color.BLUE;
			setForeground(this.fg);
		}
	}

	//sets background color by string
	public void setBackground(String bg)
	{
		if(bg.equalsIgnoreCase("black"))
		{
			this.bg = Color.BLACK;
			setBackground(this.bg);
		}
		else if(bg.equalsIgnoreCase("white"))
		{
			this.bg = Color.WHITE;
			setBackground(this.bg);
		}
		else if (bg.equalsIgnoreCase("red"))
		{
			this.bg = Color.RED;
			setBackground(this.bg);
		}
		else if(bg.equalsIgnoreCase("green"))
		{
			this.bg = Color.GREEN;
			setBackground(this.bg);
		}
		else if(bg.equalsIgnoreCase("blue"))
		{
			this.bg = Color.BLUE;
			setBackground(this.bg);
		}
	}
	
	//sets Text on click and switches boolean value for next click
	public void switchText()
	{
		
		if(output == true){
			setText("X");
		}
		else{
			setText("O");
		}
		
		output = !output; //after every switch we change the bool value to it's opposite so that next call it will do different output
	}
	
	public String getOutput()
	{
		return this.getText();
	}
	
	//sets the output String as well as the boolean switch
	public void setOutput(String xo)
	{
		if(xo.equals("X"))
		{
			setText("X");
			output = false;
		}
		else if(xo.equals("O"))
		{
			setText("O");
			output = true;
		}
	}
	
	//resets all fields to default
	public void reset()
	{
		this.fg = Color.WHITE;
		setForeground(this.fg);
		this.bg = Color.BLACK;
		setBackground(this.bg);
		setText("O");
		output = true;
	}
	
}
