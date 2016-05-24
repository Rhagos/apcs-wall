/**
 * This class represents an spawn of type building which aims to spawn alien related objects 
 * 
 * @author Daniel Wu and Anthony Ma
 * @version 5/15/16
 * 
 **/
public class Spawner extends Building{
	private int timer;
	private int spawnTime;
	boolean spawn;
	/**
	 *   Constructs a spawn object with a set image and changable X,Y Coords Height and Width are set 
	 *   @param xCoord sets the spawn at this xCoord
	 *   @param yCoord sets the spawn at this yCoord 
	 * */
	public Spawner(int x, int y) {
		super("AlienSpawnSprite/Mothership_1.png", x, y, 70, 100);
		timer = 0;
		spawnTime = 100;
		spawn = true;
	}
	/**
	 *  Stops the spawn of the aliens
	 * */
	public void stopSpawn(){
		spawn = false;
	}
	/**
	 *  Spawns different enemies depending on chance 
	 *  @param p Player type objects 
	 * */
	public void act(Player p){
		super.act(p);
		timer++;
		if(timer >= spawnTime && spawn){
			timer = 0;
			if(Math.random() < 0.1)
			{
				p.addEnemy((new BombAlien(getX(),getY())));
				
			}
			
			if(Math.random() > 0.5){
				p.addEnemy((new DestroyerAlien(getX(),getY())));
				if(spawnTime <= 30){
					for(int i = 1; i <= 2; i++){
						p.addEnemy(new DestroyerAlien(getX()+i, getY()));
					}
				}
			}else {
				if(spawnTime <= 30){
					for(int i = 1; i <= 2; i++){
						p.addEnemy(new DestroyerAlien(getX()+i, getY()));
					}
				}
				p.addEnemy((new HunterAlien(getX(),getY())));
			}
			if(spawnTime > 30)
				spawnTime -= 2;
		}
	}

}
