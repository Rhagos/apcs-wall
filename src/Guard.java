import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/** 
 *  This class represents a guard who is a typer Person and thus has all of Person qualities
 *   @author Daniel Wu and Anthony Ma
 *   @version 5/15/16
 * */
public class Guard extends Person{
	public static final int PATROL_TIME = 20;
	private int patrolDir;
	private int patrolTimer;

/**
 *  Creates a Guard with default parameters at x and y 
 *	@param x x-coordinate of the guard
 * 	@param y y-coordinate of the guard
 * */
  public Guard(double x, double y){
    super("GuardSprite/Guard_1.png",x,y);
    patrolDir = 0;
    patrolTimer = 0;
    setHP(500);
  }
/**
*  Checks to see if an alien is within a set range of the Guard object 
* */
  public boolean inRange()
  {
    return false;
  }
  /**
   *  Sets the image that a default guard looks like
   * */
  public Image getImage()
  {
	  return new ImageIcon("GuardSprite/Guard_1.png").getImage();
	  
  }
  /**
   *  Returns the type of person the guard is 
   * */
  public String getType(){
	  return "Guard";
  }
  /**
   * Moves the guard towards the aliens
   * @param pl Player object containing the other objects
   */
  public void act(Player pl){
	  super.act(pl);
	  Alien target = getClosest(pl);
	  if(target!= null && distanceTo(target) < 700){
		  if(distanceTo(target) < 150){
			  target.setHP(target.getHP()-5);
		  }else{
			  if(!move((int)(directionTo(target)),5,pl)){
				  move(patrolDir,5,pl);
				  patrolTimer++;
				  if(patrolTimer >= PATROL_TIME){
					  patrolDir += 180;
					  patrolTimer = 0;
				  } 
			  }
		  }
	  }else{
		  move(patrolDir,5,pl);
		  patrolTimer++;
		  if(patrolTimer >= PATROL_TIME){
			  patrolDir += 180;
			  patrolTimer = 0;
		  }
	  }
	  
	  
  }
  /**
   *   Returns the closest Alien location to the person 
   *   @param pl Player object containing the other objects
   * */
  public Alien getClosest(Player pl){
	  
	  double minDist = Integer.MAX_VALUE;
	  ArrayList<Alien> ays = pl.getEnemy();
	  Alien target = null;
	  for(int i = 0; i < ays.size(); i++){
		  Alien ay = ays.get(i);
		  if(distanceTo(ay) < minDist){
			  target = ay;
		  }
	  }
	  return target;
  }

}
