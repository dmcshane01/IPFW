package test;

import java.awt.BorderLayout;

import javax.swing.*;

public class test {

	static JFrame f;
	
	static JLabel a;
	static JButton b;
	static JButton c;
	
	//public static void main(String[] args) {
		
	//	buildWindow();
	//	f.setVisible(true);
	//}
	
	public static void buildWindow()
	{
		f = new JFrame();
		f.setLayout(new BorderLayout());
		f.setSize(600, 800);
		
	
		
		a = new JLabel("A");
		b = new JButton("B");
		c = new JButton("C");
		
		f.add(a, BorderLayout.SOUTH);
		f.add(b, BorderLayout.CENTER);
		f.add(c, BorderLayout.EAST);
		
		
	}

}
