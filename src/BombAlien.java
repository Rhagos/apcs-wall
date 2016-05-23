

public class BombAlien extends Alien{
	public static final int PATROL_TIME = 100;
	private int patrolDir;
	private int patrolTimer;
	public BombAlien(double x, double y) {
		super("AlienSpawnSprite/Mothership_3.png", x, y, 60,60);
		patrolDir = 0;
	    patrolTimer = 0;
	}

	/**
	   * Moves the alien towards the wall
	   * @param p Player object containing the other objects
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
						  target.damageWall(2500);
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
	  
	  public WallPiece getClosest(Wall w){
		  double maxDist = Integer.MAX_VALUE;
		  WallPiece target = new WallPiece(999,999,999,w);
		  for(int i = 0; i < w.getWallParts().size(); i++){
			  WallPiece temp = w.getWallParts().get(i);
			  if(temp != null)
			  if(distanceTo(new Person(null,temp.getCenterX(),temp.getCenterY())) < maxDist){
				  maxDist = distanceTo(new Person(null,target.getCenterX(),target.getCenterY()));
				  target = w.getWallParts().get(i);
			  }
		  }
//		  if(target.equals(new WallPiece(999,999,999,w))){
//			  return null;
//		  }
		  return target;
	  }
}
