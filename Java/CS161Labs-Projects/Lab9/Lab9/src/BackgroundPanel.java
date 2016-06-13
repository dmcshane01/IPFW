/*
 * Daniel DelyMcShane
 * CS161
 * 4/19/2016
 * Background Panel hold the list and combo boxes that the user selects to change
 * the color of the writing area
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class BackgroundPanel extends JPanel {

	JList list;
	JComboBox cb;
	TextPanel tp;
	
	public BackgroundPanel()
	{
		buildWindow();
	}
	
	public void buildWindow()
	{
		setLayout(new GridLayout(2,1));

		//create list
		String[] bColors = {"Red", "Blue", "Purple"};
		list = new JList(bColors);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//create combo box
		String[] fColors = {"White", "Gray", "Yellow"};
		cb = new JComboBox(fColors);
		
		//add listeners
		cb.addActionListener(new ComboBoxListener());
		list.addListSelectionListener(new ListListener());
		
		//add to panel
		add(list);
		add(cb);
		setVisible(true);

	}
	
	//gets the textpanel so we can adjust its values
	public void setTextPanel(TextPanel a)
	{
		tp = a;
	}
	
	//ComboBoxListener sets the foreground color of textpanel
	private class ComboBoxListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0) {
		
			
			String choice = (String) cb.getSelectedItem();
			tp.setInnerColor(choice);
		}
		
	}
	
	//listListener sets background color of textpanel
	private class ListListener implements ListSelectionListener
	{

	

		public void valueChanged(ListSelectionEvent arg0) {
			String choice = (String) list.getSelectedValue();
			tp.setOuterColor(choice);
			
	
			
			
		}
		
	}
	
	
}
