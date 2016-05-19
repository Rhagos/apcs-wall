import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
/** 
 *  Main class that is called in order to run the entire program
 * */
public class WallGame
{

/** Initializes DrawingSurface and the window the program takes place in
 * */
 
  public JMenuBar setUp() throws Exception{
  	AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("MenuMusic.mp3"));
  	Clip clip = AudioSystem.getClip();
  	clip.open(inputStream);
  	clip.loop(clip.LOOP_CONTINUOUSLY);
	return null;
  	
  }
 public static void main(String[]  args)
  {
  	DrawingSurface drawing = new DrawingSurface();
  	
	Guard gaurd = new Guard(200,100);
	Alien zerg = new Alien(220, 100);
	Worker worker = new Worker(250, 150);
	JFrame window = new JFrame();
	
	drawing.addPerson(gaurd);
	drawing.addPerson(worker);
	drawing.addEnemy(zerg);
	drawing.init();
	window.setSize(500, 500);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.add(drawing);
	
	window.setVisible(true);
  
  }
}
