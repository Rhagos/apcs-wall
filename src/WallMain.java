import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WallMain extends JFrame{
JPanel cardPanel;
	
	public WallMain(String title) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
		WallOptionScreen panel1 = new WallOptionScreen(this);    
	    WallGameScreen panel2 = new WallGameScreen();
	    
	    addKeyListener(panel2.new KeyHandler());
	
	    cardPanel.add(panel1,"1");
	    cardPanel.add(panel2,"2");
	    
	    add(cardPanel);
	
	    setVisible(true);
	}

	public static void main(String[] args)
	{
		WallMain w = new WallMain("AP Animation Demo");
	}
  
	public void changePanel() { 
	
		((CardLayout)cardPanel.getLayout()).show(cardPanel,"2");
		requestFocus();
	}
}
