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
		button1 = new JButton("BUY A HARDWORKING CONSERVATIVE GUARD");
		button1.addActionListener(this);
		add(button1);
		button2 = new JButton("BUY A HARDWORKING REPUBLICAN VOTING WORKER");
		button2.addActionListener(this);
		add(button2);
		returnButton = new JButton("Go back");
		returnButton.addActionListener(this);
		add(returnButton);
		upgradeWall = new JButton("Upgrade a wall");
		upgradeWall.addActionListener(this);
		add(upgradeWall);
		rebuildWall = new JButton("Rebuild a destroyed wall");
		rebuildWall.addActionListener(this);
		add(rebuildWall);
		
		hiredList = new ArrayList<JLabel>();
		for(int i =0; i < g.getPlayer().getHired().size(); i++){
			Person p = g.getPlayer().getHired().get(i);
			hiredList.add(new JLabel(p.getType()));
		}
		for(JLabel j: hiredList){
			add(j);
		}
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
			g.getPlayer().upgradeWall();
		}
		if(e.getSource().equals(rebuildWall)){
			for(int i = 0; i < g.getPlayer().getWall().getWallParts().size(); i++){
				WallPiece a = g.getPlayer().getWall().getWallParts().get(i);
				if(a == null && g.getPlayer().getFunds() >= 1000){
					g.getPlayer().changeFunds(-1000);
					text.setText(g.getPlayer().getFunds() + "");
					g.getPlayer().getWall().buildWall(i);
					break;
				}
			}
		}
	}

}