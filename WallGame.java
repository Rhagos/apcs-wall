import javax.swing.JFrame;
/** 
 *  Main class that is called in order to run the entire program
 * */
public class WallGame
{

/** Initializes DrawingSurface and the window the program takes place in
 * */
  public static void main(String[]  args)
  {
  	DrawingSurface drawing = new DrawingSurface();
  	
	Wall wall = new Wall();
	Guard gaurd = new Guard(0,0);
	Alien zerg = new Alien(0, 0);
	Worker worker = new Worker(0, 0);
	JFrame window = new JFrame();
	
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
