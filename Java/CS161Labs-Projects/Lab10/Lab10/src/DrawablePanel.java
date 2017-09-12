/*
 * Daniel DelyMcShane
 * CS161
 * Lab10
 * 
 * Drawpanel houses all methods and timers to output my art to the screen
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DrawablePanel extends JPanel {
	
	MainFrame mf;
	int xPoints[];
	int yPoints[];
	boolean rotate;
	String animal;
	private Timer rotateTimer;
	
	public DrawablePanel(MainFrame mf)
	{
		setPreferredSize(new Dimension(500,500));
		this.mf = mf;
		
		rotateTimer = new Timer(3000, new TimerListener());

	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		
		//if the timer isn't running we get the selected animal from MainFrame
		if(!rotateTimer.isRunning())
		{
			animal = mf.getAnimal();
		}
		
		if(animal.equalsIgnoreCase("elephant")) //draw elephant
		{
			drawElephant(g);
		}
		else if(animal.equalsIgnoreCase("cat")) //draws a cat
		{
			drawCat(g);
		}
		else if(animal.equalsIgnoreCase("dolphin")) //draw dolphin
		{
			drawDolphin(g);
		}
	}
	
	//draws cat
	public void drawCat(Graphics g)
	{

		g.setColor(Color.GRAY);
		
		g.fillOval(200, 200, 250, 250);
		
		g.setColor(Color.BLACK);
		
		xPoints = new int[]{255, 320, 287};
		yPoints = new int[]{250,250,150};
	
		g.fillPolygon(xPoints, yPoints, 3);
		
		xPoints = new int[] {330, 400, 347};
		yPoints = new int[]{250, 250, 150};
		
		g.fillPolygon(xPoints, yPoints, 3);
		
		g.setColor(Color.WHITE);
		g.fillOval(255, 280, 50, 50);
		g.fillOval(330, 280, 50, 50);
	}
	
	//draws "elephant"
	public void drawElephant(Graphics g)
	{

		g.setColor(Color.GRAY);
		
		g.fillOval(100, 300, 400, 200);
		
		g.fillOval(450, 300, 150, 150);
		
	}
	
	//draws "dolphin"
	public void drawDolphin(Graphics g)
	{
		g.setColor(Color.GRAY);
		
		g.fillOval(100, 200, 400, 100);
		

		xPoints = new int[]{255, 320, 287};
		yPoints = new int[]{250,250,150};
		
		g.fillPolygon(xPoints, yPoints, 3);
	}
	
	//start or stops timer
	public void setTimer(boolean on)
	{
		
		if(on)
		{
			rotateTimer.start();
		}
		else
		{
			rotateTimer.stop();
		}
	}
	
	   private class TimerListener implements ActionListener
	   {
		   int i = 0;
		   int choice = 0;

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//i increments each tick of the timer and then used to select the animal to draw
			//by getting i%3
			choice = i % 3; //0, 1, or 2
			
			
			switch(choice)
			{
			case(0):
				animal = "elephant";
				break;
			case(1):
				animal = "cat";
				break;
			case(2):
				animal = "dolphin";
				break;	
			}
			
				repaint();
				i++;

			}
		   
	   }
}
