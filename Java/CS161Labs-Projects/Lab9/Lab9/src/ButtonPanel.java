/*
 * Daniel DelyMcShane
 * CS161
 * 4/19/2016
 * ButtonPanel builds the panel that houses the buttons and houses actionlisteners
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class ButtonPanel extends JPanel {

	JButton save;
	JButton load;
	TextPanel tp;
	FileData fd;
	
	public ButtonPanel()
	{
		//create buttons add action listeners etc
		setLayout(new GridLayout(1,2));
		
		save = new JButton("Save");
		load = new JButton("Load");
		
		save.addActionListener(new SaveButtonListener());
		load.addActionListener(new LoadButtonListener());
		
		add(save);
		add(load);
		
	}
	
	//gets textpanel to user for operations
	public void setTextPanel(TextPanel tp)
	{
		this.tp = tp;
	}
	
	private class LoadButtonListener implements ActionListener
	{

		public void actionPerformed(ActionEvent arg0) {
			
			
			//try to open objectstream for serialization
			try{
				FileInputStream fis = new FileInputStream("Info.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				//read FileData object
				fd = (FileData) ois.readObject();
				tp.setFileData(fd);
				ois.close();
			}
			catch(IOException e)
			{
				System.out.println("Unable sADASDsa");
		
			} catch (ClassNotFoundException e) {
				System.out.println("Unable to find File");
			}
		}
		
	}
	private class SaveButtonListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			FileOutputStream fos;
			
			//create new FileData object with textpanel info and save it
			fd = new FileData();
			fd.setText(tp.getText());
			fd.setBackColor(tp.backColor);
			fd.setForColor(tp.forColor);
			
			try {
				fos = new FileOutputStream("Info.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(fd);
				oos.close();

			}
			catch( IOException e){
				
				System.out.println("Unable to find File");
			}
		}
		
	}
}
