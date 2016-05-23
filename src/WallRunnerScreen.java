import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class WallRunnerScreen extends JPanel implements ActionListener {
	
	WallMain w;
	
	public WallRunnerScreen(WallMain w) {
		this.w = w;
	
		JButton button1 = new JButton("Play");
		button1.addActionListener(this);
		button1.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(button1);
		JButton button2 = new JButton("Settings");
		button2.addActionListener(this);
		button2.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(button2);
		JButton button3 = new JButton("Instructions");
		button3.addActionListener(this);
		button3.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(button3);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		w.changePanel();
	}
} 
