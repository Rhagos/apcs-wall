
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class WallInstructionsScreen  extends JPanel implements ActionListener 
{

	WallMain w;
	JButton back;
	public WallInstructionsScreen(WallMain w) {
		this.w = w;
		JLabel text1 = new JLabel("This program is a game where the player "
				+ "\ncharacter builds and manages the building of a wall to keep"
				+ "\nan evil alien species from eating the village. The overall "
				+ "\nrules are that the player cannot directly build the wall or"
				+ "\ninteract with the supplies or aliens. This game is a mix of "
				+ "\na base defense/tower defense and a base management simulator,"
				+ "\nfeaturing basic computer controlled towers, guards, and "
				+ "\nworkers along with an alien threat that must be stopped. "
				+ "\nThe primary features for our program is an AI controlled "
				+ "\npopulation that performs the construction, defense, "
				+ "maintainence, and assault of the wall");
		add(text1);
		text1.setAlignmentX(Component.CENTER_ALIGNMENT);

		back = new JButton("Back");
		back.addActionListener(this);
		add(back);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		w.changePanel();
		
	}
}