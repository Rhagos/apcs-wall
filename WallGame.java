public class WallGame
{
  public static void main(String[]  args)
  {
  	DrawingSurface drawing = new DrawingSurface();
  	
	Wall wall = new Wall();
	Gaurd gaurd = new Gaurd();
    	Alien zerg = new Alien();
    	Worker worker = new Worker();
	JFrame window = new JFrame();
	window.setSize(500, 500);
		
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	drawing.addPerson(wall);
	drawing.addPerson(gaurd);
	drawing.addPerson(worker);
	drawing.addAlien(zerg);
	
	window.setVisible(true);
  
  }
}
