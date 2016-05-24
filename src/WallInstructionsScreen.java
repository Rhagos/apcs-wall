import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class WallInstructionsScreen  extends JPanel implements ActionListener 
{

	WallMain w;
	public WallInstructionsScreen(WallMain w) {
		this.w = w;
		JTextArea text1 = new JTextArea("This program is a game where the player "
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
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
	}
}

