import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;


public class TurkeyPanel extends JPanel{
	
	public TurkeyPanel(){

		setPreferredSize(new Dimension(500,500));
		KeyListener piss = new listener();
		addKeyListener(piss);
		setFocusable(true);
	}
	
	
	public void paintComponent(Graphics g){
		
		System.out.println("AADSA00");
		
		int xPoints[];
		int yPoints[];
		
		super.paintComponent(g);
		
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


	private class listener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				System.out.println("U PRESSED RIGHT LOL");
			}
			
			System.out.println("Key Pressed = " + KeyEvent.getKeyText(e.getKeyCode()));
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	
	/*
	 * 
		g.setColor(Color.RED);
		
		g.fillOval(85, 100, 50, 250);
		
		g.setColor(Color.BLUE);
		
		g.fillOval(100, 80, 50, 250);
		
		g.setColor(Color.RED);
		
		g.fillOval(125, 60, 50, 250);
		
		g.setColor(Color.BLUE);
		
		g.fillOval(145, 80, 50, 250);
		
		g.setColor(Color.RED);
		
		g.fillOval(185, 100, 50, 250);
		
		g.setColor(new Color(145,85,45));
		
		g.fillOval(75, 150, 250, 250);
		
		g.fillOval(174, 100, 40, 100);
		
	
		
		g.setColor(Color.BLACK);
		
		g.drawOval(173, 99, 42, 102);
		g.fillOval(175, 120, 20, 20);
		
		g.fillOval(195, 120, 20,20);
		
		g.setColor(Color.YELLOW);
		
		
	 */
}