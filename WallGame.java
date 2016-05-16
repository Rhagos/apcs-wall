public class WallGame
{
  public static void main(String[]  args)
  {
    Wall marker = new Wall();
    Person dude = new Person();
		marker.init();
		person.init();
		JFrame window = new JFrame();
		window.setSize(500, 500);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(marker);
		window.add(dude);
		window.setVisible(true);
  
  }
}
