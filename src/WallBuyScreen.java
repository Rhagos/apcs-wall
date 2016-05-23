import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class WallBuyScreen extends JPanel implements ActionListener  {
	JButton button1;
	JButton button2;
	JButton returnButton;
	WallMain w;
	WallGameScreen g;
	public WallBuyScreen(WallMain w, WallGameScreen g) {
		this.w = w;
		this.g = g;
		button1 = new JButton("BUY A HARDWORKING CONSERVATIVE GUARD");
		button1.addActionListener(this);
		add(button1);
		button2 = new JButton("BUY A HARDWORKING REPUBLICAN VOTING WORKER");
		button2.addActionListener(this);
		add(button2);
		returnButton = new JButton("Go back");
		returnButton.addActionListener(this);
		add(returnButton);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(button1)){
			g.addPerson(new Guard(50,50));
		}
		if(e.getSource().equals(button2)){
			g.addPerson(new Worker(100,100));
		}
		if(e.getSource().equals(returnButton)){
			w.changePanel();
		}
		
	}

}