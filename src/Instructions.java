import javax.swing.JFrame;

import processing.core.PApplet;
/**
 *  Lists the instructions of the game 
 * */
public class Instructions extends PApplet {

	public void draw(){
		JFrame window = new JFrame();
		background(255);
		fill(255);
		//rect(100,300,300,30,7);
		rect(100,200,300,300,7);
		
		fill(0);
		textAlign(LEFT);
		text("Instructions",220,220);
		textAlign(CENTER);
		text("    The workers and defenders will routinely perform \n"+
		"their tasks autonomously and all allied units \n"+ "and structures are upgradable for various benefits ",250,250);
		
	
		window.setSize(500, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
