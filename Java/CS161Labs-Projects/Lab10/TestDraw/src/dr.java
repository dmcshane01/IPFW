import java.awt.BorderLayout;

import javax.swing.JFrame;

public class dr {

	public static void main(String[] args) {

		JFrame a = new JFrame();
		TurkeyPanel tp = new TurkeyPanel();
		a.setSize(600,800);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		a.setLayout(new BorderLayout());
		a.add(tp,BorderLayout.CENTER);
		a.setVisible(true);
	}

}
