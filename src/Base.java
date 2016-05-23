
public class Base extends Building{
	
	private int timer;
	private static final int FIRE_TIME = 20;
	
	public Base(){
		super("PersonSpawnSprite/PersonSpawn_1.png",100,50,75,75);
		setHP(100000);
	}
	
	public void act(Player p){
		super.act(p);
		timer++;
		for(Alien a: p.getEnemy()){
			if(distanceTo(a) < 75 && timer >= FIRE_TIME){
				a.setHP(a.getHP()-200);
				timer = 0;
			}
		}
			
	}

}