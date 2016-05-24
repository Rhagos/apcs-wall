import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WallBuyScreen extends JPanel implements ActionListener  {
	JButton button1;
	JButton button2;
	JButton returnButton;
	JButton upgradeWall;
	JButton rebuildWall;
	JLabel text;
	ArrayList<JLabel> hiredList;
	WallMain w;
	WallGameScreen g;
	public WallBuyScreen(WallMain w, WallGameScreen g) {
		this.w = w;
		this.g = g;
		text = new JLabel();
		text.setText(g.getPlayer().getFunds() + "");
		add(text);
		button1 = new JButton("Recruit a Guard");
		button1.addActionListener(this);
		add(button1);
		button2 = new JButton("Recruit a Worker");
		button2.addActionListener(this);
		add(button2);
		returnButton = new JButton("Go back");
		returnButton.addActionListener(this);
		add(returnButton);
		upgradeWall = new JButton("Upgrade a wall");
		upgradeWall.addActionListener(this);
		add(upgradeWall);

		button1.setAlignmentX(Component.CENTER_ALIGNMENT);
		button2.setAlignmentX(Component.CENTER_ALIGNMENT);
		upgradeWall.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(button1)){
			g.addPerson(new Guard(50,50));
			text.setText(g.getPlayer().getFunds() + "");
			add(new JLabel("Guard"));
		}
		if(e.getSource().equals(button2)){
			g.addPerson(new Worker(100,100));
			text.setText(g.getPlayer().getFunds() + "");
			add(new JLabel("Worker"));
		}
		if(e.getSource().equals(returnButton)){
			w.changePanel();
		}
		if(e.getSource().equals(upgradeWall)){
			if(g.getPlayer().getFunds() > 2500){
				g.getPlayer().upgradeWall();
				g.getPlayer().changeFunds(-2500);
			}
			
		}
	}

}