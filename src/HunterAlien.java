import java.util.ArrayList;

/**
 * This class represents a HunterAlien of type alien which aims to deal continuos attacks to the person object and ignore wall entirely
 * 
 * @author Daniel Wu and Anthony Ma
 * @version 5/15/16
 * 
 **/

public class HunterAlien extends Alien{
	public static final int PATROL_TIME = 100;
	private int patrolDir;
	private int patrolTimer;

/**
 *  Createss a HunterAlien with default parameters at x and y 
 *	@param x x-coordinate of the guard
 * 	@param y y-coordinate of the guard
 * */
  public HunterAlien(double x, double y){
    super("AlienSprite/Alien_3.png",x,y,30,15);
    patrolDir = 0;
    patrolTimer = 0;
  }
	/**
	 *  Checks to see if an alien is within a set range of the Guard object 
	 * */
  public boolean inRange()
  {
    return false;
  }
  /**
   * Moves the guard towards the aliens
   * @param pl Player object containing the other objects
   */
  public void act(Player pl){
	  super.act(pl);
	  if(!getLifeStatus()){
		  Person target = getClosest(pl);
		  if(target!= null && distanceTo(target) < 999){
			  if(distanceTo(target) < 20){
				  target.setHP(target.getHP()-1);
				  if(target.getHP() <= 0){
					  target = getClosest(pl);
				  }
			  }else{
				  if(!move((int)(directionTo(target)),5,pl)){
					  move(patrolDir,5,pl);
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
   *   Returns the closest Person location to the hunteralien
   *   @param pl Player object containing the other objects
   * */
  public Person getClosest(Player pl){
	  
	  double minDist = Integer.MAX_VALUE;
	  ArrayList<Person> ays = pl.getHired();
	  Person target = null;
	  for(int i = 0; i < ays.size(); i++){
		  Person ay = ays.get(i);
		  if(distanceTo(ay) < minDist){
			  target = ay;
		  }
	  }
	  return target;
  }
}
