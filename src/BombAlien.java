

/**
 * This class represents an bombalien of type alien which aims to deal a one time attack to the wallpiece and then remove itself from the grid 
 * 
 * @author Daniel Wu and Anthony Ma
 * @version 5/15/16
 * 
 **/
 
public class BombAlien extends Alien{
	public static final int PATROL_TIME = 100;
	private int patrolDir;
	private int patrolTimer;
	/**
	 *   Constructs a bombalien with an inherited image, xCoord, yCoord, height, and width\
	 *  width and heigh preset 
	 *   @param x is the XCoord
	 *   @param y is the YCoord 
	 * */
	public BombAlien(double x, double y) {
		super("AlienSpawnSprite/Mothership_3.png", x, y, 60,60);
		patrolDir = 0;
	    patrolTimer = 0;
	}

	/**
	   * Moves the alien towards the wall
	   * @param p Player object containing the other object 
	   */
	  public void act(Player p){
		  super.act(p);
		  if(!getLifeStatus()){
			  Wall targetWall = p.getWall();
			  WallPiece target = getClosest(targetWall);
			  if(target == null){
				//  target = p.getHQ();
			  }
			  if(target != null){
				  if(distanceTo(new Person(null,target.getCenterX(),target.getCenterY())) < 60){
					  if(target instanceof WallPiece)
						  target.damageWall(5000);
					  else
						  target.takeDamage(5000);
					  this.setHP(-999);
				  }else{
					  if(!move((int)(directionTo(new Person(null,target.getCenterX(),target.getCenterY()))), 5,p)){
						  move(patrolDir,5,p);
						  patrolTimer++;
						  if(patrolTimer >= PATROL_TIME){
							  patrolDir += 90;
							  patrolTimer = 0;
						  }
					  }
				  }
			  }
		  }
	  }
	  /**
	   *  Detects the closet non destroyed building and moves toward it 
	   *  
	   *   @return w the closet building found 
	   * */
	  public Building getClosest(Player p){
		  double maxDist = Integer.MAX_VALUE;
		  Building target = new WallPiece(9999,9999,9999,null);
		  for(int i = 0; i < p.getWall().getWallParts().size(); i++){
			  WallPiece temp = p.getWall().getWallParts().get(i);
			  if(temp != null)
				  if(distanceTo(target) < maxDist){
					  maxDist = distanceTo(target);
					  target = p.getWall().getWallParts().get(i);
				  }
		  }
		  if(distanceTo(p.getHQ()) < maxDist)
			  target = p.getHQ();
		  return target;
	  }
}
