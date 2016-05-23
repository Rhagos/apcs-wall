
public class Spawner extends Building{
	private int timer;
	private int spawnTime;
	boolean spawn;
	public Spawner(int x, int y) {
		super("AlienSpawnSprite/Mothership_1.png", x, y, 70, 100);
		timer = 0;
		spawnTime = 100;
		spawn = true;
	}
	public void stopSpawn(){
		spawn = false;
	}
	public void act(Player p){
		super.act(p);
		timer++;
		if(timer >= spawnTime && spawn){
			timer = 0;
			
			if(Math.random() > 0.5){
				p.addEnemy((new DestroyerAlien(getX(),getY())));
				if(spawnTime <= 30){
					for(int i = 1; i <= 2; i++){
						p.addEnemy(new DestroyerAlien(getX()+i, getY()));
					}
				}
			}else{
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
