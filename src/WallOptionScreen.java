import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class WallOptionScreen extends JPanel implements ActionListener {
	
	WallMain w;
	
	public WallOptionScreen(WallMain w) {
		this.w = w;
		JButton button1 = new JButton("Launch the Game!");
		button1.addActionListener(this);
		add(button1);
		JButton button2 = new JButton("Launch the Buy Menu!");
		button2.addActionListener(this);
		add(button2);
	}
	
	public void actionPerformed(ActionEvent e) {
		w.changePanel();
	}
} 
