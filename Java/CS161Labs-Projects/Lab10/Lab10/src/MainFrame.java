/*
 * Daniel DelyMcShane
 * CS161
 * Lab10
 * 
 * MainFrame extends JFrame and houses the panel to output the art and buttons
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class MainFrame extends JFrame {
	
	//declare objects
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenu animalMenu;
	private JMenuItem exit;
	private JCheckBoxMenuItem rotate;
	private JRadioButtonMenuItem elephant;
	private JRadioButtonMenuItem cat;
	private JRadioButtonMenuItem dolphin;
	
	private DrawablePanel dp;


	
	public MainFrame()
	{
		setSize(600,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		dp = new DrawablePanel(this); //passes reference to mainframe to panel to select drawings
		buildMenu(); //add components to frame
		add(dp, BorderLayout.CENTER);
		setVisible(true);
		
	}
	
	//buildMenu adds menu components to menubar
	public void buildMenu()
	{
		menuBar = new JMenuBar();
		buildFileMenu();//builds file submenu and animal submenu
		buildAnimalMenu();
		setJMenuBar(menuBar);
	}
	
	
	public void buildFileMenu()
	{
		fileMenu = new JMenu("File");
		exit = new JMenuItem("Exit");
		rotate = new JCheckBoxMenuItem("Rotate");
		rotate.addActionListener(new RotateButtonListener());
		exit.addActionListener(new ExitButtonListener());
		rotate.setMnemonic(KeyEvent.VK_R);
		exit.setMnemonic(KeyEvent.VK_E);
		fileMenu.add(rotate);
		fileMenu.add(exit);
		menuBar.add(fileMenu);
		//add listeners for buttons here
	}
	
	//builds the animal submenu
	public void buildAnimalMenu()
	{
		//crate buttons and menu
		animalMenu = new JMenu("Animals");
		elephant = new JRadioButtonMenuItem("Elephant");
		cat = new JRadioButtonMenuItem("Cat");
		dolphin = new JRadioButtonMenuItem("Dolphin");
		
		ButtonGroup group = new ButtonGroup();
		group.add(elephant);
		group.add(cat);
		group.add(dolphin);
		
		//add action listeners
		cat.addActionListener(new RadioButtonListener());
		elephant.addActionListener(new RadioButtonListener());
		dolphin.addActionListener(new RadioButtonListener());
		cat.setMnemonic(KeyEvent.VK_C);
		elephant.setMnemonic(KeyEvent.VK_L);
		dolphin.setMnemonic(KeyEvent.VK_D);
		
		
		//add buttons to menu
		animalMenu.add(elephant);
		animalMenu.add(cat);
		animalMenu.add(dolphin);
		
		//adds menu to menubar
		menuBar.add(animalMenu);
	}
	
	//returns selected animal
	public String getAnimal()
	{
		if(elephant.isSelected())
		{
			return "elephant";
		}
		else if(cat.isSelected())
		{
			return "cat";
		}
		else
		{
			return "dolphin";
		}
		
		
	}
	
	
	private class RadioButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {

			dp.repaint();
		}
		
	}
	
	private class RotateButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			//uses drawpanel setTimer method to turn timer on and off
			if(rotate.isSelected())
			{
				dp.setTimer(true);
			}
			else
				dp.setTimer(false);
		
			
		}
	}
	
	private class ExitButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
		
	}
		
	
	

}
