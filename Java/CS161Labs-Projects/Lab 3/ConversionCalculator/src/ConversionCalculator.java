/*
 * Daniel DelyMcShane
 * CS161 - Lab 3
 * 
 * ConversionCalculator implements a swing gui interface and lets the user covert units.
 * NOTE: You must hit the clear button before you calculate if you are doing concurrent conversions
 */

import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class ConversionCalculator extends JFrame {
	
	//initialize components
	private JLabel inch_Label, meter_Label, cm_Label, yard_Label;
	private JButton clear, calculate, exit;
	private JTextField inch_tf, cm_tf, meters_tf, yards_tf;
	
	
	public ConversionCalculator()
	{
		
		exitButtonHandler exitB;
		clearButtonHandler clearB;
		calcButtonHandler calcB;
		
		setTitle("Conversion Calculator");
		setSize(600,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//The first layout we use will be 1 row with three columns
		setLayout(new GridLayout(1,3));
		
		//initialize all the components
		inch_Label = new JLabel("Inches");
		meter_Label = new JLabel("Meters");
		cm_Label = new JLabel("Centimeters");
		yard_Label = new JLabel("Yards");

		clear = new JButton("Clear");
		calculate = new JButton("Calculate");
		exit = new JButton("Exit");

		inch_tf = new JTextField("0.00");
		cm_tf = new JTextField("0.00");
		meters_tf = new JTextField("0.00");
		yards_tf = new JTextField("0.00");
	
		
		
		//our inner panels will be 2x2 grid layouts in the first 2 panels, for the tf and labels, then the last panel will be 1x3 for the buttons
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,2));
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(2,2));
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(3,1));

		panel1.add(cm_Label);
		panel1.add(cm_tf);
		panel1.add(meter_Label);
		panel1.add(meters_tf);
		
		panel2.add(inch_Label);
		panel2.add(inch_tf);
		panel2.add(yard_Label);
		panel2.add(yards_tf);
		
		panel3.add(clear);
		panel3.add(calculate);
		panel3.add(exit);
		
		add(panel1);
		add(panel2);
		add(panel3);
		
		
		exitB = new exitButtonHandler();
		exit.addActionListener(exitB);
		
		clearB = new clearButtonHandler();
		clear.addActionListener(clearB);
		
		calcB = new calcButtonHandler();
		calculate.addActionListener(calcB);
		
		setVisible(true);
	}
	
	public static void main(String[] args)
	   {
	      new ConversionCalculator();
	   }
	
	private class exitButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//exits program
			System.exit(0);
		}
	}
	
	private class clearButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//clear button sets all text fields to 0
			inch_tf.setText("0.00");
			meters_tf.setText("0.00");
			yards_tf.setText("0.00");
			cm_tf.setText("0.00");
		}
	}
	
	private class calcButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			double inches, yards, meters, cms;
			DecimalFormat df = new DecimalFormat("0.00");
			
			//parse strings in textbox into doubles
			inches = Double.parseDouble(inch_tf.getText());
			yards = Double.parseDouble(yards_tf.getText());
			meters = Double.parseDouble(meters_tf.getText());
			cms = Double.parseDouble(cm_tf.getText());
			
			//we check which value has been tampered with and base our conversion off this
			//because of this it is important that the user clears, or else it will do inch conversion
			if(inches != 0.00)
			{
				cms = inches * 2.54;
				meters = cms / 100;
				yards = inches / 36;
				
				cm_tf.setText(df.format(cms));
				meters_tf.setText(df.format(meters));
				yards_tf.setText(df.format(yards));
				
			}
			else if(yards != 0.00)
			{
				inches = yards / 36;
				cms = inches * 2.54;
				meters = cms / 100;
				
				cm_tf.setText(df.format(cms));
				meters_tf.setText(df.format(meters));
				inch_tf.setText(df.format(inches));
			}
			else if(meters != 0.00)
			{
				cms = meters * 100;
				inches = cms / 2.54;
				yards = inches / 36;
				
				cm_tf.setText(df.format(cms));
				inch_tf.setText(df.format(inches));
				yards_tf.setText(df.format(yards));
			}
			else if(cms != 0.00)
			{
				inches = cms / 2.54;
				yards = inches / 36;
				meters = cms / 100;
				
				meters_tf.setText(df.format(meters));
				inch_tf.setText(df.format(inches));
				yards_tf.setText(df.format(yards));
			}
		}
	}

}
