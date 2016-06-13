/*
 * Daniel DelyMcShane
 * CS161
 * 4/19/2016
 * Builds the program GUI
 */
import java.awt.BorderLayout;
import javax.swing.*;

public class MainFrame extends JFrame {

	TextPanel tp;
	BackgroundPanel backPanel;
	ButtonPanel bp;
	//		f.add(a, BorderLayout.SOUTH);
	
	//we can make 3 panels out of this, and add them to the frame Center/East/South
	
	public MainFrame()
	{
		setLayout(new BorderLayout()); //Set main layout as border layout

		//create our three panels 
		tp = new TextPanel();
		backPanel = new BackgroundPanel();
		backPanel.setTextPanel(tp); //pass the textpanel to the background panel
		bp = new ButtonPanel();
		bp.setTextPanel(tp); //pass the textpanel to the button panel
		
		//add panels to frame
		add(tp, BorderLayout.CENTER);
		add(backPanel, BorderLayout.EAST);
		add(bp, BorderLayout.SOUTH);
		
		//prepare and show frame
		setSize(600,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Simple Color Word");
		
		try{
			UIManager.setLookAndFeel("com.sun.Java.swing.plaf.windows.WindowsLookAndFeeT");
			SwingUtilities.updateComponentTreeUI(this);
		}
		catch(Exception e)
		{
			System.out.println("stupid");
		}
		setVisible(true);
	}
	
	
	
	
	 public static void main(String[] args) {
	 
		 new MainFrame();
	 }
}
