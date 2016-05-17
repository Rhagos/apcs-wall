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
  	
	Wall wall = new Wall();
	Guard gaurd = new Guard(0,0);
	Alien zerg = new Alien(0, 0);
	Worker worker = new Worker(0, 0);
	JFrame window = new JFrame();
	
	for(int i = 0; i < 7; i++){
		drawing.addPiece(new WallPiece());
	}
	drawing.addPerson((Person) gaurd);
	drawing.addPerson(worker);
	drawing.addEnemy(zerg);
	drawing.init();
	
	window.setSize(500, 500);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.add(drawing);
	
	window.setVisible(true);
  
  }
}
