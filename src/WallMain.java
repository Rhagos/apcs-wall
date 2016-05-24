import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WallMain extends JFrame{
	JPanel cardPanel;
	public WallMain(String title) {
		super(title);
		setBounds(100, 100, 1000, 1000);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
		WallRunnerScreen panel1 = new WallRunnerScreen(this);    
	    WallGameScreen panel2 = new WallGameScreen(this);
	    WallBuyScreen panel3 = new WallBuyScreen(this,panel2);
	    WallInstructionsScreen panel4 = new WallInstructionsScreen(this);
	    WallGameOverScreen panel5 = new WallGameOverScreen(this);
	    addKeyListener(panel2.new KeyHandler());
	    addMouseListener(panel2.new MouseHandler());
	
	    cardPanel.add(panel1,"1");
	    cardPanel.add(panel2,"2");
	    cardPanel.add(panel3,"3");
	    cardPanel.add(panel4,"4");
	    cardPanel.add(panel5,"5");
	    
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
	public void changeToBuy()	{
		((CardLayout)cardPanel.getLayout()).show(cardPanel, "3");
		requestFocus();
	}
	public void changeToHelp(){
		((CardLayout)cardPanel.getLayout()).show(cardPanel, "4");
		requestFocus();
	}
	public void changeToDead(){
		((CardLayout)cardPanel.getLayout()).show(cardPanel, "5");
		requestFocus();
	}
}
