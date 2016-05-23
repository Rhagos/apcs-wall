import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class WallOptionScreen extends JPanel implements ActionListener {
	
	WallMain w;
	
	public WallOptionScreen(WallMain w) {
		this.w = w;
		JButton button = new JButton("BUY A FUNNEL CAKE");
		button.addActionListener(this);
		add(button);
	}
	
	public void actionPerformed(ActionEvent e) {
		w.changePanel();
	}
} 