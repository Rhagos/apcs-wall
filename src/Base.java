
/**
 * This class represents an base of type building which aims to spawn person related objects 
 * 
 * @author Daniel Wu and Anthony Ma
 * @version 5/15/16
 * 
 **/
public class Base extends Building{
	
	private int timer;
	private static final int FIRE_TIME = 20;
	/**
	 *   Constructs a base object with a set image and set health 
	 * */
	public Base(){
		super("PersonSpawnSprite/PersonSpawn_1.png",500,75,75,75);
		setHP(100000);
	}
	/**
	 *  Base shoots nearby enemies if they get too close \
	 *  @param p Player type objects 
	 * */
	public void act(Player p){
		super.act(p);
		timer++;
		for(Alien a: p.getEnemy()){
			if(distanceTo(a) < 150 && timer >= FIRE_TIME){
				a.setHP(a.getHP()-200);
				timer = 0;
			}
		}
			
	}

}
