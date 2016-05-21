import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class WallBuyScreen extends JPanel implements ActionListener  {

	WallMain w;
	public WallBuyScreen(WallMain w) {
		this.w = w;
		JButton button1 = new JButton("BUY A HARDWORKING CONSERVATIVE GUARD");
		button1.addActionListener(this);
		add(button1);
		JButton button2 = new JButton("BUY A HARDWORKING REPUBLICAN VOTING WORKER");
		button2.addActionListener(this);
		add(button2);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
