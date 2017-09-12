/*
 * Daniel DelyMcShane
 * CS 161
 * February 6th, 2016
 * This creates a GUI window with the border layout that allows the user to change the background color of 4 different labels
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ColorSelectionGUI extends JFrame {

	//create our componenets here so they can be called by the whole calss
	private JLabel nLabel;
	private JLabel eLabel;
	private JLabel sLabel;
	private JLabel wLabel;
	
	private JRadioButton redRad;
	private JRadioButton greenRad;
	private JRadioButton blueRad;
	private JRadioButton cyanRad;
	
	private JCheckBox nCheck;
	private JCheckBox eCheck;
	private JCheckBox sCheck;
	private JCheckBox wCheck;
	
	ButtonGroup radGroup;
	
	
	
	public ColorSelectionGUI()
	{
		//Constructer creates title, layout, and sets the window size
		setTitle("Color Selection GUI");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(400, 200);
		
		buildWindow();
		
		setVisible(true);
		
	}
	
	public void buildWindow()
	{

		//Assign our Labels Strings and and center them
		nLabel = new JLabel("North Region", SwingConstants.CENTER);
		eLabel = new JLabel("East Region", SwingConstants.CENTER );
		sLabel = new JLabel("South Region", SwingConstants.CENTER);
		wLabel = new JLabel("West Region", SwingConstants.CENTER);
		
		//set them to opaque so we can change background color
		nLabel.setOpaque(true);
		eLabel.setOpaque(true);
		sLabel.setOpaque(true);
		wLabel.setOpaque(true);
		
		//set text to black to be sure
		nLabel.setForeground(Color.BLACK);
		eLabel.setForeground(Color.BLACK);
		sLabel.setForeground(Color.BLACK);
		wLabel.setForeground(Color.BLACK);
		
		//default background color is Cyan
		nLabel.setBackground(Color.CYAN);
		eLabel.setBackground(Color.CYAN);
		sLabel.setBackground(Color.CYAN);
		wLabel.setBackground(Color.CYAN);
		
		
		//add each label to it's spot in the layout
		add(nLabel, BorderLayout.NORTH);
		add(eLabel, BorderLayout.EAST);
		add(sLabel, BorderLayout.SOUTH);
		add(wLabel, BorderLayout.WEST);
		
		
		//creates radio button Text and changes the text colors for each Radio Button
		redRad = new JRadioButton("Red");
		redRad.setForeground(Color.RED);
		
		greenRad = new JRadioButton("Green");
		greenRad.setForeground(Color.GREEN);
		
		blueRad = new JRadioButton("Blue");
		blueRad.setForeground(Color.BLUE);
		
		cyanRad = new JRadioButton("Cyan", true);
		cyanRad.setForeground(Color.CYAN);
		
		//add to a group so that user can only select one at a time
		radGroup = new ButtonGroup();
		radGroup.add(redRad);
		radGroup.add(greenRad);
		radGroup.add(blueRad);
		radGroup.add(cyanRad);
		
		
		//initialize checkboxes, marking them true so they are selected by default
		nCheck = new JCheckBox("North", true);
		eCheck = new JCheckBox("East", true);
		sCheck = new JCheckBox("South", true);
		wCheck = new JCheckBox("West", true);
		
		//create a grid layout panel for the center of the borderlayout
		JPanel cntr = new JPanel(new GridLayout(1,2));
		
		//create 2 panels to divide the checkboxes from radio boxes and also give them a titled border
		JPanel chkBoxes = new JPanel(new GridLayout(4,1));
		chkBoxes.setBorder(BorderFactory.createTitledBorder("Locations"));
		JPanel radButtons = new JPanel(new GridLayout(4,1));
		radButtons.setBorder(BorderFactory.createTitledBorder("Colors"));
		
		//adds check and radio to each component
		chkBoxes.add(nCheck);
		chkBoxes.add(sCheck);
		chkBoxes.add(eCheck);
		chkBoxes.add(wCheck);
		
		radButtons.add(redRad);
		radButtons.add(greenRad);
		radButtons.add(blueRad);
		radButtons.add(cyanRad);
		
		//create actionListener 
		redRad.addActionListener(new RadioButtonListener());
		greenRad.addActionListener(new RadioButtonListener());
		blueRad.addActionListener(new RadioButtonListener());
		cyanRad.addActionListener(new RadioButtonListener());

		//add panels to center panel, then add center panel to borderLayout.Center
		cntr.add(chkBoxes);
		cntr.add(radButtons);
		
		add(cntr, BorderLayout.CENTER);
	
	}
	
	private class RadioButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//this action listener just checks to see which radio button was selected, then for each radio button
			//it checks to see which checkboxes have been selected and changes the background color of the corresponding label
			//it does this for each label and each radio button is the same so no need for more comments
			if(e.getSource() == redRad)
			{
				if(nCheck.isSelected())
				{
					nLabel.setBackground(Color.RED);
				}
				if(eCheck.isSelected())
				{
					eLabel.setBackground(Color.RED);
				}
				if(wCheck.isSelected())
				{
					wLabel.setBackground(Color.RED);
				}
				if(sCheck.isSelected())
				{
					sLabel.setBackground(Color.RED);
				}
			}
			else if(e.getSource() == greenRad)
			{
				if(nCheck.isSelected())
				{
					nLabel.setBackground(Color.GREEN);
				}
				if(eCheck.isSelected())
				{
					eLabel.setBackground(Color.GREEN);
				}
				if(wCheck.isSelected())
				{
					wLabel.setBackground(Color.GREEN);
				}
				if(sCheck.isSelected())
				{
					sLabel.setBackground(Color.GREEN);
				}
			}
			else if(e.getSource() == blueRad)
			{
				if(nCheck.isSelected())
				{
					nLabel.setBackground(Color.BLUE);
				}
				if(eCheck.isSelected())
				{
					eLabel.setBackground(Color.BLUE);
				}
				if(wCheck.isSelected())
				{
					wLabel.setBackground(Color.BLUE);
				}
				if(sCheck.isSelected())
				{
					sLabel.setBackground(Color.BLUE);
				}
			}
			else if(e.getSource() == cyanRad)
			{
				if(nCheck.isSelected())
				{
					nLabel.setBackground(Color.CYAN);
				}
				if(eCheck.isSelected())
				{
					eLabel.setBackground(Color.CYAN);
				}
				if(wCheck.isSelected())
				{
					wLabel.setBackground(Color.CYAN);
				}
				if(sCheck.isSelected())
				{
					sLabel.setBackground(Color.CYAN);
				}
			}
		}
	}
}
