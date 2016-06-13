/*
 * Daniel DelyMcshane
 * Lab 5B - ParserPanel
 * The Parser Panel class builds the GUI and contains the button listeners
 * It checks if input is valid and outputs the properly parsed info
 */


import java.awt.*;
import java.awt.event.*;
import java.util.StringTokenizer;

import javax.swing.*;

public class ParserPanel extends JFrame {

	//Declare various components
	private JPanel radPanel;
	private JPanel buttonPanel;
	private JPanel outputPanel;
	
	private ButtonGroup bg;
	private JRadioButton ip_Button;
	private JRadioButton id_Button;
	private JRadioButton email_Button;
	
	private JTextField input;
	private JButton tokButton;
	
	private JLabel textOutput;
	private JLabel output1;
	private JLabel output2;
	private JLabel output3;
	private JLabel output4;

	
	public ParserPanel() //constructor sets panel values and adds component panels to the main frame
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 450);
		setTitle("Parser");
		setLayout(new GridLayout(1,3));
		
		buildPanels();
		add(radPanel);
		add(buttonPanel);
		add(outputPanel);
		
		setVisible(true);
		
	}
	
	public void buildPanels() //this function creates the panels and adds components to them
	{
		
		buildObjects(); //initialize components to add to panels
		
		radPanel = new JPanel();
		radPanel.setLayout(new GridLayout(3,1));
		radPanel.add(ip_Button);
		radPanel.add(id_Button);
		radPanel.add(email_Button);
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(2,1));
		buttonPanel.add(input);
		buttonPanel.add(tokButton);
		
		outputPanel = new JPanel();
		outputPanel.setLayout(new GridLayout(5,1));
		outputPanel.add(textOutput);
		outputPanel.add(output1);
		outputPanel.add(output2);
		outputPanel.add(output3);
		outputPanel.add(output4);

	}
	
	public void buildObjects() //initialize all components of GUI
	{
		//initialize button rad contents
		bg = new ButtonGroup();
		ip_Button = new JRadioButton("IP Address");
		id_Button = new JRadioButton("ID Number");
		email_Button = new JRadioButton("Email");
		bg.add(ip_Button);
		bg.add(id_Button);
		bg.add(email_Button);
		
		//initialize button panel contents
		input = new JTextField("");
		tokButton = new JButton("Tokenize");
		tokButton.addActionListener(new TokenizeButtonListener());
		
		//initialize output panel contents
		textOutput = new JLabel("");
		output1 = new JLabel("---");
		output2 = new JLabel("---");
		output3 = new JLabel("---");
		output4 = new JLabel("---");
		//create borders
		textOutput.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		output1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		output2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		output3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		output4.setBorder(BorderFactory.createLineBorder(Color.BLACK));


	}
	
	public boolean numericCheck(String in) //determines if string is numeric for our ip and id fields
	{
		boolean numeric = true;
		char c;
		for(int i = 0; i < in.length(); i++)
		{
			c = in.charAt(i);
			if(!Character.isDigit(c))
			{
				numeric = false;
			}
		}
		
		return numeric;
	}
	
	
	public void setImproperOutput()
	{
		textOutput.setText("Improper Input");
		output1.setText("---");
		output2.setText("---");
		output3.setText("---");
		output4.setText("---");

	}

	private class TokenizeButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String word = input.getText();
			String ip;
			String[] stringArr;
			boolean valid = true;
			StringTokenizer tok;
			
			
			if(ip_Button.isSelected())
			{
				tok = new StringTokenizer(word, ".");//set tokenizer for ip address
				stringArr = new String[4]; //string array to store tokens
				
				if(tok.countTokens()!= 4 ) //if length is not 4 then invalid
				{
					valid = false;
				}
				else if(valid) //if the length of tokens is correct we begin checking each token for validity
				{
					ip = tok.nextToken();
				
					if(ip.length() > 3)
					{
						valid = false;
					}
					else if(!numericCheck(ip))
					{
						valid = false;
					}
					else //if token is valid dadd to array
					{
						stringArr[0] = ip;
						System.out.println("1");
					}
					
					//the above code is copy and pasted with the length checks hanged
					ip = tok.nextToken();
					
					if(ip.length() > 2)
					{
						valid = false;
					}
					else if(!numericCheck(ip))
					{
						valid = false;
					}
					else
					{
						stringArr[1] = ip;
						System.out.println("2");

					}
				
					ip = tok.nextToken();
				
					if(ip.length() > 2)
					{
						valid = false;
					}
					else if(!numericCheck(ip))
					{
						valid = false;
					}
					else
					{
						stringArr[2] = ip;
						System.out.println("3");

					}
				
					ip = tok.nextToken();
				
					if(ip.length() > 3)
					{
						valid = false;
					}
					else if(!numericCheck(ip))
					{
						valid = false;
					}
					else
					{
						stringArr[3] = ip;

					}	
				}//end of else
				
				if(valid) //if valid was not flagged as false we output the IP values
				{
					textOutput.setText("Properly Parsed!");
					output1.setText(stringArr[0]);
					output2.setText(stringArr[1]);
					output3.setText(stringArr[2]);
					output4.setText(stringArr[3]);

				}
				else
					setImproperOutput();
			} //end of ip button statement
			
			if(id_Button.isSelected())
			{
				boolean isValid = true;
				word = input.getText();
				String next;
				stringArr = new String[3];
				tok = new StringTokenizer(word, "-");
				
					if(tok.countTokens() != 3 ) //checks number of tokens
					{
						isValid = false;
					}
					else
					{
						next = tok.nextToken();
						if(!numericCheck(next) || next.length() > 3) //checks if numeric and is incorrect length
						{
							isValid = false;
						}
						else
							stringArr[0] = next; //if valid then add token to string array
						
						//continue similiar structure for each token, flags as invalid if criteria is not met
						
						next = tok.nextToken();
						if(!numericCheck(next) || next.length() > 3)
						{
							isValid = false;
						}
						else
							stringArr[1] = next;
						
						next = tok.nextToken();
						if(!numericCheck(next) || next.length() > 4)
						{
							isValid = false;
						}
						else
							stringArr[2] = next;
						
					}

					if(isValid) //if flag is not set to false then output text
					{
						textOutput.setText("Properly Parsed!");
						output1.setText(stringArr[0]);
						output2.setText(stringArr[1]);
						output3.setText(stringArr[2]);
						output4.setText("---");

					}
					else
						setImproperOutput();
				
			}//end of id_Button if statement
			else if(email_Button.isSelected())
			{
				

				tok = new StringTokenizer(word, "@.");
				
				if(tok.countTokens() != 4) //if token length is correct then it's correct
				{
					String address = tok.nextToken();
					String domain = tok.nextToken();
					String end = tok.nextToken();
				
					textOutput.setText("Properly Parsed!");
					output1.setText(address);
					output2.setText(domain);
					output3.setText(end);
				}
				else
					setImproperOutput();
			}
		
	}
	
	}
}

