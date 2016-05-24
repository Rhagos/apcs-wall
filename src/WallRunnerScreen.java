import java.awt.*;
import javax.swing.*;
import java.awt.event.*;



public class WallRunnerScreen extends JPanel implements ActionListener {
	
	WallMain w;
	JButton button1;
	JButton button3;
	public WallRunnerScreen(WallMain w) {
		this.w = w;
	
		button1 = new JButton("Play");
		button1.addActionListener(this);
		button1.setAlignmentX(Component.CENTER_ALIGNMENT);
		button1.setAlignmentY(Component.CENTER_ALIGNMENT);
		add(button1);
		button3 = new JButton("Instructions");
		button3.addActionListener(this);
		button3.setAlignmentX(Component.CENTER_ALIGNMENT);
		button1.setAlignmentY(Component.CENTER_ALIGNMENT);
		add(button3);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(button1)){
			w.changePanel();
		}
		if(e.getSource().equals(button3)){
			w.changeToHelp();
		}
	}
} 