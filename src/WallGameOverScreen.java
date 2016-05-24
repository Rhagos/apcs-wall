import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class WallGameOverScreen extends JPanel{

		WallMain w;
		JButton back;
		public WallGameOverScreen(WallMain w) {
			this.w = w;
			JLabel text1 = new JLabel("GAME OVER");
			text1.setAlignmentX(Component.CENTER_ALIGNMENT);
			text1.setAlignmentY(Component.CENTER_ALIGNMENT);
			add(text1);
			
		}
}
