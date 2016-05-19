import javax.swing.JFrame;

import processing.core.PApplet;

/**
 * 	Serve as the starting point for the program where Instruction, Main(and thus DrawingSurface) are launched 
 * */
public class Menu extends PApplet 
{
	int value = 0; 
	public void draw(){
		JFrame window = new JFrame();
		background(255);
		fill(255);
		rect(100,300,300,30,7);
		rect(100,200,300,30,7);
		
		fill(0);
		textAlign(LEFT);
		text("Instructions",225,320);
		
		textAlign(LEFT);
		text("Play the Early Access Game!",175,220);
		window.setSize(500, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}/**
	Used to recognize whether the instructions or the play button was pressed and launch the corresponding window 
	**/
	public void mouseClicked()
	{
		if((mouseX>=100&&mouseX<=400)&&(mouseY>=200&&mouseY<=230))
		{
			System.out.println("Give me more money");
		}
		if((mouseX>=100&&mouseX<=400)&&(mouseY>=300&&mouseY<=330))
		{
			System.out.println("This option only via a microtransaction of five dollars");
		}
	
	}

}
