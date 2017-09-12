/*
 * Daniel DelyMcShane
 * CS161
 * Project 3
 * 4/30/2016
 * 
 * TileDesignGUI builds all the components into the main jframe, and hosues the action listeners as well
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

import javax.swing.*;

public class TileDesignGUI extends JFrame {

	//panels
	private JPanel tilePanel;
	private JPanel buttonPanel;
	private JPanel listPanel;
	private JPanel fgPanel;
	//buttons
	private JButton save;
	private JButton load;
	private JButton exit;
	private JButton reset;
	//radio buttons
	private JRadioButton black;
	private JRadioButton white;
	private JRadioButton red;
	private JRadioButton green;
	private JRadioButton blue;
	//misc objects used
	private JComboBox bgComboBox;
	private ButtonGroup bg;
	private JFileChooser fileChooser;
	private File file;
	//for tile serialization
	private FileOutputStream fos;
	private FileInputStream fis;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	//arrays
	private Tile tiles[][];
	private String bgColors[];

	public TileDesignGUI()//constructor
	{
		//set up frame and initialize all panels and tiles
		setSize(600,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		tiles = new Tile[9][9];
		buildTiles();
		buildButtons();
		buildList();
		fileChooser = new JFileChooser(); //causes errors if you try to initialize it in a method 
		setVisible(true);
	}
	
	//builds panel that holds the tiles
	public void buildTiles()
	{
		tilePanel = new JPanel();//create panel with 9x9 gridlayout
		tilePanel.setLayout(new GridLayout(9,9));
		//initializes all panels, adds handlers, then adds tile to tilePanel
		for(int i = 0; i < tiles.length; i++)
		{
			for(int j = 0; j < tiles[i].length; j++)
			{
				tiles[i][j] = new Tile();//creates tile
				tiles[i][j].addActionListener(new TileHandler());//adds action listener to new tiel
				tiles[i][j].setOpaque(true);
				tilePanel.add(tiles[i][j]);//adds tile to panel
			}
		}
		//add the 9x9 tilepanel to main frame
		add(tilePanel, BorderLayout.CENTER);
	}
	//builds panel that houses save/load/exit buttons
	public void buildButtons()
	{
		//create buttons and set mnemonic, listeners, tooltips
		save = new JButton("Save");
		load = new JButton("Load");
		exit = new JButton("Exit");
		save.setMnemonic(KeyEvent.VK_S);
		load.setMnemonic(KeyEvent.VK_L);
		exit.setMnemonic(KeyEvent.VK_X);
		save.addActionListener(new SaveHandler());
		load.addActionListener(new LoadHandler());
		exit.addActionListener(new ExitHandler());
		save.setToolTipText("Saves the current tile structure");
		load.setToolTipText("Loads a new .til file");
		exit.setToolTipText("Closes the program");
		//add buttons to buttonPanel
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,3));
		buttonPanel.add(save);
		buttonPanel.add(load);
		buttonPanel.add(exit);
		//add buttonPanel to frame
		add(buttonPanel, BorderLayout.SOUTH);
	}
	
	//build panel that holds color lists and reset button
	public void buildList()
	{
		//create button
		reset = new JButton("Reset");
		reset.setMnemonic(KeyEvent.VK_R);
		reset.addActionListener(new ResetHandler());
		reset.setToolTipText("Resets the GUI to defaults.");
		
		//initialize buttons then add to a buttongroup
		black = new JRadioButton("Black");
		white = new JRadioButton("White");
		white.setSelected(true);//sets to white by default
		red = new JRadioButton("Red");
		green = new JRadioButton("Green");
		blue = new JRadioButton("Blue");
		bg = new ButtonGroup();
		bg.add(black);
		bg.add(white);
		bg.add(red);
		bg.add(green);
		bg.add(blue);
		
		
		//create the fgPanel to hold the radio buttons
		fgPanel = new JPanel();
		fgPanel.setLayout(new GridLayout(5,1));
		fgPanel.add(black);
		fgPanel.add(white);
		fgPanel.add(red);
		fgPanel.add(green);
		fgPanel.add(blue);
		fgPanel.setBorder(BorderFactory.createTitledBorder("FG Color"));
		
		//Initialize combobox for fg color and create border
		bgColors = new String[] {"Black", "White", "Red", "Green", "Blue"};
		bgComboBox = new JComboBox(bgColors);
		bgComboBox.setBorder(BorderFactory.createTitledBorder("BG Color"));
		
		//create the mainpanel for all the components in this function
		listPanel = new JPanel();
		listPanel.setLayout(new BorderLayout());
		listPanel.add(reset, BorderLayout.NORTH);
		listPanel.add(fgPanel, BorderLayout.CENTER);
		listPanel.add(bgComboBox, BorderLayout.SOUTH);
		//add the list panel to frame
		add(listPanel, BorderLayout.EAST);
		
		
	}
	
	//returns string of the selected foreground olor
	public String getFG()
	{
		
		if(black.isSelected())
		{
			return "black";
		}
		else if(white.isSelected())
		{
			System.out.println("DSDA");
			return "white";
		}
		else if(red.isSelected())
		{
			return "red";
		}
		else if(green.isSelected())
		{
			return "green";
		}
		else if(blue.isSelected())
		{
			return "blue";
		}
		
		return "black"; //if none are selected then it is black because the program loads as black
		
	}

	private class TileHandler implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e) {

			Tile source = (Tile)e.getSource(); //gets tile that was clicked
			source.switchText(); //changes label text
			source.setBackground((String)bgComboBox.getSelectedItem());//switches bg and fg colors
			source.setForeground(getFG());
		}
		
	}
	
	private class SaveHandler  implements ActionListener  
	{
		public void actionPerformed(ActionEvent e) {
			try {
				int status = fileChooser.showSaveDialog(null);
				if(status == JFileChooser.APPROVE_OPTION) //if file not read properly throw an exception
				{
					file = fileChooser.getSelectedFile();
				}
				else
					throw  new IOException();

				fos = new FileOutputStream(file.getPath());
				oos = new ObjectOutputStream(fos);
				
				//nested for loop to loop through and serialize each tile
				for(int i = 0; i < tiles.length; i++)
				{
					for(int j = 0; j < tiles[i].length; j++)
					{
						oos.writeObject(tiles[i][j]);
					}
				} //end of outer foor loop	
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("Error saving file");
			}
		}
	}//end of listener
	
	private class LoadHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				String fileName = null;
				int status = fileChooser.showOpenDialog(null);
				
				if(status == JFileChooser.APPROVE_OPTION)//if file not read properly throw an exception
				{
					fileName = fileChooser.getSelectedFile().getPath();
				}
				else 
					throw new IOException();
				
				fis = new FileInputStream(fileName);
				ois = new ObjectInputStream(fis);
				//nested for loop to loop through and serialize each tile
				for(int i = 0; i < tiles.length; i++)
				{
					for(int j = 0; j < tiles[i].length; j++)
					{
						Tile temp = (Tile) ois.readObject();
						tiles[i][j].setForeground(temp.getForeground());
						tiles[i][j].setBackground(temp.getBackground());
						tiles[i][j].setOutput(temp.getOutput());	
					}
				} //end of outer foor loop	
			} catch (IOException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println("Error loading file");
			}	
		}//end of actionPerformed
		
	}//end of listener
	
	private class ResetHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) {
		
			//nested for resets all tiles to default state
			for(int i = 0; i < tiles.length; i++)
			{
				for(int j = 0; j < tiles[i].length; j++)
				{
					tiles[i][j].reset();
				}
			} //end of outer foor loop	
			//sets bg and fg buttons to black and white selected
			white.setSelected(true);
			bgComboBox.setSelectedIndex(0);
		}
		
	}
	
	private class ExitHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}
}
