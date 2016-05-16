public class WallGame
{
  public static void main(String[]  args)
  {
    Wall wall = new Wall();
    Gaurd gaurd = new Gaurd();
    Alien zerg = new Alien();
    Worker worker = new Worker();
    
		wall.init();
		person.init();
		zerg.init();
		woerker.init();
		
	JFrame window = new JFrame();
	window.setSize(500, 500);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(wall);
		window.add(gaurd);
		window.add(worker);
		window.add(zerg);
		
		window.setVisible(true);
  
  }
}
